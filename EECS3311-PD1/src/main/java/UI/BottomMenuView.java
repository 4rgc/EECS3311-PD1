package UI;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottomMenuView extends HBox {
    @FXML
    public ChoiceBox<String> typesOfChartViews = new ChoiceBox<>();
    @FXML
    public ChoiceBox<String> typesOfAnalyses = new ChoiceBox<>();

    @FXML
    public Button addChartBtn;

    @FXML
    public Button removeChartBtn;

    @FXML
    public Button recalculateBtn;

    public BottomMenuView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/BottomMenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        addChartBtn.setOnAction(this::addChartToListOfViews);
        removeChartBtn.setOnAction(this::removeChartFromListOfViews);
        recalculateBtn.setOnAction(this::recalculate);

        setAvailableCharts(new ArrayList<>());
        setAvailableAnalyses(new ArrayList<>());
    }

    public void addChartToListOfViews(ActionEvent actionEvent) {
//        addChartView.setOnAction(this::addIfNotIn);
        propertyOnChartAdded.get().handle(new SelectedChartEvent(typesOfChartViews.getValue(), EventType.ROOT));
    }

    public void removeChartFromListOfViews(ActionEvent actionEvent) {
        propertyOnChartRemoved.get().handle(new SelectedChartEvent(typesOfChartViews.getValue(), EventType.ROOT));
    }

    public void recalculate(ActionEvent actionEvent) {

    }

    static public class SelectedChartEvent extends Event {
        private String chartName;

        public SelectedChartEvent(String chartName, EventType<? extends Event> eventType) {
            super(eventType);
            this.chartName = chartName;
        }

        public String getChartName() {
            return chartName;
        }
    }

    private ObjectProperty<EventHandler<SelectedChartEvent>> propertyOnChartAdded = new SimpleObjectProperty<>();

    public final void setOnChartAdded(EventHandler<SelectedChartEvent> handler) {
        propertyOnChartAdded.set(handler);
    }

    public final EventHandler<SelectedChartEvent> getOnChartAdded() {
        return propertyOnChartAdded.get();
    }

    private ObjectProperty<EventHandler<SelectedChartEvent>> propertyOnChartRemoved = new SimpleObjectProperty<>();

    public final ObjectProperty<EventHandler<SelectedChartEvent>> onChartRemovedProperty() {
        return propertyOnChartRemoved;
    }

    public final void setOnChartRemoved(EventHandler<SelectedChartEvent> handler) {
        propertyOnChartRemoved.set(handler);
    }

    public final EventHandler<SelectedChartEvent> getOnChartRemoved() {
        return propertyOnChartRemoved.get();
    }

    private ObjectProperty<EventHandler<ActionEvent>> propertyOnRecalculatePressed = new SimpleObjectProperty<>();

    public final ObjectProperty<EventHandler<ActionEvent>> onRecalculatePressedProperty() {
        return propertyOnRecalculatePressed;
    }

    public final void setOnRecalculatePressed(EventHandler<ActionEvent> handler) {
        propertyOnRecalculatePressed.set(handler);
    }

    public final EventHandler<ActionEvent> getOnRecalculatePressed() {
        return propertyOnRecalculatePressed.get();
    }

    private ObjectProperty<List<String>> propertyAvailableCharts = new SimpleObjectProperty<>();

    public final ObjectProperty<List<String>> availableChartsProperty() {
        return propertyAvailableCharts;
    }

    public final void setAvailableCharts(List<String> charts) {
        propertyAvailableCharts.set(charts);
        typesOfChartViews.setItems(FXCollections.observableList(charts));
    }

    public final List<String> getAvailableCharts() {
        return propertyAvailableCharts.get();
    }

    private ObjectProperty<List<String>> propertyAvailableAnalyses = new SimpleObjectProperty<>();

    public final ObjectProperty<List<String>> availableAnalysesProperty() {
        return propertyAvailableAnalyses;
    }

    public final void setAvailableAnalyses(List<String> analyses) {
        propertyAvailableAnalyses.set(analyses);
        typesOfAnalyses.setItems(FXCollections.observableList(analyses));
    }

    public final List<String> getAvailableAnalyses() {
        return propertyAvailableAnalyses.get();
    }
}