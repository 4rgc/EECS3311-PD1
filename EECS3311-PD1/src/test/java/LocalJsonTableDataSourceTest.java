import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.example.IRecord;
import org.example.JsonRecord;
import org.example.LocalJsonTableDataSource;
import org.example.LocalJsonTableDataSource.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LocalJsonTableDataSourceTest {
    private String createACopyOfAFile(String originalFilePath) throws IOException {
        String origFileString = getFileAsString(originalFilePath);

        String randomString = getRandomString();

        String copyFilePath = originalFilePath + "." + randomString;
        File copy = new File(copyFilePath);
        copy.createNewFile();

        writeToFile(origFileString, copy);

        return copyFilePath;
    }

    private static String getFileAsString(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return readFromFile(file);
    }

    private static String readFromFile(File file) throws FileNotFoundException {
        String fileString = "";
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            fileString += data;
        }
        myReader.close();
        return fileString;
    }

    private static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("_", "");
    }

    private static void writeToFile(String contents, File file) throws IOException {
        FileWriter myWriter = new FileWriter(file, false);
        myWriter.write(contents);
        myWriter.close();
    }

    private void deleteFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }

    private String tempDbFilePath;

    @BeforeEach
    public void BeforeEach() throws IOException {
        tempDbFilePath = createACopyOfAFile("src/test/resources/usertestdb.json");
    }

    @AfterEach
    public void AfterEach() {
        deleteFile(tempDbFilePath);
        tempDbFilePath = null;
    }

    @Test
    public void ConstructsWithNoExceptionTest() {
        assertDoesNotThrow(() ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb.json"
                ).close()
        );
    }

    @Test
    public void NoMetaExceptionOnConstructionTest() {
        assertThrows(NoMetaException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_nometa.json"
                ).close()
        );
    }

    @Test
    public void NoColumnsExceptionOnConstructionTest() {
        assertThrows(NoColumnsException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_nocolumns.json"
                ).close()
        );
    }

    @Test
    public void JsonExceptionOnConstructionTest() {
        assertThrows(JSONException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_malformed.json"
                ).close()
        );
    }

    @Test
    public void UnexpectedStructureExceptionOnConstructionExtraFieldTest() {
        assertThrows(UnexpectedStructureException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_extra_field_unexpected.json"
                ).close()
        );
    }

    @Test
    public void UnexpectedStructureExceptionOnConstructionMissingFieldTest() {
        assertThrows(UnexpectedStructureException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_missing_field_unexpected.json"
                ).close()
        );
    }

    @Test
    public void DbFileNotFoundExceptionOnNonExistentFile() {
        assertThrows(DbFileNotFoundException.class, () ->
                new LocalJsonTableDataSource(
                        "src/test/resources/usertestdb_nonexistent.json"
                ).close()
        );
    }

    @Test
    public void GetKeysTest() {
        List<String> expectedKeys = Arrays.asList("&^812bc", "q23fasdfg", "asdgasdgb");

        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource(
                            "src/test/resources/usertestdb.json"
                    )
        ) {
            List<String> actualKeys = Arrays.asList(dataSource.getKeys());
            for (String expectedKey: expectedKeys) {
                assertTrue(actualKeys.contains(expectedKey));
            }
            for (String actualKey: actualKeys) {
                assertTrue(expectedKeys.contains(actualKey));
            }
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void GetColumnsTest() {
        List<String> expectedColumns = Arrays.asList("username", "password");

        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource(
                            "src/test/resources/usertestdb.json"
                    )
        ) {
            List<String> actualColumns = Arrays.asList(dataSource.getColumns());
            for (String expectedColumn: expectedColumns) {
                assertTrue(actualColumns.contains(expectedColumn));
            }
            for (String actualColumn: actualColumns) {
                assertTrue(expectedColumns.contains(actualColumn));
            }
        } catch(Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void GetExistingRecordTest() {
        try(LocalJsonTableDataSource dataSource =
                new LocalJsonTableDataSource("src/test/resources/usertestdb.json")
        ) {
            IRecord record = dataSource.getRecord("&^812bc");
            assertNotNull(record);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void GetNonExistingRecordTest() {
        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource("src/test/resources/usertestdb.json")
        ) {
            IRecord record = dataSource.getRecord("nonexisting");
            assertNotNull(record);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void CreateValidRecordTest() {
        JsonRecord newRecord = new JsonRecord(
                getRandomString(),
                JSONObject.parseObject("{\"username\": \"user\", \"password\": \"pw\"}")
        );

        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource(tempDbFilePath)
        ) {
            IRecord record = dataSource.createRecord(newRecord);
            assertNotNull(record);
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void CreateInvalidRecordExtraFieldTest() {
        JsonRecord newRecord = new JsonRecord(
                getRandomString(),
                JSONObject.parseObject("{\"username\": \"user\", \"password\": \"pw\", \"extrafield\": \"huh\"}")
        );

        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource(tempDbFilePath)
        ) {
            assertThrows(InvalidRecordException.class, () -> dataSource.createRecord(newRecord));
        } catch (Exception e) {
            assertNull(e);
        }
    }

    @Test
    public void CreateInvalidRecordMissingFieldTest() {
        JsonRecord newRecord = new JsonRecord(
                getRandomString(),
                JSONObject.parseObject("{\"username\": \"user\"}")
        );

        try(LocalJsonTableDataSource dataSource =
                    new LocalJsonTableDataSource(tempDbFilePath)
        ) {
            assertThrows(InvalidRecordException.class, () -> dataSource.createRecord(newRecord));
        } catch (Exception e) {
            assertNull(e);
        }
    }
}
