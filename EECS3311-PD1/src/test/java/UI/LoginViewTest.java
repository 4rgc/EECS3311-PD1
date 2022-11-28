package UI;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class LoginViewTest {
    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Platform.runLater(() -> {
            stage.setScene(new Scene(new LoginView()));
            stage.show();
            stage.toFront();
        });
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
        Platform.runLater(() -> {
            stage.hide();
        });
    }

    @Test
    public void testTest(FxRobot robot) {
        verifyThat("#usernameLabel", LabeledMatchers.hasText("Username"));
    }
}