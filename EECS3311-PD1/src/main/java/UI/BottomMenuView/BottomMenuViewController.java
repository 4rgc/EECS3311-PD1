package UI.BottomMenuView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BottomMenuViewController extends Application implements Initializable {
    @FXML
    public ChoiceBox<String> typesOfChartViews = new ChoiceBox<>();
    @FXML
    public Button addChartView;
    @FXML
    public Button removeChartView;
    @FXML
    public ChoiceBox<String> typesOfAnalysis = new ChoiceBox<>();
    @FXML
    public Button recalculateButton;

    private Map<String, String[]> analysisToCharts = new HashMap<>();
    private String[] arrayOfAnalysis = {"Air Pollution vs Forest Area", "Average Expenditure On Education",
                                        "Average Forest Area", "CO2 vs Energy Use vs Air Pollution",
                                        "CO2 vs GDP per Capita", "Education Expenditure vs Health Expenditure",
                                        "Health Care Access Problems vs Mortality Rate",
                                        "Health Expenditure vs Hospital Beds"};

    private String[] arrayOfCharts = {"Bar Chart", "Line Chart", "Pie Chart", "Report", "Scatter Chart"};
    private ArrayList<String> listOfViewers = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Fills the analysis and chart view dropdowns with the possible analysis and chart views respectively.
        typesOfAnalysis.getItems().addAll(arrayOfAnalysis);

        //Fills map of analysis to chart views.
        analysisToChartsHelper();

        //a listener is added to the analysis dropdowns.
        //everytime an analysis is chosen, the list of corresponding viewers fills the chart view menu.
        //everytime an analysis is chosen, the list of viewers becomes empty.
        typesOfAnalysis.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                typesOfChartViews.getItems().setAll(analysisToCharts.get(typesOfAnalysis.getValue()));
                listOfViewers = new ArrayList<>();
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BottomMenuView.fxml"));
        BorderPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void addChartToListOfViews(ActionEvent actionEvent) {
        addChartView.setOnAction(this::addIfNotIn);
    }

    public void removeChartToListOfViews(ActionEvent actionEvent) {
        removeChartView.setOnAction(this::removeIfNotIn);
    }

    public void recalculate(ActionEvent actionEvent) {

    }

    private void addIfNotIn(ActionEvent actionEvent) {
        String currentChart = typesOfChartViews.getValue();
        if(listOfViewers.contains(currentChart) == false && currentChart != null){
            listOfViewers.add(currentChart);
            System.out.println(currentChart + " added");
        }
    }

    private void removeIfNotIn(ActionEvent actionEvent) {
        String currentChart = typesOfChartViews.getValue();
        if(listOfViewers.contains(currentChart) == true && currentChart != null){
            listOfViewers.remove(currentChart);
            System.out.println(currentChart + " removed");
        }
    }

    private void analysisToChartsHelper() {
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
    }
}