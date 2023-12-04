package com.mtrilogic.classes;

import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.abstracts.TreeItem;
import com.mtrilogic.adapters.TreeAdapter;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTree<NM extends NodeModel> extends JTree {

    public DefaultTree() {
        super();
    }

    public DefaultTree(NM[] items) {
        super(items);
    }

    public DefaultTree(Vector<NM> items) {
        super(items);
    }

    public DefaultTree(Hashtable<NM, NM> items) {
        super(items);
    }

    public DefaultTree(NM rootItem) {
        super(rootItem);
    }

    public DefaultTree(NM rootItem, boolean asksAllowsChildren) {
        super(rootItem, asksAllowsChildren);
    }

    public DefaultTree(TreeAdapter<NM> adapter) {
        super(adapter);
    }

    public TreeAdapter<NM> getAdapter(Class<TreeAdapter<NM>> clazz){
        return clazz.cast(getModel());
    }

    public void setAdapter(TreeAdapter<NM> adapter){
        setModel(adapter);
    }

    public TreeItem<NM> getItem(Class<TreeItem<NM>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public void setItem(TreeItem<NM> item){
        setCellRenderer(item);
    }
}
