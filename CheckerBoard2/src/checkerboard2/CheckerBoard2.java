/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author tristanday
 */
public class CheckerBoard2 extends Application {
    
    // Number of rows and columns
    private int rows;
    private int cols;
    
    // Dimensions of the board
    private double boardW;
    private double boardH;
    
    // Colorz
    private Color lightColor;
    private Color darkColor;
    
    // Board to place rectangles in.
    private AnchorPane board;
    
    public CheckerBoard2() {
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
        this.rows = 16;
        this.cols = 16;
        this.boardW = 600;
        this.boardH = 370;
    }
    
    // Constructors one for the default red and black. One for the user defined colors.
    public CheckerBoard2(int numRows, int numColumns, double boardW, double boardH) {
        this(Color.RED, Color.BLACK, numRows, numColumns, boardW, boardH);
    }

    public CheckerBoard2(Color lightColor, Color darkColor, int numRows, int numColumns, double boardW, double boardH) {
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        this.rows = numRows;
        this.cols = numColumns;
        this.boardW = boardW;
        this.boardH = boardH;
    }
    
    public void setDimension(int size) {
        this.rows = size;
        this.cols = size;
    }
    
    public void setColors(Color lightColor, Color darkColor) {
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public double getRectangleWidth() {
        return this.boardW / this.cols;
    }

    public double getRectangleHeight() {
        return this.boardH / this.rows;
    }
    
    public AnchorPane createBoard() {
        board = new AnchorPane();
        
        // Double for loop to create and place the rectangles into the anchor pane.
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rectangle = new Rectangle(getRectangleWidth() * i, getRectangleHeight() * j, this.boardW, this.boardH);
                
                // This increases the visibility of the rectangles.
                rectangle.setStroke(Color.BLACK);
                
                if ((j + i) % 2 == 0) {
                    rectangle.setFill(lightColor);
                } else {
                    rectangle.setFill(darkColor);
                }
                board.getChildren().add(rectangle);
            }
        }
        
        return board;
    }
    
    public AnchorPane getBoard() {
        return this.board;
    }

    public int getNumRows() {
        return this.rows;
    }

    public int getNumCols() {
        return this.cols;
    }

    public double getWidth() {
        return this.boardW;
    }

    public double getHeight() {
        return this.boardH;
    }

    public Color getLightColor() {
        return this.lightColor;
    }

    public Color getDarkColor() {
        return this.darkColor;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
