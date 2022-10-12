package Fetchers;


public class HospitalBedsFetcher extends AbstractFetcher {
    public HospitalBedsFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "SH.MED.BEDS.ZS";
    }
}