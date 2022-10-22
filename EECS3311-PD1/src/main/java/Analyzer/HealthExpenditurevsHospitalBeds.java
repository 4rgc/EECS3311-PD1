package Analyzer;

import Fetchers.*;
import org.example.WbApiModel;

import java.util.Map;

public class HealthExpenditurevsHospitalBeds extends AbstractAnalyzer{
    private Map<String, Double> HealthExpenditureData;
    private Map<String, Double> HospitalBedsData;

    public HealthExpenditurevsHospitalBeds(String sYear, String eYear, String country) {
        super(sYear, eYear, country);
    }

    public AnalysisResult recalculate() throws WbApiModel.WbApiModelException {
        String[] labels = new String[2];
        AbstractFetcher absFetch = new HealthExpenditureFetcher(this.sYear, this.eYear, this.country);
        this.HealthExpenditureData = absFetch.getData();
        labels[0] = absFetch.getLabel();

        absFetch = new HospitalBedsFetcher(this.sYear, this.eYear, this.country);
        this.HospitalBedsData = absFetch.getData();
        labels[1] = absFetch.getLabel();

        return new AnalysisResult(this.HealthExpenditureData, this.HospitalBedsData, labels);
    }

    public AnalysisResult recalculate(String sYear, String eYear, String country) throws WbApiModel.WbApiModelException {
        setCountry(country); setsYear(sYear); seteYear(eYear);
        return this.recalculate();
    }

}
