package com.mtrilogic.tests.treemodel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {
    FamilyTree tree;
    private static final String SHOW_ANCESTOR_CMD = "showAncestor";

    public Main() {
        super(new BorderLayout());

        // Construct the panel with the toggle buttons.
        JRadioButton showDescendant = new JRadioButton("Show descendants", true);
        final JRadioButton showAncestor = new JRadioButton("Show ancestors");
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(showDescendant);
        bGroup.add(showAncestor);
        showDescendant.addActionListener(this);
        showAncestor.addActionListener(this);
        showAncestor.setActionCommand(SHOW_ANCESTOR_CMD);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showDescendant);
        buttonPanel.add(showAncestor);

        // Construct the tree.
        tree = new FamilyTree(getGenealogyGraph());
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        // Add everything to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        tree.showAncestor(ae.getActionCommand().equals(SHOW_ANCESTOR_CMD));
    }

    public Person getGenealogyGraph() {
        // the greatgrandparent generation
        Person a1 = new Person("A");
        Person a2 = new Person("B");
        Person a3 = new Person("C");
        Person a4 = new Person("D");
        Person a5 = new Person("E");
        Person a6 = new Person("F");

        // the grandparent generation
        Person b1 = new Person("G");
        Person b2 = new Person("H");
        Person b3 = new Person("I");
        Person b4 = new Person("J");
        Person b5 = new Person("K");
        Person b6 = new Person("L");
        Person b7 = new Person("M");
        Person b8 = new Person("N");
        Person b9 = new Person("O");

        // the parent generation
        Person c1 = new Person("P");
        Person c2 = new Person("Q");
        Person c3 = new Person("R");
        Person c4 = new Person("S");
        Person c5 = new Person("T");
        Person c6 = new Person("U");
        Person c7 = new Person("V");
        Person c8 = new Person("W");
        Person c9 = new Person("X");

        // the youngest generation
        Person d1 = new Person("X");
        Person d2 = new Person("Y");

        Person.linkFamily(a1, a2, new Person[] { b1, b2, b3, b4 });
        Person.linkFamily(a3, a4, new Person[] { b5, b6, b7 });
        Person.linkFamily(a5, a6, new Person[] { b8, b9 });
        Person.linkFamily(b3, b6, new Person[] { c1, c2, c3 });
        Person.linkFamily(b4, b5, new Person[] { c4, c5, c6 });
        Person.linkFamily(b8, b7, new Person[] { c7, c8, c9 });
        Person.linkFamily(c4, c7, new Person[] { d1, d2 });

        System.out.println(b3.getChildCount());

        return a1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GenealogyExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main newContentPane = new Main();
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
}