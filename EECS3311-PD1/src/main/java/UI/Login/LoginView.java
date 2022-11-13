package UI.Login;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.userDb.*;

import java.io.IOException;
import java.util.Objects;

public class LoginView extends VBox {
    static public class LoginSuccessfulEvent extends Event {
        public LoginSuccessfulEvent(EventType<LoginSuccessfulEvent> eventType) {
            super(eventType);
        }
    }

    private EventHandler<LoginSuccessfulEvent> onLoginSuccessful;

    UserDbModel model;

    public TextField usernameTF;
    public PasswordField passwordTF;
    public Button loginButton;

    public LoginView() {
        model = new UserDbModel(
                new UserSingleTableDatabase(
                        new LocalJsonTableDataSourceFactory(
                                Objects.requireNonNull(
                                        getClass().getResource("/userdb.json")).getPath()
                        )
                )
        );

        onLoginSuccessful = null;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/LoginView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        loginButton.setOnAction(this::onLoginClick);
        usernameTF.setOnAction(this::onUsernameChange);
        passwordTF.setOnAction(this::onPasswordChange);
    }


    public EventHandler<LoginSuccessfulEvent> getOnLoginSuccessful() {
        return onLoginSuccessful;
    }

    public void setOnLoginSuccessful(EventHandler<LoginSuccessfulEvent> listener) {
        onLoginSuccessful = listener;
    }

    @FXML
    public void onUsernameChange(ActionEvent actionEvent) {

    }

    private void onPasswordChange(ActionEvent actionEvent) {
    }

    @FXML
    public void onLoginClick(ActionEvent actionEvent) {
        try {
            IUser user = model.getUserByUsername(usernameTF.getText());

            if(user == null) {
                //TODO: display a message that username or password is incorrect
                return;
            }

            if(!user.getPassword().equals(passwordTF.getText())) {
                //TODO: display a message that username or password is incorrect
                return;
            }

            if(onLoginSuccessful != null)
                onLoginSuccessful.handle(new LoginSuccessfulEvent(new EventType<>(EventType.ROOT)));
        } catch (ISingleTableDatabase.DatabaseException e) {
            //TODO: Display a modal with the error message
            throw new RuntimeException(e);
        }
    }
}
