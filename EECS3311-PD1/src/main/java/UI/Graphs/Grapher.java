package UI.Graphs;

import Analyzer.AnalysisResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.util.ArrayList;
import java.util.Map;

public class Grapher {
    AnalysisResult results;
    ArrayList<Map<String, Double>> data;

    public Grapher(AnalysisResult results) {
        this.results = results;
        data = results.getData();
    }

    public PieChart createPieChart(int syear, int eyear) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for(int i = syear; i <= eyear; i++) {
            pieChartData.add(new PieChart.Data(Integer.toString(i), results.getValues(i).get(results.getLabels()[0])));
        }
        return new PieChart(pieChartData);
    }

    public LineChart createLineChart(int syear, int eyear) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(syear);
        xAxis.setUpperBound(eyear);
        xAxis.setTickUnit(1);
        LineChart<Number,Number> line = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();


        for(int i = syear; i <= eyear; i++) {
            for(int j = 0; j < results.getLabels().length; j++) {
                series.getData().add(new XYChart.Data<>(i, results.getValues(i).get(results.getLabels()[j])));
            }

        }
        line.getData().add(series);
        return line;


    }

    public BarChart createBarChart(int syear, int eyear) {
        NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();
        BarChart bar = new BarChart(xAxis ,yAxis);

        XYChart.Series series = new XYChart.Series();
        for(int i = syear; i <= eyear; i++) {
            for(int j = 0; j < results.getLabels().length ; j++) {
                series.getData().add(new XYChart.Data<>(results.getValues(i).get(results.getLabels()[j]), Integer.toString(i)));
            }
        }
        bar.getData().add(series);
        return bar;
    }
}
