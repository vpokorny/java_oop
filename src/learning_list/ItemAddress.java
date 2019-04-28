/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.GRAY;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class ItemAddress extends StackPane {

    private final Rectangle address_field;
    private Text pointer;

    public ItemAddress(
            double x,
            double y,
            double width,
            double height) {
        super();

        // set origin of pane
        this.setLayoutX(x);
        this.setLayoutY(y);

        // create background gray field
        this.address_field = new Rectangle(x, y, width, height);
        this.address_field.setFill(GRAY);

        // add elements to pane
        this.getChildren().add(this.address_field);
        
        // add null pointer
        this.addNullPointer();
    }

    public void removeNullPointer() {
        this.getChildren().remove(this.pointer);
    }
    
    public final void addNullPointer() {
        // Add initial null pointer as x text
        this.pointer = new Text("x");
        
        // add pointer to stackpane
        this.getChildren().add(this.pointer);
    }
}
