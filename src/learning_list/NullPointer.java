/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class NullPointer extends Pane {
    public NullPointer(double x, double y, double x_offset, double y_offset){
        super();
        
        this.setLayoutX(x);
        this.setLayoutY(y);
        
        // Create text with null
        Text null_text = new Text("Null");
        
        // Add position of null text
        null_text.setLayoutX(x_offset - 15);
        null_text.setLayoutY(y_offset + 15);
        
        // Add text to pane
        this.getChildren().add(null_text);
        
        // Create arrow from first address to null
        Arrow null_arrow = new Arrow(0,0,x_offset,y_offset,5.0);
       
        // Add arrow to pane
        this.getChildren().add(null_arrow);
    }
}
