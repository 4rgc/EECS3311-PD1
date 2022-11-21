package UI.AnalysisViews;

import Analyzer.AnalysisResult;
import javafx.scene.chart.ScatterChart;

public class ScatterChartView extends XYChartView {

    public ScatterChartView(AnalysisResult data) {
        super("Scatter Chart", data);

        ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
        chart.getData().addAll(seriesData);

        node = chart;
    }


    @Override
    public void rerender() {
        ScatterChart<Number, Number> chart = (ScatterChart<Number, Number>) node;
        chart.getData().clear();
        chart.getData().addAll(this.seriesData);
    }
}
