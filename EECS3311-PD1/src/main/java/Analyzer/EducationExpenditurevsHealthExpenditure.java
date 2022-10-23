package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class EducationExpenditurevsHealthExpenditure extends AbstractAnalyzer{

    private Map<String, Double> EducationExpenditureData;
    private Map<String, Double> HealthExpenditureData;

    public EducationExpenditurevsHealthExpenditure(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new EducationExpenditureFetcher(this.startYear, this.endYear, this.country);
        this.EducationExpenditureData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new HealthExpenditureFetcher(this.startYear, this.endYear, this.country);
        this.HealthExpenditureData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.EducationExpenditureData,
                this.HealthExpenditureData
        )), labels);
    }
}
