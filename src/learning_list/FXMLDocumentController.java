/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author vapo
 */
public class FXMLDocumentController implements Initializable {
    //@FXML
    //private AnchorPane ap;
    @FXML private AnchorPane main_anchor_pane;
    
    // Declare list of items to be able to use it in methods
    private ItemList il = new ItemList(500, 500, 3);

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Add pane to main anchor pane
        main_anchor_pane.getChildren().add(il);
    }
    
    @FXML
    private void handleNextStepButtonAction(ActionEvent event) {
        il.AddItem("ahoj");
    }
}

