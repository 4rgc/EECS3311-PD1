package UI.AnalysisViews;

import Analyzer.AnalysisResult;
import javafx.scene.chart.LineChart;

public class LineChartView extends XYChartView {

    public LineChartView(AnalysisResult result) {
        super("Line Chart", result);

        LineChart<Number,Number> chart = new LineChart<>(xAxis, yAxis);
        chart.getData().addAll(this.seriesData);

        node = chart;
    }

    @Override
    public void rerender() {
        LineChart<Number, Number> chart = (LineChart<Number, Number>) node;
        chart.getData().clear();
        chart.getData().addAll(this.seriesData);
    }
}
