package Analyzer;

import Fetchers.*;

import java.util.Map;

public class EducationExpenditurevsHealthExpenditure extends AbstractAnalyzer{

    private Map<String, Double> EducationExpenditureData;
    private Map<String, Double> HealthExpenditureData;

    public EducationExpenditurevsHealthExpenditure(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() {
        String[] labels = new String[2];
        AbstractFetcher absFetch = new EducationExpenditureFetcher(this.sYear, this.eYear, this.country);
        this.EducationExpenditureData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new HealthExpenditureFetcher(this.sYear, this.eYear, this.country);
        this.HealthExpenditureData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        return new AnalysisResult(this.EducationExpenditureData, this.HealthExpenditureData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }

}
