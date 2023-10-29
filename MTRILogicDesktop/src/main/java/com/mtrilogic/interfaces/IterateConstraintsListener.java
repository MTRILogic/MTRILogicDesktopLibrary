package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public interface IterateConstraintsListener {

    /**
     * Iterates over the constraints of the given component
     *
     * @param  key         a String representing the key
     * @param  constraints the SpringLayout.Constraints object
     */
    void onIterateConstraints(@NotNull String key, @NotNull SpringLayout.Constraints constraints);
}
