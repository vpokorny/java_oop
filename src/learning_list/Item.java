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
public class Item extends Pane {
    private ItemAddress prev;
    private ItemAddress next;
    private ItemContent key;
    
    
    public Item(
            double max_width,
            double max_height,
            double positionX,
            double positionY,
            String key_text)
    {
        super();
        
        setLayoutX(positionX);
        setLayoutY(positionY);
        
        // Set width
        this.setWidth(max_width);
        this.setPrefWidth(max_width);
        this.setMinWidth(max_width);
        this.setMaxWidth(max_width);
        
        // Set border
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPrefHeight(max_height);
        
        prev = new ItemAddress(
                5, // start X position in Item pane
                5, // start Y position in Item pane
                15, // width of previous address rectangle
                max_height - 10); // height of address rectangle
        
        key = new ItemContent(
                20, // start X + 20 pixels space between
                5, // start Y
                max_width - 40, // width of middle item rectangle
                max_height - 10, // height
                key_text); 
        
        next = new ItemAddress(
                max_width - 20, // start X (end - 20)-middle width is dynamic
                5, // start Y
                15, // width of next address rectangle
                max_height - 10); // height of next address rectangle
          
        // Add components to Item pane
        this.getChildren().addAll(key, prev, next);
    }
    
    
}
