package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@SuppressWarnings("unused")
public interface ListItemListener extends ItemListener {

    @NotNull
    JList<Model> getList();
}
