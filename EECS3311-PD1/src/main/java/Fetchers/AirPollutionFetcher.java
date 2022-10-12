package Fetchers;


public class airPollutionFetcher extends AbstractFetcher{
    public airPollutionFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorId = "EN.ATM.PM25.MC.M3";
    }

}