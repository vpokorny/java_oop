/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import java.util.LinkedList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class ItemList extends Pane {
    private LinkedList<Item> item_list;
    private NullPointer start_null_pointer, end_null_pointer;
    
    public ItemList(
            double max_width,
            double max_height,
            int number_of_initial_items) {
        // Call superior constructor
        super();
        
        // Set immutable origin for list drawing
        double x0 = 100;
        double y0 = 100;
        double space_between_items = 20;
        
        // Initialize mutable counters
        double start_x_position = x0;
        double start_y_position = y0;
        
        // Initialize LinkedList
        item_list = new LinkedList<Item>();
        
        // Initialization of sample linked list
        for (int i = 0; i < number_of_initial_items; i++) {
            String item_text = "Item_" + i;
            
            // Obtain current item dimensions in pixels
            double item_max_width = item_text.length() * 10 + 40;
            double item_max_height = 40;
            
            // Check if the item will 
            /*
            if ((item_max_width + start_x_position) > max_width) {
                System.out.println("Unable to add more items - max_width has been reached");
                break;
            }*/
            
            // Create new item
            Item new_item = new Item(
                    item_max_width,
                    item_max_height,
                    start_x_position,
                    start_y_position,
                    item_text);
            
            // Bring item back to have visible arrows
            new_item.toBack();
            
            // Add new item to list
            item_list.addLast(new_item);
            
            // Add new item to the pane
            this.getChildren().add(new_item);
            
            if (i != 0) {
                Arrow arrow = new Arrow(
                        start_x_position - space_between_items - 10,
                        start_y_position + item_max_height/2,
                        start_x_position,
                        start_y_position + item_max_height/2,
                        5.0);
                this.getChildren().add(arrow);
            }
                        
            // Add space pixels to start position
            start_x_position += space_between_items + item_max_width;   
        }

        // Add null pointer for first item address field
        start_null_pointer = new NullPointer(x0 + 15, y0 + 20, 0, 60);
        this.getChildren().add(start_null_pointer);
        
        // Add null pointer for last item address field
        end_null_pointer = new NullPointer(
                start_x_position - space_between_items - 15,
                start_y_position + 20,
                0,
                60);
        this.getChildren().add(end_null_pointer);
    }
     
    public void AddItem(String key_text) {
        this.getChildren().remove(this.end_null_pointer);
    }
}
