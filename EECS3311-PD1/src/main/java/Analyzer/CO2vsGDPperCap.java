package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.CO2Fetcher;
import Fetchers.GDPFetcher;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CO2vsGDPperCap extends AbstractAnalyzer{
    private Map<String, Double> CO2Data;
    private Map<String, Double> GDPperCapData;

    public CO2vsGDPperCap(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new CO2Fetcher(this.startYear, this.endYear, this.country);
        this.CO2Data = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new GDPFetcher(this.startYear, this.endYear, this.country);
        this.GDPperCapData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.CO2Data,
                this.GDPperCapData
        )), labels);
    }
}
