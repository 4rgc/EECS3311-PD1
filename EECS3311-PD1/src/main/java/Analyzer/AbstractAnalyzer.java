package Analyzer;

import org.example.WbApiModel;

public abstract class AbstractAnalyzer {
    protected String sYear;
    protected String eYear;
    protected String country;

    AbstractAnalyzer(String sYear, String eYear, String country){
        this.country = country;
        this.sYear = sYear;
        this.eYear = eYear;
    }

    public String getsYear() {
        return sYear;
    }

    public void setsYear(String sYear) {
        this.sYear = sYear;
    }

    public String geteYear() {
        return eYear;
    }

    public void seteYear(String eYear) {
        this.eYear = eYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public abstract AnalysisResult recalculate() throws WbApiModel.WbApiModelException;
    public abstract AnalysisResult recalculate(String sYear, String eYear, String country) throws WbApiModel.WbApiModelException;

}
