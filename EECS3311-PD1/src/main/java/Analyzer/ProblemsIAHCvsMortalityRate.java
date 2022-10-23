package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ProblemsIAHCvsMortalityRate extends AbstractAnalyzer{
    private Map<String, Double> ProblemsIAHCData;
    private Map<String, Double> MortalityRateData;

    public ProblemsIAHCvsMortalityRate(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new ProblemsIAHCFetcher(this.startYear, this.endYear, this.country);
        this.ProblemsIAHCData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new GDPFetcher(this.startYear, this.endYear, this.country);
        this.MortalityRateData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.ProblemsIAHCData,
                this.MortalityRateData
        )), labels);
    }
}
