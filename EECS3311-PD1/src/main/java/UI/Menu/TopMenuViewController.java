package UI.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public class TopMenuViewController {

    public MenuBar menuBar1;
    public MenuBar menuBar2;
    public MenuBar menuBar3;

    public TopMenuViewController(){}

    // Select a country and then add Items to the FromYear component and set their eventHandler to FromYear()
    public void CountrySelected(ActionEvent e) {
        menuBar1.getMenus().get(0).setText(
                ((MenuItem) e.getSource()).getText()
        );
        menuBar2.setStyle("-fx-background-color: #e7e7e7");

        int startYear = 1900;
        Menu menu = menuBar2.getMenus().get(0);

        for(int i=startYear; i<2022; i++){
            MenuItem Item = new MenuItem(String.valueOf(i));
            Item.setOnAction(this::FromYear);
            menu.getItems().add(Item);
        }
    }

    //  Add Items to the ToYear component and set their eventHandler to ToYear()
    public void FromYear(ActionEvent e) {
        menuBar2.getMenus().get(0).setText(
                ((MenuItem) e.getSource()).getText()
        );
        menuBar3.setStyle("-fx-background-color: #e7e7e7");

        int startYear = Integer.parseInt(((MenuItem) e.getSource()).getText());
        Menu menu = menuBar3.getMenus().get(0);

        for(int i=startYear; i<2022; i++){
            MenuItem Item = new MenuItem(String.valueOf(i));
            Item.setOnAction(this::ToYear);
            menu.getItems().add(Item);
        }
    }

    public void ToYear(ActionEvent e) {
        menuBar3.getMenus().get(0).setText(
                ((MenuItem) e.getSource()).getText()
        );
    }

    public int getFromYear(){
        if(this.menuBar2.getMenus().get(0).getText().equals("Select Year")) {
            return -1;
        }
        return Integer.parseInt(this.menuBar2.getMenus().get(0).getText());
    }

    public int getToYear(){
        if(this.menuBar3.getMenus().get(0).getText().equals("Select Year")){
            return -1;
        }
        return Integer.parseInt(this.menuBar3.getMenus().get(0).getText());
    }
}
