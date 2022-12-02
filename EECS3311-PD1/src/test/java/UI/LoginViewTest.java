package UI;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

@ExtendWith(ApplicationExtension.class)
class LoginViewTest {
    static {
        if (Boolean.getBoolean("headless")) {
            System.setProperty("testfx.robot", "glass");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");
            System.setProperty("prism.text", "t2k");
        }
    }

    private Stage stage;

    @Start
    public void start(Stage stage) {
        this.stage = stage;
        Platform.runLater(() -> {
            stage.setScene(new Scene(new LoginView()));
            stage.show();
            stage.toFront();
        });
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        Platform.runLater(() -> stage.hide());
    }

    @Test
    public void testTest(FxRobot robot) {
        verifyThat("#usernameLabel", LabeledMatchers.hasText("Username"));
    }
}