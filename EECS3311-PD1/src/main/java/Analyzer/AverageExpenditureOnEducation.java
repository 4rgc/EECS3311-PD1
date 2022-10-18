package Analyzer;

import Fetchers.EducationExpenditureFetcher;
import java.util.Map;

public class AverageExpenditureOnEducation {
    protected Map<String, Double> EducationExpenditureData;

    public AverageExpenditureOnEducation(String sYear, String eYear, String country) {
        this.EducationExpenditureData = (new EducationExpenditureFetcher(sYear, eYear, country)).getData();
    }

}
