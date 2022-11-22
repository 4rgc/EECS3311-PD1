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
import static UI.Grid.GRID_POINT.*;

public class ChartGridPane extends BorderPane implements Initializable {
    public TopMenuView TopMenu;
    public UI.Grid Grid;
    public BottomMenuView BottomMenu;
    public List<AnalysisView>  viewList = new ArrayList<>();
    public AnalysisResult result;
    public List<UI.Grid.GRID_POINT> Deathrow = new ArrayList<>();;

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
    public void clearGrid() {
        if (!Grid.topLeft.getChildren().isEmpty()) {
            Grid.removeNode(TOP_LEFT);
        }
        if (!Grid.topRight.getChildren().isEmpty()) {
            Grid.removeNode(UI.Grid.GRID_POINT.TOP_RIGHT);
        }
        if (!Grid.bottomRight.getChildren().isEmpty()) {
            Grid.removeNode(UI.Grid.GRID_POINT.BOTTOM_RIGHT);
        }
        if (!Grid.bottomLeft.getChildren().isEmpty()) {
            Grid.removeNode(UI.Grid.GRID_POINT.BOTTOM_LEFT);
        }

    }

    public void onRecalculateClicked(BottomMenuView.RecalculateEvent event){
        clearGrid();

        Deathrow.clear();
        if (TopMenu.availableFromYears.getValue() == null || TopMenu.availableToYears.getValue() == null || TopMenu.availableCountries.getValue() == null ||
                BottomMenu.availableAnalyses.getValue() == null) {
            showWarning("Missing a field");
        }
        else {
            for (AnalysisView view:viewList) {
                try {
                    switch (view.getViewType()) {
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
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            if(Deathrow.size() > 0)
                for (UI.Grid.GRID_POINT position: Deathrow) {
                    Grid.removeNode(position);
                }
        }

    }

    public void onChartAdded(BottomMenuView.SelectedChartEvent event) {
        for (AnalysisView view:viewList) {
            if(view.getViewType().equals(event.getChartName())) {
                showWarning("Trying to add duplicate view");
                return;
            }
        }

        if (TopMenu.availableFromYears.getValue() == null || TopMenu.availableToYears.getValue() == null || TopMenu.availableCountries.getValue() == null ||
                BottomMenu.availableAnalyses.getValue() == null || BottomMenu.availableCharts.getValue() == null) {
            showWarning("Missing a field");
        }
        else {
            try {
                switch (BottomMenu.availableAnalyses.getValue()) {
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

                AnalysisView newView = createAnalysisView(event.getChartName(), result);
                viewList.add(newView);
                System.out.println(viewList);
            }

            catch (Exception e) {
                throw new RuntimeException();
            }

        }
    }

    public void onChartRemoved(BottomMenuView.SelectedChartEvent event) {
        System.out.println("test");
        for (int i = 0; i < viewList.size(); i++) {
            if(viewList.get(i).getViewType().equals(BottomMenu.availableCharts.getValue())) {
                System.out.println("test41");
                viewList.remove(i);
                switch(i) {
                    case 0:
                        Deathrow.add(TOP_LEFT);
                        break;
                    case 1:
                        Deathrow.add(TOP_RIGHT);
                        break;
                    case 2:
                        Deathrow.add(BOTTOM_LEFT);
                        break;
                    case 3:
                        Deathrow.add(BOTTOM_RIGHT);
                        break;
                }
            }
        }
    }

    public void onCountryOrYearsSelected(TopMenuView.CountryOrYearsSelectedEvent event) throws WbApiModel.WbApiModelException {
        for (AnalysisView view:viewList) {
            switch (BottomMenu.availableAnalyses.getValue()) {
                case "Air Pollution vs Forest Area":
                    result = new AirPollutionVsForestArea(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                    break;

                case "Average Expenditure On Education":
                    result = new AverageExpenditureOnEducation(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                    break;

                case "Average Forest Area":
                    result = new AverageForestArea(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;

                case "CO2 vs Energy Use vs Air Pollution":
                    result = new Co2VsEnergyUseVsAirPollution(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;

                case "CO2 vs GDP per Capita":
                    result = new Co2VsGdpPerCap(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;

                case "Education Expenditure vs Health Expenditure":
                    result = new EducationExpenditureVsHealthExpenditure(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;

                case "Health Care Access Problems vs Mortality Rate":
                    result = new HealthCareAccessProblemsVsMortalityRate(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;

                case "Health Expenditure vs Hospital Beds":
                    result = new HealthExpenditureVsHospitalBeds(TopMenu.availableFromYears.getValue(),
                            TopMenu.availableToYears.getValue(), TopMenu.availableCountries.getValue()).recalculate();
                            view.setData(result);
                            view.rerender();
                    break;
            }

            AnalysisView newView = createAnalysisView(view.getViewType(), result);
            System.out.println(viewList);
        }
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
