package Fetchers;


public class EnergyUseFetcher extends AbstractFetcher {
    public EnergyUseFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "EG.USE.PCAP.KG.OE";
    }
}