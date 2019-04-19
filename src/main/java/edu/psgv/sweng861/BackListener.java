package edu.psgv.sweng861;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BackListener implements ActionListener {
	
	JFrame frame;
	
	

	public BackListener(JFrame frame) {
		super();
		this.frame = frame;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.frame.dispose();
		SwingUtilities.invokeLater(new UserInterface());

	}

}
