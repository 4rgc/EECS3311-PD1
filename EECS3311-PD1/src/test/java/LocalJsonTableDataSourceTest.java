import com.alibaba.fastjson.JSONException;
import org.example.IRecord;
import org.example.LocalJsonTableDataSource;
import org.example.LocalJsonTableDataSource.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocalJsonTableDataSourceTest {
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
}
