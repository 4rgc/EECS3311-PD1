package UI.AnalysisViews;

import Analyzer.AnalysisResult;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class XYChartView extends AnalysisView {
    protected List<XYChart.Series<Number,Number>> seriesData;
    protected NumberAxis xAxis;
    protected NumberAxis yAxis;

    public XYChartView(String viewType, AnalysisResult data) {
        super(viewType, data);

        xAxis = new NumberAxis();
        yAxis = new NumberAxis();

        // TODO: add labels to axes

        String[] labels = data.getLabels();

        this.seriesData = getDataAsSeriesList(labels);
    }

    @Override
    public void setData(AnalysisResult data) {
        super.setData(data);
        this.seriesData = getDataAsSeriesList(data.getLabels());
    }

    private List<XYChart.Series<Number, Number>> getDataAsSeriesList(String[] labels) {
        List<XYChart.Series<Number,Number>> seriesList = new ArrayList<>();

        for (String label:
                labels) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            Map<Integer,Double> yearToValue = this.data.get(label);

            series.setName(label);

            for (Integer year:
                    yearToValue.keySet()) {
                series.getData().add(new XYChart.Data<>(year, yearToValue.get(year)));
            }

            seriesList.add(series);
        }
        return seriesList;
    }
}
