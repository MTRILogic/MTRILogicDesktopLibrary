package com.mtrilogic.abstracts;

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

    protected final DefaultTreeCellRenderer renderer;
    protected final TreeItemListener listener;
    protected final Class<EM> clazz;

    protected abstract boolean onTreeItemRenderer(JTree tree, EM value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus);

    public TreeItem(@NotNull Class<EM> clazz, @NotNull TreeItemListener listener){
        this(null, clazz, listener);
    }

    public TreeItem(DefaultTreeCellRenderer renderer, @NotNull Class<EM> clazz, @NotNull TreeItemListener listener){
        if (renderer == null){
            renderer = new DefaultTreeCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onItemClick(e);
            }
        });
    }

    @Override
    public final Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (!onTreeItemRenderer(tree, clazz.cast(value), selected, expanded, leaf, row, hasFocus)){
            return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        } else {
            return this;
        }
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }
}
