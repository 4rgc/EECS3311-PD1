package org.example;


import Analyzer.AbstractAnalyzer;
import Analyzer.AirPollutionVsForestArea;
import Analyzer.AnalysisResult;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        AbstractAnalyzer analyzer = new AirPollutionVsForestArea("2000", "2000", "CAN");
        AnalysisResult result = analyzer.recalculate();

        String[] Label = result.getLabels();
        Map<String, Double> Data = result.getValues(2000);

        for(int i=0; i<Label.length; i++){
            System.out.print(Label[i] + " ");
        }
        System.out.println();
        System.out.print(Data);



    }
}
