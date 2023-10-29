package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@SuppressWarnings("unused")
public interface TableItemListener extends ItemListener {

    @NotNull
    JTable getTable();
}
