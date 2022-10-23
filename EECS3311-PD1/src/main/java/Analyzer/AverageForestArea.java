package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.ForestAreaFetcher;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AverageForestArea extends AbstractAnalyzer{
    private Map<String, Double> ForestAreaData;

    public AverageForestArea(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[1];
        AbstractFetcher fetcher = new ForestAreaFetcher(this.startYear, this.endYear, this.country);
        this.ForestAreaData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.ForestAreaData
        )), labels);
    }
}
