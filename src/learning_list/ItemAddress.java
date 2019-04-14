/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import static javafx.scene.paint.Color.GRAY;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author vapo
 */
public class ItemAddress extends Rectangle{
    public ItemAddress(
            double positionX,
            double positionY,
            double width,
            double height)
    {
        super(positionX, positionY, width, height);
        setFill(GRAY);
    }   
}
