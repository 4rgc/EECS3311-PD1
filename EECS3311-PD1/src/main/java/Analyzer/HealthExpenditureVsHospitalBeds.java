package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HealthExpenditureVsHospitalBeds extends AbstractAnalyzer{
    private Map<String, Double> HealthExpenditureData;
    private Map<String, Double> HospitalBedsData;

    public HealthExpenditureVsHospitalBeds(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher fetcher = new HealthExpenditureFetcher(this.startYear, this.endYear, this.country);
        this.HealthExpenditureData = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new HospitalBedsFetcher(this.startYear, this.endYear, this.country);
        this.HospitalBedsData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.HealthExpenditureData,
                this.HospitalBedsData
        )), labels);
    }
}
