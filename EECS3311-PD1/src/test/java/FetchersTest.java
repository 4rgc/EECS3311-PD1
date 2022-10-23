import Fetchers.AbstractFetcher;
import Fetchers.HospitalBedsFetcher;
import org.junit.jupiter.api.Test;

public class FetchersTest {

    @Test
    public void testing(){
        AbstractFetcher fetcher = new HospitalBedsFetcher("2000", "2001", "CA");
    }

    

}
