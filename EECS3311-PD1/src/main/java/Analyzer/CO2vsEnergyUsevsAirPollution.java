package Analyzer;

import Fetchers.AirPollutionFetcher;
import Fetchers.CO2Fetcher;
import Fetchers.EnergyUseFetcher;

import java.util.Map;

public class CO2vsEnergyUsevsAirPollution {
    protected Map<String, Double> CO2Data;
    protected Map<String, Double> EnergyUseData;
    protected Map<String, Double> AirPollutionData;

    public CO2vsEnergyUsevsAirPollution(String sYear, String eYear, String country) {
        this.CO2Data = (new CO2Fetcher(sYear, eYear, country)).getData();
        this.EnergyUseData = (new EnergyUseFetcher(sYear, eYear, country)).getData();
        this.AirPollutionData = (new AirPollutionFetcher(sYear, eYear, country)).getData();
    }
}
