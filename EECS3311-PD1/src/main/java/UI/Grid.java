package UI;



import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static org.apache.maven.surefire.shared.lang3.ObjectUtils.isEmpty;

public class Grid extends GridPane {

    public AnchorPane topLeft;
    public AnchorPane topRight;
    public AnchorPane bottomLeft;
    public AnchorPane bottomRight;

    Node[] nodeArray;

    public enum GRID_POINT {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }


    public Grid() {
        nodeArray = new Node[4];

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/fxml/Grid.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public GRID_POINT addNode(Node node) throws Exception {
        for (int i = 0; i < 4; i++) {
            if (isEmpty(nodeArray[i]) ) {
                nodeArray[i] = node;
                if (i == 0) {
                    topLeft.getChildren().add(node);
                }
                else if (i == 1) {
                    topRight.getChildren().add(node);
                }
                else if (i == 2) {
                    bottomLeft.getChildren().add(node);
                }
                else if (i == 3) {
                    bottomRight.getChildren().add(node);
                }
                return GRID_POINT.values()[i];
            }
        }
        throw new Exception("View is full");
    }

    public void removeNode(GRID_POINT location) {
        nodeArray[location.ordinal()] = null;
        if (location == GRID_POINT.TOP_LEFT) {
            topLeft.getChildren().remove(0);
        }
        else if (location == GRID_POINT.TOP_RIGHT) {
            topLeft.getChildren().remove(0);
        }
        else if (location == GRID_POINT.BOTTOM_LEFT) {
            topLeft.getChildren().remove(0);
        }
        else if (location == GRID_POINT.BOTTOM_RIGHT) {
            topLeft.getChildren().remove(0);
        }
    }
}