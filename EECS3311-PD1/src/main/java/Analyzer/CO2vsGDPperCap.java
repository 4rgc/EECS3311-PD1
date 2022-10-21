package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.CO2Fetcher;
import Fetchers.ForestAreaFetcher;
import Fetchers.GDPFetcher;

import java.util.Map;

public class CO2vsGDPperCap extends AbstractAnalyzer{
    private Map<String, Double> CO2Data;
    private Map<String, Double> GDPperCapData;

    public CO2vsGDPperCap(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() {
        String[] labels = new String[2];
        AbstractFetcher absFetch = new CO2Fetcher(this.sYear, this.eYear, this.country);
        this.CO2Data = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new GDPFetcher(this.sYear, this.eYear, this.country);
        this.GDPperCapData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        return new AnalysisResult(this.CO2Data, this.GDPperCapData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }
}
