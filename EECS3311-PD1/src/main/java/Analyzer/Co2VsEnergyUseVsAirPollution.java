package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Co2VsEnergyUseVsAirPollution extends AbstractAnalyzer{
    private Map<String, Double> Co2Data;
    private Map<String, Double> EnergyUseData;
    private Map<String, Double> AirPollutionData;

    public Co2VsEnergyUseVsAirPollution(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }
    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[3];
        AbstractFetcher fetcher = new Co2Fetcher(this.startYear, this.endYear, this.country);
        this.Co2Data = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new EnergyUseFetcher(this.startYear, this.endYear, this.country);
        this.EnergyUseData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        fetcher = new AirPollutionFetcher(this.startYear, this.endYear, this.country);
        this.AirPollutionData = fetcher.getData();
        labels[2] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.Co2Data,
                this.EnergyUseData,
                this.AirPollutionData
        )), labels);
    }
}
