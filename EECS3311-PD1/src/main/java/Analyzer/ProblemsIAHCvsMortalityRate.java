package Analyzer;

import Fetchers.MortalityRateFetcher;
import Fetchers.ProblemsIAHCFetcher;

import java.util.Map;

public class ProblemsIAHCvsMortalityRate {
    protected Map<String, Double> ProblemsIAHCData;
    protected Map<String, Double> MortalityRateData;
    public ProblemsIAHCvsMortalityRate(String sYear, String eYear, String country) {
        this.ProblemsIAHCData = (new ProblemsIAHCFetcher(sYear, eYear, country)).getData();
        this.MortalityRateData = (new MortalityRateFetcher(sYear, eYear, country)).getData();
    }
}
