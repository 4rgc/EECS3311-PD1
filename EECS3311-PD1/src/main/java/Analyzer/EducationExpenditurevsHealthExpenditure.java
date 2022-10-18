package Analyzer;

import Fetchers.EducationExpenditureFetcher;
import Fetchers.HealthExpenditureFetcher;

import java.util.Map;

public class EducationExpenditurevsHealthExpenditure {

    protected Map<String, Double> EducationExpenditureData;
    protected Map<String, Double> HealthExpenditureData;

    public EducationExpenditurevsHealthExpenditure(String sYear, String eYear, String country) {
        this.EducationExpenditureData = (new EducationExpenditureFetcher(sYear, eYear, country)).getData();
        this.HealthExpenditureData = (new HealthExpenditureFetcher(sYear, eYear, country)).getData();
    }
}
