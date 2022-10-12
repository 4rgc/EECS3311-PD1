package Fetchers;


public class ProblemsIAHCFetcher extends AbstractFetcher {
    public ProblemsIAHCFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "SH.ACS.MONY.Q1.ZS";
    }
}