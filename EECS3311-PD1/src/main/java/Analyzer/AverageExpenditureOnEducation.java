package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.AirPollutionFetcher;
import Fetchers.EducationExpenditureFetcher;
import Fetchers.ForestAreaFetcher;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AverageExpenditureOnEducation extends AbstractAnalyzer {
    private Map<String, Double> EducationExpenditureData;

    public AverageExpenditureOnEducation(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[1];
        AbstractFetcher fetcher = new EducationExpenditureFetcher(this.startYear, this.endYear, this.country);
        this.EducationExpenditureData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.EducationExpenditureData
        )), labels);
    }
}
