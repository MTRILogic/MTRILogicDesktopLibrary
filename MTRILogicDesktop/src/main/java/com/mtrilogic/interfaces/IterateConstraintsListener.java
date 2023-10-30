package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public interface IterateConstraintsListener {

    void onIterateConstraints(@NotNull String key, @NotNull SpringLayout.Constraints constraints);
}
