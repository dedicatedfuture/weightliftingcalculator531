package edu.psgv.sweng861;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class StrengthStandardTable  extends JPanel{
    private boolean DEBUG = false;
    
    private boolean sex;
    private double userWeight;
    private JFrame frame; 

 
    public StrengthStandardTable(boolean sex, double userWeight, JFrame frame) {
        super(new GridLayout(1,0));
        
        this.setPreferredSize(new Dimension(700,30));
        this.sex = sex;
        this.userWeight = userWeight;
        this.frame = frame;
        
        JTable table = new JTable(new StrengthTableModel(this.sex, this.userWeight));
        table.setPreferredScrollableViewportSize(new Dimension(700, 30));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        JPanel buttonspot = new JPanel();
        buttonspot.setLayout(new BorderLayout());
        JButton backButton = new JButton("Back");
        
        
        
        backButton.addActionListener(new BackListener(this.frame));
        
        
        
        buttonspot.add(backButton, BorderLayout.SOUTH);
 
       
 
        //Add the scroll pane to this panel.
        //add(scrollPane);
        buttonspot.add(scrollPane, BorderLayout.CENTER);
        add(buttonspot);
        
    
    }
}
