package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainPane implements Initializable {
    public TopMenuView topMenu;

    private String[] Countries = {"BRA", "CAN", "CHN", "FRA", "IND", "ITA", "JPN", "MEX", "PRT", "USA"};

    private String[] generateYears(int startYear, int endYear){
        int size = endYear-startYear;
        String[] years = new String[size+1];

        for(int i=startYear; i<=endYear;i++){
            years[i-startYear]=Integer.toString(i);
        }
        return years;
    }

    /*
    public void onChartAdded(SelectedChartEvent event) {
        System.out.println(event.getChartName() + " added");
    }

    public void onChartRemoved(SelectedChartEvent event) {
        System.out.println(event.getChartName() + " removed");
    }

    public void onRecalculatePressed(ActionEvent actionEvent) {
        System.out.println("recalculate pressed");
    }
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topMenu.setAvailableCountries(Arrays.stream(Countries).toList());
        topMenu.setAvailableFromYears(Arrays.stream(generateYears(1990, 2021)).toList());

        topMenu.availableFromYears.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            System.out.println("old: " + oldValue + ", new: " + newValue);
            int newYearStart = Integer.parseInt(newValue);
            topMenu.setAvailableToYears(Arrays.stream(generateYears(newYearStart, 2021)).toList());
        });

    }

    public void countryOrYearsSelected(TopMenuView.CountryOrYearsSelectedEvent countryOrYearsSelectedEvent) {
        System.out.println(countryOrYearsSelectedEvent.getCountry());
        System.out.println(countryOrYearsSelectedEvent.getToYear());
        System.out.println(countryOrYearsSelectedEvent.getFromYear());
    }
}