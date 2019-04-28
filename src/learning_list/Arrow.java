/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_list;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author vapo
 */

public class Arrow extends Path {
    private static final double defaultArrowHeadSize = 10.0;
    
    public Arrow() {
        super();
    }
    
    public Arrow(double[] x, double[] y) {
        super();
        
        if (x.length != y.length)
            throw new IllegalArgumentException("X and Y arrys have different length.");
        
        strokeProperty().bind(fillProperty());
        setFill(Color.BLACK);
        
        for (int i=0; i < (x.length - 1); i++) {
            getElements().add(new MoveTo(x[i], y[i]));
            getElements().add(new LineTo(x[i + 1], y[i + 1]));
        }
        
        //ArrowHead
        double x_end = x[x.length - 1];
        double x_prev_end = x[x.length - 2];
        double y_end = y[y.length - 1];
        double y_prev_end = y[y.length - 2];
        
        
        double angle = Math.atan2((y_end - y_prev_end), (x_end - x_prev_end)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        
        //point1
        double hx1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + x_end;
        double hy1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + y_end;
        
        //point2
        double hx2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + x_end;
        double hy2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + y_end;
        
        getElements().add(new LineTo(hx1, hy1));
        getElements().add(new LineTo(hx2, hy2));
        getElements().add(new LineTo(x_end, y_end));    
    }
    /*
    public Arrow(double startX, double startY, double endX, double endY, double arrowHeadSize){
        super();
        strokeProperty().bind(fillProperty());
        setFill(Color.BLACK);
        
        //Line
        getElements().add(new MoveTo(startX, startY));
        getElements().add(new LineTo(endX, endY));
        
        //ArrowHead
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        
        getElements().add(new LineTo(x1, y1));
        getElements().add(new LineTo(x2, y2));
        getElements().add(new LineTo(endX, endY));
    }
    
    public Arrow(double startX, double startY, double endX, double endY){
        this(startX, startY, endX, endY, defaultArrowHeadSize);
    }*/
}
