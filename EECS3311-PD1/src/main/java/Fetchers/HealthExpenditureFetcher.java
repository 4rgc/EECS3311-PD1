package Fetchers;


public class HealthExpenditureFetcher extends AbstractFetcher {
    public HealthExpenditureFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "SH.XPD.CHEX.GD.ZS";
    }
}