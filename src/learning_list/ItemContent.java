/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.GREEN;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class ItemContent extends StackPane {
    private final Text key_text;
    private final Rectangle bg_rec;
    
    public ItemContent(
            double positionX,
            double positionY,
            double width,
            double height,
            String key) {
        
        // Set begining of box with rectangle and text inside
        this.setLayoutX(positionX);
        this.setLayoutY(positionY);
        this.setHeight(height);
        this.setWidth(width);
        
        bg_rec = new Rectangle(positionX, positionY, width, height);
        bg_rec.setFill(GREEN);
        
        key_text = new Text(key);
        //key_text.autosize();
        
        // debug
        // System.out.println("Item-content: width:" + width + " - height:" + height);
        
        this.getChildren().addAll(bg_rec, key_text);
    }
}
