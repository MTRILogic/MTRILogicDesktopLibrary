package com.mtrilogic.abstracts;

import com.mtrilogic.classes.DefaultTree;
import com.mtrilogic.interfaces.TreeItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class TreeItem <EM extends ExpandableModel> extends SpringPanel implements TreeCellRenderer {

    protected final TreeItemListener<EM> listener;
    protected final Class<EM> clazz;

    private final DefaultTreeCellRenderer renderer;

    private boolean isSelected;
    private boolean hasFocus;
    private boolean expanded;
    private boolean leaf;
    private int row;
    private EM model;

    protected abstract boolean onTreeItemRenderer(DefaultTree<EM> tree, EM value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus);

    public TreeItem(@NotNull Class<EM> clazz, @NotNull TreeItemListener<EM> listener){
        this(null, clazz, listener);
    }

    public TreeItem(DefaultTreeCellRenderer renderer, @NotNull Class<EM> clazz, @NotNull TreeItemListener<EM> listener){
        if (renderer == null){
            renderer = new DefaultTreeCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemClick(e);
            }
        });
    }

    @Override
    public final Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (!onTreeItemRenderer(listener.getDefaultTree(), (model = clazz.cast(value)), (this.isSelected = selected), (this.expanded = expanded), (this.leaf = leaf), (this.row = row), (this.hasFocus = hasFocus))) {
            return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        } else {
            return this;
        }
    }

    public boolean isSelected(){
        return isSelected;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public boolean isExpanded(){
        return expanded;
    }

    public boolean isLeaf(){
        return leaf;
    }

    public int getRow(){
        return row;
    }

    public EM getModel(){
        return model;
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }

    protected void itemClick(@NotNull MouseEvent event){
        listener.onTreeItemClick(event, this);
    }
}
