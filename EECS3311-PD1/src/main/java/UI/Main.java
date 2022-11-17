package UI;

import UI.Menu.TopMenuViewController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    private TopMenuViewController topMenuViewController;

    /*
            To use the TopMenuView u need to first load it into a pane (assuming we use a root pane)
            Then using the loader we need to load its controller and then we can just call the
            getToYear() and getFromYear() methods to get the selected option.

            I was testing it here in start so an example of how you use it is below
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TopMenuView.fxml"));
        Parent pane = loader.load();
        this.topMenuViewController = loader.getController();

        System.out.println(this.topMenuViewController.getToYear());
        System.out.println(this.topMenuViewController.getFromYear());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
