package edu.psgv.sweng861;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StrengthStandardTable  extends JPanel{
    private boolean DEBUG = false;
    
    private boolean sex;
    private double userWeight;

 
    public StrengthStandardTable(boolean sex, double userWeight) {
        super(new GridLayout(1,0));
 
        this.sex = sex;
        this.userWeight = userWeight;
        
        JTable table = new JTable(new StrengthTableModel(this.sex, this.userWeight));
        table.setPreferredScrollableViewportSize(new Dimension(1500, 70));
        table.setFillsViewportHeight(true);
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}
