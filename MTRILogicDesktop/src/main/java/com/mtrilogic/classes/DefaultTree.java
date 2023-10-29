package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ExpandableModel;
import com.mtrilogic.adapters.TreeAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTree<EM extends ExpandableModel> extends JTree {

    public DefaultTree() {
        super();
    }

    public DefaultTree(@NotNull EM[] items) {
        super(items);
    }

    public DefaultTree(@NotNull Vector<EM> items) {
        super(items);
    }

    public DefaultTree(@NotNull Hashtable<EM, EM> items) {
        super(items);
    }

    public DefaultTree(@NotNull EM rootItem) {
        super(rootItem);
    }

    public DefaultTree(@NotNull EM rootItem, boolean asksAllowsChildren) {
        super(rootItem, asksAllowsChildren);
    }

    public DefaultTree(@NotNull TreeAdapter<EM> adapter) {
        super(adapter);
    }

    public <TA extends TreeAdapter<EM>> TA getAdapter(@NotNull Class<TA> clazz){
        return clazz.cast(getModel());
    }
}
