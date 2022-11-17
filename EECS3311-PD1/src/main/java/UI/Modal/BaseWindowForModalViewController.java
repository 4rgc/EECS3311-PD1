package UI.Modal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;

public class BaseWindowForModalViewController extends Application {
    @FXML
    public Button NoneModalButton;
    @FXML
    public Button ConfirmationModalButton;
    @FXML
    public Button ErrorModalButton;
    @FXML
    public Button InformationButtonModal;
    @FXML
    public Button WarningModalButton;

    private Alert alert;

    public static void main(String args[]){
        launch(args);
    }

    /*
     * Essentially to make a modal all you have to do is in the
     * onAction method that is connected to the button the user uses
     * create an alert of the type you want (NONE, Confirmation, Error, Information, or Warning)
     * and initialize the modality for the alert to Modality.APPLICATION_MODAL to make it so that the
     * user cannot interact with any other windows until dealing with the modal.
     * Keep in mind that the alert of type NONE requires us to specify the buttontype in its constructor
     * in order to be able to close the modal - if you don't then the modal cannot be closed.
     */

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///C:/Users/kedag/Documents/EECS3311-PD1/EECS3311-PD1/src/main/resources/fxml/BaseWindowForModalView.fxml"));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    //Creates a basic modal that has nothing.
    //Need to use the 3 input parameter constructor inorder to be able to specify button used to close modal.
    public void handleOpenAlertNoneModal(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.NONE, "None", ButtonType.CLOSE);
        alert.setTitle("None");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    //Creates a confirmation modal; already comes with OK and Cancel buttons to close.
    public void handleOpenAlertConfirmationModal(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    //Creates an error modal; already comes with OK button to close.
    public void handleOpenAlertErrorModal(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    //Creates an error modal; already comes with OK button to close.
    public void handleOpenAlertInfoModal(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    //Creates a warning modal; already comes with OK button to close.
    public void handleOpenAlertWarningModal(ActionEvent actionEvent) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }
}