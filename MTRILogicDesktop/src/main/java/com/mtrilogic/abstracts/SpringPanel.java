package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.IterateConstraintsListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public abstract class SpringPanel extends JPanel {

    private Component component, northComponent, westComponent, southComponent, eastComponent;
    private boolean northEnabled, westEnabled, southEnabled, eastEnabled;
    private int northPad, westPad, southPad, eastPad;

    public SpringPanel(){
        setLayout(new SpringLayout());
    }

    public SpringPanel with(@NotNull Component component){
        this.component = component;
        return this;
    }

    public void iterateConstraints(@NotNull String key, @NotNull IterateConstraintsListener listener, @NotNull Component... components){
        SpringLayout layout = (SpringLayout) getLayout();
        for (Component component : components){
            listener.onIterateConstraints(key, layout.getConstraints(component));
        }
    }

    public SpringLayout.Constraints getConstraints(@NotNull Component component){
        SpringLayout layout = (SpringLayout) getLayout();
        return layout.getConstraints(component);
    }

    // Este método debe llamarse por cada componente añadido al layout,
    // después de establecer sus posiciones north, south, east y west.
    public void apply(){
        SpringLayout layout = (SpringLayout) getLayout();
        if (northEnabled) {
            if (northComponent != null) {
                layout.putConstraint(SpringLayout.NORTH, component, northPad, SpringLayout.SOUTH, northComponent);
                northComponent = null;
            } else {
                layout.putConstraint(SpringLayout.NORTH, component, northPad, SpringLayout.NORTH, this);
            }
            northEnabled = false;
            northPad = 0;
        }
        if (southEnabled) {
            if (southComponent != null) {
                layout.putConstraint(SpringLayout.SOUTH, component, -southPad, SpringLayout.NORTH, southComponent);
                southComponent = null;
            } else {
                layout.putConstraint(SpringLayout.SOUTH, component, -southPad, SpringLayout.SOUTH, this);
            }
            southEnabled = false;
            southPad = 0;
        }
        if (eastEnabled) {
            if (eastComponent != null) {
                layout.putConstraint(SpringLayout.EAST, component, -eastPad, SpringLayout.WEST, eastComponent);
                eastComponent = null;
            } else {
                layout.putConstraint(SpringLayout.EAST, component, -eastPad, SpringLayout.EAST, this);
            }
            eastEnabled = false;
            eastPad = 0;
        }
        if (westEnabled) {
            if (westComponent != null) {
                layout.putConstraint(SpringLayout.WEST, component, westPad, SpringLayout.EAST, westComponent);
                westComponent = null;
            } else {
                layout.putConstraint(SpringLayout.WEST, component, westPad, SpringLayout.WEST, this);
            }
            westEnabled = false;
            westPad = 0;
        }
    }

    public SpringPanel north(JComponent northComponent, int northPad){
        this.northComponent = northComponent;
        this.northPad = northPad;
        northEnabled = true;
        return this;
    }

    public SpringPanel north(int northPad){
        return north(null, northPad);
    }

    public SpringPanel south(JComponent southComponent, int southPad){
        this.southComponent = southComponent;
        this.southPad = southPad;
        southEnabled = true;
        return this;
    }

    public SpringPanel south(int southPad){
        return south(null, southPad);
    }

    public SpringPanel east(JComponent eastComponent, int eastPad){
        this.eastComponent = eastComponent;
        this.eastPad = eastPad;
        eastEnabled = true;
        return this;
    }

    public SpringPanel east(int eastPad) {
        return east(null, eastPad);
    }

    public SpringPanel west(JComponent westComponent, int westPad){
        this.westComponent = westComponent;
        this.westPad = westPad;
        westEnabled = true;
        return this;
    }

    public SpringPanel west(int westPad){
        return west(null, westPad);
    }

    public void makeFixedGrid(int rows, int cols, int width, int height, int x, int y, int xPad, int yPad){
        int max = rows * cols;

        if (getComponentCount() == max){
            SpringLayout layout = (SpringLayout) getLayout();

            int maxHeight = (height - (rows * yPad) - y) / rows;
            int maxWidth = (width - (cols * xPad ) - x) / cols;

            Spring maxHeightSpring = Spring.constant(maxHeight);
            Spring maxWidthSpring = Spring.constant(maxWidth);
            Spring xPadSpring = Spring.constant(xPad);
            Spring yPadSpring = Spring.constant(yPad);
            Spring xSpring = Spring.constant(x);
            Spring ySpring = Spring.constant(y);

            SpringLayout.Constraints lastRowConstraints = null;
            SpringLayout.Constraints lastConstraints = null;
            for (int i = 0; i < max; i++){
                SpringLayout.Constraints constraints = layout.getConstraints(getComponent(i));
                constraints.setHeight(maxHeightSpring);
                constraints.setWidth(maxWidthSpring);

                if (i % cols == 0){ // start of new row
                    lastRowConstraints = lastConstraints;
                    constraints.setX(xSpring);
                }else {
                    constraints.setX(Spring.sum(lastConstraints.getConstraint(SpringLayout.EAST), xPadSpring));
                }

                if (i / cols == 0){ // first row
                    constraints.setY(ySpring);
                }else {
                    if (lastRowConstraints != null) {
                        constraints.setY(Spring.sum(lastRowConstraints.getConstraint(SpringLayout.SOUTH), yPadSpring));
                    }
                }

                lastConstraints = constraints;
            }

            SpringLayout.Constraints constraints = layout.getConstraints(this);
            if (lastConstraints != null) {
                constraints.setConstraint(SpringLayout.SOUTH, Spring.sum(yPadSpring, lastConstraints.getConstraint(SpringLayout.SOUTH)));
                constraints.setConstraint(SpringLayout.EAST, Spring.sum(xPadSpring, lastConstraints.getConstraint(SpringLayout.EAST)));
            }
        }
    }
}
