package Fetchers;


public class EducationExpenditureFetcher extends AbstractFetcher {
    public EducationExpenditureFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "SE.XPD.TOTL.GB.ZS";
    }
}