package Analyzer;

import Fetchers.HealthExpenditureFetcher;
import Fetchers.HospitalBedsFetcher;

import java.util.Map;

public class HealthExpenditurevsHospitalBeds {
    protected Map<String, Double> HealthExpenditureData;
    protected Map<String, Double> HospitalBedsData;

    public HealthExpenditurevsHospitalBeds(String sYear, String eYear, String country) {
        this.HealthExpenditureData= (new HealthExpenditureFetcher(sYear, eYear, country)).getData();
        this.HospitalBedsData= (new HospitalBedsFetcher(sYear, eYear, country)).getData();
    }
}
