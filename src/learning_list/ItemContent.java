/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class ItemContent extends StackPane {
    private final Text content;
    private final Rectangle background;
    
    public ItemContent(
            double x,
            double y,
            double width,
            double height,
            String key,
            Color color
    ) {
        
        // Set begining of box with rectangle and text inside
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setHeight(height);
        this.setWidth(width);
        
        // add background rectangle
        this.background = new Rectangle(x, y, width, height);
        this.background.setFill(color);
        
        // create label
        this.content = new Text(key);
               
        // add background and content to stack pane
        this.getChildren().addAll(this.background, this.content);
    }
    
    public String getKeyText() {
        return this.content.getText();
    }
}
