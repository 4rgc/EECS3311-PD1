package UI.AnalysisViews;

import Analyzer.AnalysisResult;
import javafx.scene.chart.BarChart;

public class BarChartView extends XYChartView {

    public BarChartView(AnalysisResult data) {
        super("Bar Chart", data);

        BarChart<Number, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.getData().addAll(seriesData);

        node = chart;
    }

    @Override
    public void rerender() {
        BarChart<Number, Number> chart = (BarChart<Number, Number>) node;
        chart.getData().clear();
        chart.getData().addAll(this.seriesData);
    }
}
