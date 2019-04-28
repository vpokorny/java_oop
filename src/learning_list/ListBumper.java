/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author vapo
 */
public class ListBumper extends Pane {
    private ItemContent text;
    private ItemAddress prev;
    
    public ListBumper(double max_width, double max_height, double x, double y, Color color) {
        // Initialize superior constructor
        super();
        
        // Initialize x and y coordinates for Pane
        this.setLayoutX(x);
        this.setLayoutY(y);
        
        // Set width
        this.setWidth(max_width);
        this.setPrefWidth(max_width);
        this.setMinWidth(max_width);
        this.setMaxWidth(max_width);
        
        // Set prefered height
        setPrefHeight(max_height);
        
        // Set border
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
        
        text = new ItemContent(
            5, // start X + 20 pixels space between
            5, // start Y
            max_width - 10, // width of middle item rectangle
            max_height - 10, // height
            "Bumper",
            color
        ); 
           
        this.getChildren().add(text);
    }
}
