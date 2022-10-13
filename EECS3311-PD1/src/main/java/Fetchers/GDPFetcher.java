package Fetchers;


public class GDPFetcher extends AbstractFetcher {
    public GDPFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorID = "NY.GDP.PCAP.CD";
    }
}