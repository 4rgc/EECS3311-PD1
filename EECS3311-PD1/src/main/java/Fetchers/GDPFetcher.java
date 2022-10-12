package Fetchers;


public class GDPFetcher extends AbstractFetcher {
    public GDPFetcher(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
        this.indicatorId = "NY.GDP.PCAP.CD";
    }
}