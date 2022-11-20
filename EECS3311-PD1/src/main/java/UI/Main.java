package UI;

import UI.Login.LoginView;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;

    private void showLoginScene() {
        LoginView loginView = new LoginView();
        loginView.setOnLoginSuccessful(this::loginSucceeded);

        this.stage.setMinHeight(400);
        this.stage.setMaxHeight(400);
        this.stage.setMinWidth(600);
        this.stage.setMaxWidth(600);

        Scene loginScene = new Scene(loginView);
        stage.setScene(loginScene);
        stage.show();
    }

    private void hideLoginScene() {
        stage.hide();
        stage.setScene(null);
    }

    public void loginSucceeded(Event event) {
        System.out.println("Login successful!");
        try {
            this.stage.hide();
            stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        showLoginScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
