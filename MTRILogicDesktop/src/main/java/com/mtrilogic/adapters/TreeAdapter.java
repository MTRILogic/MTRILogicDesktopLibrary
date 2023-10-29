package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.ExpandableModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("unused")
public class TreeAdapter<EM extends ExpandableModel> extends DefaultTreeModel {

    private final Class<EM> clazz;

    public TreeAdapter(@NotNull EM rootItem, @NotNull Class<EM> clazz) {
        super(rootItem);
        this.clazz = clazz;
    }

    public TreeAdapter(@NotNull EM rootItem, boolean asksAllowsChildren, @NotNull Class<EM> clazz) {
        super(rootItem, asksAllowsChildren);
        this.clazz = clazz;
    }

    @Override
    public EM getRoot() {
        return clazz.cast(super.getRoot());
    }

    @Override
    public EM getChild(Object parent, int index) {
        return clazz.cast(super.getChild(parent, index));
    }
}
