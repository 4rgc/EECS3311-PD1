package UI;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import UI.BottomMenuView.SelectedChartEvent;

import java.util.HashMap;
import java.util.Map;

public class MainPane {
    public Label selectedChartsLabel;
    public Label selectedAnalysisLabel;
    public Label recalculatePressesLabel;
    public BottomMenuView bottomMenu;


    private String[] arrayOfAnalysis = {"Air Pollution vs Forest Area", "Average Expenditure On Education",
            "Average Forest Area", "CO2 vs Energy Use vs Air Pollution",
            "CO2 vs GDP per Capita", "Education Expenditure vs Health Expenditure",
            "Health Care Access Problems vs Mortality Rate",
            "Health Expenditure vs Hospital Beds"};

    private String[] arrayOfCharts = {"Bar Chart", "Line Chart", "Pie Chart", "Report", "Scatter Chart"};

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

    public MainPane() {
//        bottomMenu.setAvailableAnalyses(Arrays.stream(arrayOfAnalysis).toList());
    }

    public void onChartAdded(SelectedChartEvent event) {
        System.out.println(event.getChartName() + " added");
    }

    public void onChartRemoved(SelectedChartEvent event) {
        System.out.println(event.getChartName() + " removed");
    }

    public void onRecalculatePressed(ActionEvent actionEvent) {
        System.out.println("recalculate pressed");
    }
}
