package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.Map;

public class ProblemsIAHCvsMortalityRate extends AbstractAnalyzer{
    private Map<String, Double> ProblemsIAHCData;
    private Map<String, Double> MortalityRateData;

    public ProblemsIAHCvsMortalityRate(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher absFetch = new ProblemsIAHCFetcher(this.sYear, this.eYear, this.country);
        this.ProblemsIAHCData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new GDPFetcher(this.sYear, this.eYear, this.country);
        this.MortalityRateData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        return new AnalysisResult(this.ProblemsIAHCData, this.MortalityRateData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) throws WbApiModel.WbApiModelException {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }

}
