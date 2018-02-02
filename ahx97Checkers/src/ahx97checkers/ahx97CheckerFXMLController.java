/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahx97checkers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author AaronHenry
 */
public class ahx97CheckerFXMLController implements Initializable {
   
    private Stage stage;
    
    private double gridWidth;
    private double gridHeight;
    
    private final int numCols = 4;
    private final int numRows = 4;
    
    private final Color[] defaultColors = {Color.RED, Color.BLACK, Color.RED, Color.BLACK};
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private AnchorPane anchorPane;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void start(Stage stage) {
        this.stage = stage;
        System.out.println(gridPane.getWidth());
        
        refresh();
 
    }
    
     
    private void refresh() {
        clearGridPane();
        
        gridWidth = gridPane.getWidth();
        gridHeight = gridPane.getHeight();
        
        Random rn = new Random();
        
        double rectWidth = Math.ceil(gridWidth / numCols);
        double rectHeight = Math.ceil(gridHeight / numRows);
        
        int numColors = defaultColors.length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Color color = defaultColors[rn.nextInt(numColors)];
                Rectangle rect = new Rectangle(rectWidth, rectHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }        
        
    }
    
    private void clearGridPane() {
        gridPane.getChildren().clear();
    }
    
}
