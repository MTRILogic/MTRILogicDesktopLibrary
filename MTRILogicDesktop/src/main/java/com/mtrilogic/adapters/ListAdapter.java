package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;

import javax.swing.*;

@SuppressWarnings("unused")
public class ListAdapter<M extends Model> extends DefaultListModel<M> {

    public ListAdapter() {
        super();
    }
}
