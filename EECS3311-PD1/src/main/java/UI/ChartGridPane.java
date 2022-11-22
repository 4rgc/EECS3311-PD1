package UI;

import Analyzer.*;
import UI.AnalysisViews.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import org.example.WbApiModel;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static UI.AnalysisViews.AnalysisViewFactory.createAnalysisView;

public class ChartGridPane extends BorderPane implements Initializable {
    public TopMenuView TopMenu;
    public UI.Grid Grid;
    public BottomMenuView BottomMenu;
    public List<AnalysisView>  viewList = new ArrayList<>();
    public AnalysisResult result;

    public ChartGridPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/ChartGridPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void onRecalculateClicked(BottomMenuView.RecalculateEvent event) throws WbApiModel.WbApiModelException {
        if (TopMenu.availableFromYears.getValue() == null || TopMenu.availableToYears.getValue() == null || TopMenu.availableCountries.getValue() == null ||
                BottomMenu.availableAnalyses.getValue() == null || BottomMenu.availableCharts.getValue() == null) {
            showWarning("Missing a field");
        }
        else {
            switch (event.getAnalysisName()) {
                case "Air Pollution vs Forest Area":
                    result = new AirPollutionVsForestArea(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "Average Expenditure On Education":
                    result = new AverageExpenditureOnEducation(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "Average Forest Area":
                    result = new AverageForestArea(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "CO2 vs Energy Use vs Air Pollution":
                    result = new Co2VsEnergyUseVsAirPollution(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "CO2 vs GDP per Capita":
                    result = new Co2VsGdpPerCap(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "Education Expenditure vs Health Expenditure":
                    result = new EducationExpenditureVsHealthExpenditure(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "Health Care Access Problems vs Mortality Rate":
                    result = new HealthCareAccessProblemsVsMortalityRate(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;

                case "Health Expenditure vs Hospital Beds":
                    result = new HealthExpenditureVsHospitalBeds(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                    break;
            }
        }

    }

    public void onChartAdded(BottomMenuView.SelectedChartEvent event) {
        System.out.println("test");
        for (AnalysisView view:viewList) {
            if(view.getViewType().equals(event.getChartName())) {
                showWarning("Trying to add duplicate view");
                return;
            }
        }


        AnalysisView newView = createAnalysisView(event.getChartName(), result);
        viewList.add(newView);
        System.out.println(viewList);
        try {
            switch (event.getChartName()) {
                case "Bar Chart":
                    BarChartView bar = new BarChartView(result);
                    Grid.addNode(bar.getNode());
                    break;

                case "Line Chart":
                    LineChartView line = new LineChartView(result);
                    Grid.addNode(line.getNode());
                    break;

                case "Pie Chart":
                    PieChartView pie = new PieChartView(result);
                    Grid.addNode(pie.getNode());
                    break;

                case "Report":
                    ReportView report = new ReportView(result);
                    Grid.addNode(report.getNode());
                    break;

                case "Scatter Chart":
                    ScatterChartView scatter = new ScatterChartView(result);
                    Grid.addNode(scatter.getNode());
                    break;
            }
        }

        catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public void onChartRemoved(BottomMenuView.SelectedChartEvent event) {

    }

    private static void showWarning(String warning) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setContentText(warning);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] arrayOfAnalysis = {"Air Pollution vs Forest Area", "Average Expenditure On Education",
                "Average Forest Area", "CO2 vs Energy Use vs Air Pollution",
                "CO2 vs GDP per Capita", "Education Expenditure vs Health Expenditure",
                "Health Care Access Problems vs Mortality Rate",
                "Health Expenditure vs Hospital Beds"};

        String[] arrayOfCharts = {"Bar Chart", "Line Chart", "Pie Chart", "Report", "Scatter Chart"};
        String[] Countries = {"BRA", "CAN", "CHN", "FRA", "IND", "ITA", "JPN", "MEX", "PRT", "USA"};

        TopMenu.setAvailableCountries(Arrays.stream(Countries).toList());
        TopMenu.setAvailableFromYears(Arrays.stream(generateYears(1990, 2021)).toList());
        TopMenu.availableFromYears.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            System.out.println("old: " + oldValue + ", new: " + newValue);
            int newYearStart = Integer.parseInt(newValue);
            TopMenu.setAvailableToYears(Arrays.stream(generateYears(newYearStart, 2021)).toList());
        });

        BottomMenu.setAvailableAnalyses(Arrays.stream(arrayOfAnalysis).toList());

        BottomMenu.availableAnalyses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                BottomMenu.setAvailableCharts(Arrays.stream(analysisToChartsHelper().get(newValue)).toList());
            }
        });
    }

    private String[] generateYears(int startYear, int endYear){
        int size = endYear-startYear;
        String[] years = new String[size+1];

        for(int i=startYear; i<=endYear;i++){
            years[i-startYear]=Integer.toString(i);
        }
        return years;
    }
    private Map<String, String[]> analysisToChartsHelper() {
        Map<String, String[]> analysisToCharts = new HashMap<>();
        analysisToCharts.put("Air Pollution vs Forest Area",
                new String[]{"Bar Chart", "Line Chart", "Pie Chart", "Report", "Scatter Chart"});

        analysisToCharts.put("Average Expenditure On Education",
                new String[]{"Bar Chart", "Line Chart", "Pie Chart", "Report"});

        analysisToCharts.put("Average Forest Area",
                new String[]{"Bar Chart", "Line Chart", "Pie Chart"});

        analysisToCharts.put("CO2 vs Energy Use vs Air Pollution",
                new String[]{"Bar Chart", "Line Chart"});

        analysisToCharts.put("CO2 vs GDP per Capita",
                new String[]{"Bar Chart"});

        analysisToCharts.put("Education Expenditure vs Health Expenditure",
                new String[]{"Bar Chart", "Line Chart"});

        analysisToCharts.put("Health Care Access Problems vs Mortality Rate",
                new String[]{"Bar Chart", "Line Chart", "Pie Chart"});

        analysisToCharts.put("Health Expenditure vs Hospital Beds",
                new String[]{"Bar Chart", "Line Chart", "Pie Chart", "Report"});

        return analysisToCharts;
    }
}
