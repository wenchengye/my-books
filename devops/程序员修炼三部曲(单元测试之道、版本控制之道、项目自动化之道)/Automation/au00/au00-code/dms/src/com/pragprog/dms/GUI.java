/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class GUI {

    private JFrame frame;

    public GUI() {
    }

    private void display() {
        frame = createUI();
        frame.setVisible(true);
    }

    private JFrame createUI() {

        JFrame frame = createFrame("DMS 1.0");

        JMenuBar menuBar = createMenubar();
        frame.setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        frame.getContentPane().add("Center", panel);
        frame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 700;
        int height = 500;
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;
        frame.setBounds(x, y, width, height);
        frame.setSize(width, height);

        return frame;
    }

    private JFrame createFrame(String title) {

        JFrame frame = new JFrame(title);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBackground(SystemColor.control);

        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                new ExitAction().actionPerformed(null);
            }
        });

        return frame;
    }

    private JMenuBar createMenubar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.add(createMenuItem("Open"));
        menuBar.add(file);
        JMenu about = new JMenu("About");
        about.add(createMenuItem("Help"));
        menuBar.add(about);
        return menuBar;
    }

    private JMenuItem createMenuItem(String name) {
        JMenuItem mi = new JMenuItem(name);
        mi.setEnabled(true);
        return mi;
    }

    private class ExitAction extends AbstractAction {

        ExitAction() {
            super("Exit");
        }

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GUI().display();
    }
}
