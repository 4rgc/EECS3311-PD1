package UI.Login;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import org.example.userDb.LocalJsonTableDataSourceFactory;
import org.example.userDb.UserDbModel;
import org.example.userDb.UserSingleTableDatabase;

public class LoginViewController {

    UserDbModel model;

    public TextField usernameTF;
    public TextField passwordTF;

    public LoginViewController() {
        model = new UserDbModel(
                new UserSingleTableDatabase(
                        new LocalJsonTableDataSourceFactory("userdb.json")
                )
        );
    }

    public void onUsernameChange(ActionEvent actionEvent) {
        System.out.println(usernameTF.getText());
    }

    public void onLoginClick(ActionEvent actionEvent) {

    }
}
