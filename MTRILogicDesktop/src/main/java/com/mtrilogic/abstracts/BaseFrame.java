package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.PanelListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public abstract class BaseFrame extends JFrame implements PanelListener {

    protected abstract void onInitComponents(Container container);
    protected abstract void onStart();

    public BaseFrame(@NotNull Dimension dimension) {
        this("Default Frame", dimension);
    }

    public BaseFrame(@NotNull String title, @NotNull Dimension dimension) {
        super(title);
        if (onFrameConfiguration(dimension)) {
            onInitComponents(getContentPane());
            start();
        }
    }

    public void start(){
        setVisible(true);
        onStart();
    }

    @Override
    public BaseFrame getBaseFrame() {
        return this;
    }

    @SuppressWarnings("SameReturnValue")
    protected boolean onFrameConfiguration(Dimension dimension) {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(dimension);
        setLocationRelativeTo(null);
        setResizable(false);
        return true;
    }
}
