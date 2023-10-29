package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@SuppressWarnings("unused")
public interface ComboBoxItemListener extends ItemListener{

    @NotNull
    JComboBox<Model> getComboBox();
}
