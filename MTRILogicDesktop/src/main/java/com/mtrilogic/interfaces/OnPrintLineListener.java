package com.mtrilogic.interfaces;

import org.jetbrains.annotations.NotNull;

public interface OnPrintLineListener {

    /**
     * Invoked when a line needs to be printed
     *
     * @param  line  description of parameter
     */
    void onPrintLine(@NotNull String line);
}
