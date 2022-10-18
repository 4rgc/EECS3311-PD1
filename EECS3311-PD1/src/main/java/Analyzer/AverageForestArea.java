package Analyzer;

import Fetchers.ForestAreaFetcher;

import java.util.Map;

public class AverageForestArea {
    protected Map<String, Double> ForestAreaData;

    public AverageForestArea(String sYear, String eYear, String country) {
        this.ForestAreaData = (new ForestAreaFetcher(sYear, eYear, country)).getData();
    }

}
