package Analyzer;

import Fetchers.AirPollutionFetcher;
import Fetchers.ForestAreaFetcher;

import java.util.Map;

public class AirPollutionvsForestArea {
    protected Map<String, Double> AirPollutionData;
    protected Map<String, Double> ForestAreaData;

    public AirPollutionvsForestArea(String sYear, String eYear, String country) {
        this.AirPollutionData = (new AirPollutionFetcher(sYear, eYear, country)).getData();
        this.ForestAreaData = (new ForestAreaFetcher(sYear, eYear, country)).getData();
    }
}
