package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HealthCareAccessProblemsVsMortalityRate extends AbstractAnalyzer{
    private Map<String, Double> HealthCareAccessProblems;
    private Map<String, Double> MortalityRateData;

    public HealthCareAccessProblemsVsMortalityRate(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new HealthCareAccessProblemsFetcher(this.startYear, this.endYear, this.country);
        this.HealthCareAccessProblems = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new GdpFetcher(this.startYear, this.endYear, this.country);
        this.MortalityRateData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.HealthCareAccessProblems,
                this.MortalityRateData
        )), labels);
    }
}
