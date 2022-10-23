package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.Map;

public class CO2vsEnergyUsevsAirPollution extends AbstractAnalyzer{
    private Map<String, Double> CO2Data;
    private Map<String, Double> EnergyUseData;
    private Map<String, Double> AirPollutionData;

    public CO2vsEnergyUsevsAirPollution(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }
    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[3];
        AbstractFetcher absFetch = new CO2Fetcher(this.sYear, this.eYear, this.country);
        this.CO2Data = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new EnergyUseFetcher(this.sYear, this.eYear, this.country);
        this.EnergyUseData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        absFetch = new AirPollutionFetcher(this.sYear, this.eYear, this.country);
        this.AirPollutionData = absFetch.getData();
        labels[2] = absFetch.getLabel();

        return new AnalysisResult(this.CO2Data, this.EnergyUseData, this.AirPollutionData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) throws WbApiModel.WbApiModelException {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }
}
