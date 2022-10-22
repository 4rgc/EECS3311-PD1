package Analyzer;

import Fetchers.AbstractFetcher;
import Fetchers.AirPollutionFetcher;
import Fetchers.EducationExpenditureFetcher;
import Fetchers.ForestAreaFetcher;
import org.example.WbApiModel;

import java.util.Map;

public class AverageExpenditureOnEducation extends AbstractAnalyzer {
    private Map<String, Double> EducationExpenditureData;


    public AverageExpenditureOnEducation(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[1];
        AbstractFetcher absFetch = new AirPollutionFetcher(this.sYear, this.eYear, this.country);
        this.EducationExpenditureData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        return new AnalysisResult(this.EducationExpenditureData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) throws WbApiModel.WbApiModelException {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }
}
