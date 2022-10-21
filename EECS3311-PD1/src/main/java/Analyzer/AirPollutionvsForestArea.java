package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.AirPollutionFetcher;
import Fetchers.ForestAreaFetcher;

import java.util.Map;

public class AirPollutionvsForestArea extends AbstractAnalyzer{
    private Map<String, Double> AirPollutionData;
    private Map<String, Double> ForestAreaData;

    public AirPollutionvsForestArea(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() {
        String[] labels = new String[2];
        AbstractFetcher absFetch = new AirPollutionFetcher(this.sYear, this.eYear, this.country);
        this.AirPollutionData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new ForestAreaFetcher(this.sYear, this.eYear, this.country);
        this.ForestAreaData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        return new AnalysisResult(this.AirPollutionData, this.ForestAreaData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }
}
