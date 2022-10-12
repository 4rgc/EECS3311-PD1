package Fetchers;


public class ForestAreaFetcher extends AbstractFetcher {
    public ForestAreaFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "AG.LND.FRST.ZS";
    }
}