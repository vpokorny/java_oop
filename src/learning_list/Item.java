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
    private final ItemAddress next;
    private final ItemContent key;
    private Arrow pointer;
    
    
    public Item(
            double max_width,
            double max_height,
            double positionX,
            double positionY,
            String key_text,
            Color color
    ){
        super();
        
        setLayoutX(positionX);
        setLayoutY(positionY);
        
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
           
        // Item content field
        this.key = new ItemContent(
                5, // start X + 5 - padding
                5, // start Y
                (max_width - 10) * 0.8, // 80 % of width is item field - padding on both sides = 10 px
                max_height - 10, // full height without padding on both sides
                key_text,
                color
        ); 
        
        // Item address field
        this.next = new ItemAddress(
                5 + key.getWidth(), // start right after item field
                5, // start Y
                (max_width - 10) * 0.2, // 20 % of width is address field - padding on both sides = 10 px
                max_height - 10); // full height without padding on both sides
          
        // Add components to Item pane
        this.getChildren().addAll(this.key, this.next);
    }
    
    public void addPointer() {
        // first remove null pointer from item
        this.next.removeNullPointer();
        
        // add arrow as a pointer to next item
        double[] x = {this.getWidth() - 5 - this.next.getWidth()/2, this.getWidth() + 10};
        double[] y = {this.getHeight()/2, this.getHeight()/2};
        this.pointer = new Arrow(x, y);
        
        // add arrow to pane
        this.getChildren().add(this.pointer);
    }
    
    public void removePointer() {
        // remove pointer from pane
        this.getChildren().remove(this.pointer);
        
        // add null pointer
        this.next.addNullPointer();
    }
    
    public String getItemText() {
        return this.key.getKeyText();
    }
    
}
