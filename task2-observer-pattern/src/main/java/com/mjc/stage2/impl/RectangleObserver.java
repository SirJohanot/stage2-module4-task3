package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle changedRectangle = event.getSource();
        int changedRectangleId = changedRectangle.getId();
        double changedRectangleSideA = changedRectangle.getSideA();
        double changedRectangleSideB = changedRectangle.getSideB();

        double newSquare = changedRectangleSideA * changedRectangleSideB;
        double newPerimeter = changedRectangleSideA * 2 + changedRectangleSideB * 2;

        RectangleWarehouse.getInstance()
                .put(changedRectangleId, new RectangleValues(newSquare, newPerimeter));
    }
}
