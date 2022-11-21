package UI;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPane implements Initializable {
    public Grid grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            grid.addNode(new Label("test"));
            grid.addNode(new Label("test2"));
            grid.addNode(new Label("test3"));
            grid.removeNode(Grid.GRID_POINT.TOP_LEFT);
            grid.addNode(new Label("test123"));
            grid.addNode(new Label("test4"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
