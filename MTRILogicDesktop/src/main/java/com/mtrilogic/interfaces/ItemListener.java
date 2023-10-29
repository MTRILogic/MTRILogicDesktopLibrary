package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

public interface ItemListener extends OnPrintLineListener{

    /**
     * Invoked when an item is selected
     *
     * @param  event   description of parameter
     */
    void onItemClick(@NotNull MouseEvent event);
}
