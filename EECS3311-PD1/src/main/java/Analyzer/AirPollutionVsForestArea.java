package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.AirPollutionFetcher;
import Fetchers.ForestAreaFetcher;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AirPollutionVsForestArea extends AbstractAnalyzer{
    private Map<String, Double> AirPollutionData;
    private Map<String, Double> ForestAreaData;

    public AirPollutionVsForestArea(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new AirPollutionFetcher(this.startYear, this.endYear, this.country);
        this.AirPollutionData = fetcher.getData();
        labels[0] = fetcher.getLabel();


        fetcher = new ForestAreaFetcher(this.startYear, this.endYear, this.country);
        this.ForestAreaData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.AirPollutionData,
                this.ForestAreaData
        )), labels);
    }
}
