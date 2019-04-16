package edu.psgv.sweng861;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

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
        
        
        JPanel buttonspot = new JPanel();
        buttonspot.setLayout(new BorderLayout());
        JButton backButton = new JButton("Back");
        
        
        
        backButton.addActionListener(new ClickListener(){
        		public void actionPerformed(ActionEvent arg) {
        			SwingUtilities.invokeLater(new UserInterface());
        		}
        });
        
        
        buttonspot.add(backButton, BorderLayout.SOUTH);
 
       
 
        //Add the scroll pane to this panel.
        //add(scrollPane);
        buttonspot.add(scrollPane, BorderLayout.CENTER);
        add(buttonspot);
 
    
    }
}
