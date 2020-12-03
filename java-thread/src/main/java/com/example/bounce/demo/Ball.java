package com.example.bounce.demo;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author: slm
 */
public class Ball {

    public static final int XSIZE = 15;
    public static final int YSIZE = 15;

    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;

        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }

        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }

        if (y < bounds.getMinY()) {
            y = bounds.getMaxY();
            dy = -dy;
        }

        if (y + YSIZE >= bounds.getMinY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = - dy;
        }
    }


    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
