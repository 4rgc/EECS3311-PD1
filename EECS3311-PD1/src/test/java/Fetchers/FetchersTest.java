package Fetchers;

import org.example.WbApiModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FetchersTest {
    private String startYear;
    private String endYear;
    private String country;

    @BeforeEach
    public void setupParameters(){
        startYear = "2000";
        endYear = "2001";
        country = "can";
    }

    @Test
    void airPollutionTester() {
        AirPollutionFetcher airPollution = new AirPollutionFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(airPollution.getData());
            Assertions.assertEquals(map.get("2000"), 8.2809835638994);
            Assertions.assertNull(map.get("2001"));
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void co2Tester() {
        CO2Fetcher co2 = new CO2Fetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(co2.getData());
            Assertions.assertEquals(map.get("2000"), 16.7576264276587);
            Assertions.assertEquals(map.get("2001"), 16.3315689530885);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void educationExpenditureTester() {
        EducationExpenditureFetcher educationExpindenture = new EducationExpenditureFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(educationExpindenture.getData());
            Assertions.assertEquals(map.get("2000"), 12.9826002120972);
            Assertions.assertEquals(map.get("2001"), 12.2122402191162);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void energyUseTester() {
        EnergyUseFetcher energyUse = new EnergyUseFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(energyUse.getData());
            Assertions.assertEquals(map.get("2000"), 8265.07992477285);
            Assertions.assertEquals(map.get("2001"), 8056.3494253004);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void forestAreaTester() {
        ForestAreaFetcher forestArea = new ForestAreaFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(forestArea.getData());
            Assertions.assertEquals(map.get("2000"), 38.7929818338782);
            Assertions.assertEquals(map.get("2001"), 38.7876307080739);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void gdpTester() {
        GDPFetcher gdp = new GDPFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(gdp.getData());
            Assertions.assertEquals(map.get("2000"), 24271.0020563821);
            Assertions.assertEquals(map.get("2001"), 23822.0601178964);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void healthExpenditureTester() {
        HealthExpenditureFetcher healthExpenditure = new HealthExpenditureFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(healthExpenditure.getData());
            Assertions.assertEquals(map.get("2000"), 8.24814415);
            Assertions.assertEquals(map.get("2001"), 8.62482357);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void hospitalBedsTester() {
        HospitalBedsFetcher hospitalBeds = new HospitalBedsFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(hospitalBeds.getData());
            Assertions.assertEquals(map.get("2000"), 3.77);
            Assertions.assertEquals(map.get("2001"), 3.69);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void mortalityRateTester() {
        MortalityRateFetcher mortalityRate = new MortalityRateFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(mortalityRate.getData());
            Assertions.assertEquals(map.get("2000"), 9);
            Assertions.assertEquals(map.get("2001"), 10);
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void problemsIAHCTester() {
        ProblemsIAHCFetcher problemsIAHC = new ProblemsIAHCFetcher(startYear, endYear, country);
        try {
            Map<String, Double> map = new HashMap<String, Double>(problemsIAHC.getData());
            Assertions.assertNull(map.get("2000"));
            Assertions.assertNull(map.get("2001"));
        } catch (WbApiModel.WbApiModelException e) {
            throw new RuntimeException(e);
        }
    }
}