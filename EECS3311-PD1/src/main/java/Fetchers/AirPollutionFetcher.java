package Fetchers;


public class AirPollutionFetcher extends AbstractFetcher{
    public AirPollutionFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorId = "EN.ATM.PM25.MC.M3";
    }

}