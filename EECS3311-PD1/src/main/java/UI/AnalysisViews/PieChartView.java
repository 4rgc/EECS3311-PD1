package UI.AnalysisViews;

import Analyzer.AnalysisResult;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieChartView extends AnalysisView {
    private List<PieChart.Data> chartData;

    public PieChartView(AnalysisResult data) {
        super("Pie Chart", data);

        String[] labels = data.getLabels();
        PieChart chart = new PieChart();

        List<PieChart.Data> chartData = getDataAsPieChartData(labels);

        chart.getData().addAll(chartData);

        node = chart;
    }

    private List<PieChart.Data> getDataAsPieChartData(String[] labels) {
        List<PieChart.Data> chartData = new ArrayList<>();

        // TODO: display multiple labels for a single year only
        Map<Integer, Double> yearToValue = this.data.get(labels[0]);

        for (Integer year:
                yearToValue.keySet()) {
            chartData.add(new PieChart.Data(year.toString(), yearToValue.get(year)));
        }
        return chartData;
    }

    @Override
    public void setData(AnalysisResult data) {
        super.setData(data);
        this.chartData = getDataAsPieChartData(data.getLabels());
    }

    @Override
    public void rerender() {
        PieChart chart = (PieChart) node;
        chart.getData().clear();
        chart.getData().addAll(this.chartData);
    }
}