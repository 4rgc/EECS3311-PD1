package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.AirPollutionFetcher;
import Fetchers.ForestAreaFetcher;

import java.util.Map;

public class AverageForestArea extends AbstractAnalyzer{
    private Map<String, Double> ForestAreaData;

    public AverageForestArea(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() {
        String[] labels = new String[1];
        AbstractFetcher absFetch = new ForestAreaFetcher(this.sYear, this.eYear, this.country);
        this.ForestAreaData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        return new AnalysisResult(this.ForestAreaData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }
}
