/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import java.util.LinkedList;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author vapo
 */
public class ItemList extends Pane {
    private Variable head, end, pom, com;
    private LinkedList<Item> item_list;
    private int state = 0;
    private Comment comment;
    
    public ItemList() {
        // Call superior constructor
        super();
        
        // use reset method
        this.Reset();
    }

    public void ShowVariables() {
        // Create Head text without arrow
        this.head = new Variable(10, 50, "HEAD:");
        
        // create pom variable
        this.pom = new Variable(10, 150, "POM:");
        
        // create end variable
        this.end = new Variable(10, 200, "END:");
        
        // create comment variable
        this.com = new Variable(10, 250, "Commentary:");
        
        // add variables to list
        this.getChildren().addAll(head, pom, end, com);
    }
    
    public void AddNewItemToList() {
        // declare local item variable
        Item item;

        if (this.item_list.isEmpty()) {
            // create new item
            item = new Item(100, 40, 100, 75, "Item", Color.GREENYELLOW);
        }
        else {
            Item last_item = item_list.getLast();

            double space = 10;
            double x = last_item.getLayoutX() + last_item.getPrefWidth() + space;
            double y = last_item.getLayoutY();
            String label = last_item.getItemText();

            item = new Item(100, 40, x, y, label, Color.GREENYELLOW);
        }

        // add new item to pane
        this.getChildren().add(item);

        // add item to item list
        this.item_list.addLast(item);
    }
    
    public void RemoveLastItem() {
        Item last_item = this.item_list.pollLast();
        
        if (last_item != null)
            this.getChildren().remove(last_item);
        else
            System.out.println("List is empty.");
    }
    
    public void nextStep() {      
        if ((this.state == 0) && (this.item_list.size() < 6)) {            
            // empty list - go to state 1 - create new head arrow
            if (this.item_list.isEmpty())
                this.state = 1;
            else
                this.state = 2;
            
            // Create new Item
            this.AddNewItemToList();
            
            // Create arrow from Pom to Item
            this.pom.ReplaceArrow(30 + this.item_list.size() * 110, -35);

            // remove head arrow and remove end arrow
        }
        else if ((this.state == 1) && (this.item_list.size() == 1)) {
            // Create a new head arrow
            this.head.ReplaceArrow(140, 25);
            this.state = 3;
        }
        else if (this.state == 2) {
            this.item_list.get(this.item_list.size() - 2).addPointer();
            this.state = 3;
        }
        else if (this.state == 3) {
            // Create the end arrow
            this.end.ReplaceArrow(50 + this.item_list.size() * 110, -85);
            this.state = 4;
        }
        
        else if (this.state == 4) {
            // Remove Pom arrow to the last Item
            this.pom.RemoveArrow();
            this.state = 0;
        }
        
        // show commentary
        this.showComment();
    }

    public void prevStep() {
        switch (this.state) {
            case 0:
                if (this.item_list.isEmpty()) {
                    this.end.RemoveArrow();
                    this.head.RemoveArrow();
                    this.pom.RemoveArrow();
                }
                else {
                    this.pom.ReplaceArrow(30 + this.item_list.size() * 110, -35);
                    this.state = 4;
                }   break;

            case 1:
                this.RemoveLastItem();
                this.pom.RemoveArrow();
                this.state = 0;
                break;
            case 2:
                this.RemoveLastItem();
                this.pom.RemoveArrow();
                this.state = 0;
                break;
            case 3:
                if (this.item_list.size() == 1) {
                    this.head.RemoveArrow();
                    this.state = 1;
                }
                else {
                    this.item_list.get(this.item_list.size() - 2).removePointer();
                    this.state = 2;
                }   break;
            case 4:
                if (this.item_list.size() == 1)
                    this.end.RemoveArrow();
                else
                    this.end.ReplaceArrow(50 + (this.item_list.size() - 1) * 110, -85);
                this.state = 3;
                break;
            default:
                break;
        }
        // show commentary
        this.showComment();
    }
    
    public final void Reset() {
        // set state to 0
        this.state = 0;
        
        // initialize link list
        this.item_list = new LinkedList<Item>();
        
        // clear all pane children
        this.getChildren().clear();
        
        // show variables
        this.ShowVariables();
        
        // show comment
        this.showComment();
    }
    
    public void showComment() {
        String text = "";
        
        // firstly remove comment if there is any
        this.getChildren().remove(this.comment);
        
        // add comment according to state
        switch (this.state) {
            case 0:
                if (this.item_list.isEmpty())
                    text = "Click next step to add new item"
                            + " at the end of linked list.";
                else if (this.item_list.size() == 6)
                    text = "The Reference to the last item assigned to pom"
                            + " variable has been removed.\n"
                            + " List is full, to continue click prev step or"
                            + " reset to start from scratch.";
                else
                    text = "The Reference to the last item assigned to pom"
                            + " variable has been removed.\n"
                            + " Click next step to add new item"
                            + " at the end of linked list.";
                break;
            case 1:
                text = "A new item has been created and pom variable is a reference to its instance.";
                break;
            case 2:
                text = "A new item has been created and pom variable is a reference to its instance.";
                break;
            case 3:
                if (this.item_list.size() == 1)
                    text = "A reference to the first item of the linked list has been assigned to head variable.";
                else
                    text = "Reference to the last item has been assigned to the previous item.";
                break;
            case 4:
                text = "A reference to the item has been assigned to the end variable.";
            default:
                break;
        }
                      
        this.comment = new Comment(10, 275, text);
        this.getChildren().add(this.comment); 
    }
}
