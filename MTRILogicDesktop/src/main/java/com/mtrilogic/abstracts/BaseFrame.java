package com.mtrilogic.abstracts;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public abstract class BaseFrame extends JFrame {

    protected abstract void onInitComponents(Container container);
    protected abstract void onStart();

    public BaseFrame(@NotNull Dimension dimension) {
        this("Default Frame", dimension);
    }

    public BaseFrame(@NotNull String title, @NotNull Dimension dimension) {
        super(title);
        setSize(dimension);
        onInitComponents(getContentPane());
        if (onFrameConfiguration()) {
            start();
        }
    }

    public void start(){
        setVisible(true);
        onStart();
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean onFrameConfiguration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        return true;
    }
}
