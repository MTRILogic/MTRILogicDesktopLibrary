package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.NodeModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("unused")
public class TreeAdapter<NM extends NodeModel> extends DefaultTreeModel {

    private final Class<NM> clazz;

    public TreeAdapter(@NotNull NM rootItem, @NotNull Class<NM> clazz) {
        super(rootItem);
        this.clazz = clazz;
    }

    public TreeAdapter(@NotNull NM rootItem, boolean asksAllowsChildren, @NotNull Class<NM> clazz) {
        super(rootItem, asksAllowsChildren);
        this.clazz = clazz;
    }

    @Override
    public NM getRoot() {
        return clazz.cast(super.getRoot());
    }

    @Override
    public NM getChild(Object parent, int index) {
        return clazz.cast(super.getChild(parent, index));
    }
}
