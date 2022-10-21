package Analyzer;

import java.util.HashMap;
import java.util.Map;

public class AnalysisResult {
    private Map<String, Double> firstData;

    private Map<String, Double> secondData;

    private Map<String, Double> thirdData;
    private String[] Labels;

    public AnalysisResult(Map<String, Double> firstData, String[] Label){
        this.firstData = firstData;
        this.secondData = null;
        this.thirdData = null;
        this.Labels = Label;
    }

    public AnalysisResult(Map<String, Double> firstData,
                          Map<String, Double> secondData,
                          String[] Label){
        this.firstData = firstData;
        this.secondData=secondData;
        this.thirdData = null;
        this.Labels = Label;
    }

    public AnalysisResult(Map<String, Double> firstData,
                          Map<String, Double> secondData,
                          Map<String, Double> thirdData,
                          String[] Label){
        this.firstData = firstData;
        this.secondData = secondData;
        this.thirdData = thirdData;
        this.Labels=Label;
    }

    public Map<String, Double> getFirstData() {
        return firstData;
    }
    public void setFirstData(Map<String, Double> firstData) {
        this.firstData = firstData;
    }
    public Map<String, Double> getSecondData() {
        return secondData;
    }
    public void setSecondData(Map<String, Double> secondData) {
        this.secondData = secondData;
    }
    public Map<String, Double> getThirdData() {
        return thirdData;
    }
    public void setThirdData(Map<String, Double> thirdData) {
        this.thirdData = thirdData;
    }

    public int numOfSeriesAnalysis(){
        int analysisCount=0;
        if(this.firstData!=null) analysisCount++;
        if(this.secondData!=null) analysisCount++;
        if(this.thirdData!=null) analysisCount++;
        return analysisCount;
    }

    public String[] getLabels(){
        return this.Labels;
    }

    public Map<String, Double> getValues(int year){
        Map<String, Double> results = new HashMap<>();
        int size = this.numOfSeriesAnalysis();

        if (size==1){
            results.put(this.Labels[0], this.firstData.get(Integer.toString(year)));
        } else if (size==2){
            results.put(this.Labels[0], this.firstData.get(Integer.toString(year)));
            results.put(this.Labels[1], this.secondData.get(Integer.toString(year)));
        } else {
            results.put(this.Labels[0], this.firstData.get(Integer.toString(year)));
            results.put(this.Labels[1], this.secondData.get(Integer.toString(year)));
            results.put(this.Labels[2], this.thirdData.get(Integer.toString(year)));
        }
        return results;
    }



}
