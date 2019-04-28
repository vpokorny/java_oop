package learning_list;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vapo
 */
public class Variable extends Pane {
    private final Text text; // Variable name
    private Arrow arrow; // Arrow of variable
    
    public Variable(double x, double y, String var_name) {
        // initialize superior constructor
        super();
        
        // set origin coordinates
        this.setLayoutX(x);
        this.setLayoutY(y);
        
        // create label
        this.text = new Text(var_name);
        this.text.setLayoutY(10);
                
        // create blank arrow
        this.arrow = new Arrow();
        
        // add label to pane children
        this.getChildren().addAll(this.text, this.arrow);
        
    }
    
    public void ReplaceArrow(double x_end, double y_end) {
        // remove old arrow
        this.getChildren().remove(this.arrow);
                
        // construct coordinates for arrow
        double[] x = {this.text.getText().length() * 10, x_end, x_end};
        double[] y = {5, 5, y_end};
        
        // create new arrow
        this.arrow = new Arrow(x,y);
        
        // add arrow to pane children
        this.getChildren().add(this.arrow);
    }
    
    public void RemoveArrow() {
        // remove arrow
        this.getChildren().remove(this.arrow);
    }
}
