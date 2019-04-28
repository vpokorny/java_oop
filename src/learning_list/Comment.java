/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class Comment extends StackPane {
    private Text text;
    
    public Comment(double x, double y, String comment_text) {
        // call supreme constructor
        super();
        
        // set origin coordinates
        this.setLayoutX(x);
        this.setLayoutY(y);
        
        // create text object
        this.text = new Text(comment_text);
        
        // set dashed border with padding
        this.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.DASHED,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT
                        )
                )
        );
        
        this.setPadding(new Insets(5));
        
        // add text to pane
        this.getChildren().add(this.text);
    } 
    
}
