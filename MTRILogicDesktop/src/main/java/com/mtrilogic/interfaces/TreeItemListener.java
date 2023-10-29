package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@SuppressWarnings("unused")
public interface TreeItemListener extends ItemListener {

    @NotNull
    JTree getTree();
}
