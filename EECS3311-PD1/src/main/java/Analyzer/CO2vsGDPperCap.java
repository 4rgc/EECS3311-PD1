package Analyzer;

import Fetchers.CO2Fetcher;
import Fetchers.GDPFetcher;

import java.util.Map;

public class CO2vsGDPperCap {
    protected Map<String, Double> CO2Data;
    protected Map<String, Double> GDPperCapData;

    public CO2vsGDPperCap(String sYear, String eYear, String country) {
        this.CO2Data = (new CO2Fetcher(sYear, eYear, country)).getData();
        this.GDPperCapData = (new GDPFetcher(sYear, eYear, country)).getData();
    }
}
