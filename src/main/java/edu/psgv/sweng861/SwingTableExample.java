package edu.psgv.sweng861;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class SwingTableExample extends JPanel {
    private boolean DEBUG = false;
   
    private double oHPressMax;
    private double deadliftMax;
	private double benchMax;
	private double squatMax;
	private JFrame frame;
 
    public SwingTableExample(double oHPressMax, double deadliftMax, double benchMax, double squatMax, JFrame frame) {
        super(new GridLayout(1,0));
 
        this.oHPressMax = oHPressMax;
        this.deadliftMax = deadliftMax;
        this.benchMax = benchMax;
        this.squatMax = squatMax;
        this.frame = frame;
        
        JTable table = new JTable(new MyTableModel(this.oHPressMax, this.deadliftMax, this.benchMax, this.squatMax));
        table.setPreferredScrollableViewportSize(new Dimension(1500, 70));
        table.setFillsViewportHeight(true);
        
        JPanel buttonspot = new JPanel();
        buttonspot.setLayout(new BorderLayout());
        JButton backButton = new JButton("Back");
        
        
        
        backButton.addActionListener(new BackListener(this.frame));
        
        //changed layout from boxlayout to border layout to get the effect i wanted
        buttonspot.add(backButton, BorderLayout.SOUTH);
 
       
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        //add(scrollPane);
        buttonspot.add(scrollPane, BorderLayout.CENTER);
        add(buttonspot);
    }
}