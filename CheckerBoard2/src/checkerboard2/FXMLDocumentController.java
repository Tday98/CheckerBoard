/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author tristanday
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    MenuBar menuBar;
    
    @FXML // All the menu items that are used.
    MenuItem x16;
    @FXML
    MenuItem x10;
    @FXML
    MenuItem x8;
    @FXML
    MenuItem x3;
    @FXML
    MenuItem colorDefault;
    @FXML
    MenuItem colorBlue;
    
    @FXML // VBOX
    VBox vbox;
    
    @FXML 
    AnchorPane board;
    
    CheckerBoard2 checker;
    
    @FXML
    private void gridChange(ActionEvent event) {
        String newGridSize = (String) ((MenuItem) event.getSource()).getId();
        
        switch(newGridSize) {
            case "x16":
                checker.setDimension(16);
                break;
            case "x10":
                checker.setDimension(10);
                break;
            case "x8":
                checker.setDimension(8);
                break;
            case "x3":
                checker.setDimension(3);
                break;
            default:
                checker.setDimension(16);
        }
        refresh();
    }
    
    @FXML
    private void colorChange(ActionEvent event) {
        String newColor = (String) ((MenuItem) event.getSource()).getId();
        
        switch(newColor) {
            case "colorDefault":
                checker.setColors(Color.RED, Color.BLACK);
                break;
            case "colorBlue":
                checker.setColors(Color.SKYBLUE, Color.DARKBLUE);
                break;
        }
        refresh();
    }
    
    private void refresh() {
        this.checker = new CheckerBoard2(checker.getLightColor(), checker.getDarkColor(), checker.getNumRows(), checker.getNumCols(), board.getPrefWidth(), board.getPrefHeight());
        board.getChildren().setAll(checker.createBoard());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.board.setPrefSize(vbox.getPrefWidth(), vbox.getPrefHeight() - 20.0);
        this.checker = new CheckerBoard2(16, 16, board.getPrefWidth(), board.getPrefHeight());
        refresh();
        
        // Resize on drag down
        vbox.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) -> {
            board.setPrefHeight(newValue.doubleValue() - 20.0);
            refresh();
        });

        // Resize on drag side
        vbox.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            board.setPrefWidth(newValue.doubleValue());
            refresh();
        });
    }    
    
}
