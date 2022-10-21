package Fetchers;


public class ProblemsIAHCFetcher extends AbstractFetcher {
    public ProblemsIAHCFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "SH.ACS.MONY.Q1.ZS";
    }
    public String getLabel(){return "IAHC";}
}