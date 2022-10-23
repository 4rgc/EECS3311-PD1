package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CO2vsEnergyUsevsAirPollution extends AbstractAnalyzer{
    private Map<String, Double> CO2Data;
    private Map<String, Double> EnergyUseData;
    private Map<String, Double> AirPollutionData;

    public CO2vsEnergyUsevsAirPollution(String startYear, String endYear, String country) {
        super(startYear, endYear, country);
    }
    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[3];
        AbstractFetcher fetcher = new CO2Fetcher(this.startYear, this.endYear, this.country);
        this.CO2Data = fetcher.getData();
        labels[0] = fetcher.getLabel();

        fetcher = new EnergyUseFetcher(this.startYear, this.endYear, this.country);
        this.EnergyUseData = fetcher.getData();
        labels[1] = fetcher.getLabel();

        fetcher = new AirPollutionFetcher(this.startYear, this.endYear, this.country);
        this.AirPollutionData = fetcher.getData();
        labels[2] = fetcher.getLabel();

        return new AnalysisResult(new ArrayList<>(Arrays.asList(
                this.CO2Data,
                this.EnergyUseData,
                this.AirPollutionData
        )), labels);
    }
}
