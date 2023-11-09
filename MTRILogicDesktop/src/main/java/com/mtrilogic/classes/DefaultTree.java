package com.mtrilogic.classes;

import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.abstracts.TreeItem;
import com.mtrilogic.adapters.TreeAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTree<NM extends NodeModel> extends JTree {

    public DefaultTree() {
        super();
    }

    public DefaultTree(@NotNull NM[] items) {
        super(items);
    }

    public DefaultTree(@NotNull Vector<NM> items) {
        super(items);
    }

    public DefaultTree(@NotNull Hashtable<NM, NM> items) {
        super(items);
    }

    public DefaultTree(@NotNull NM rootItem) {
        super(rootItem);
    }

    public DefaultTree(@NotNull NM rootItem, boolean asksAllowsChildren) {
        super(rootItem, asksAllowsChildren);
    }

    public DefaultTree(@NotNull TreeAdapter<NM> adapter) {
        super(adapter);
    }

    public TreeAdapter<NM> getAdapter(@NotNull Class<TreeAdapter<NM>> clazz){
        return clazz.cast(getModel());
    }

    public void setAdapter(@NotNull TreeAdapter<NM> adapter){
        setModel(adapter);
    }

    public TreeItem<NM> getItem(Class<TreeItem<NM>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public void setItem(@NotNull TreeItem<NM> item){
        setCellRenderer(item);
    }
}
