package com.anil.swing;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * JFrame is a toplevel container, which is used for placing other widgets. 

 */
public class Simple extends JFrame {

	public Simple() {

		setSize(300, 200);
		setTitle("Simple");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*
		 * To center the window on the screen, we must know the resolution of the monitor. 
		 * For this, we use the Toolkit class.
		 */
		final Toolkit toolKit = getToolkit();
		Dimension size = toolKit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
		
		//JPanel is a generic lightweight container.
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		/*
		 * By default, the JPanel has a FlowLayout manager. The layout manager is used to place widgets 
		 * onto the containers. If we call setLayout(null) we can position our components absolutely. 
		 * For this, we use the setBounds() method. 
		 */
		panel.setLayout(null);
		
		JButton beep = new JButton("beep");
		beep.setBounds(150, 60, 80, 30);
		/*
		 * The action listener will be called, when we perform an action on the button.
		 */
		beep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				toolKit.beep();
			}
		});
		
		JButton close = new JButton("Close");
		close.setBounds(50, 60, 80, 30);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		
		//Set up ToolTip shown when we hover over the component
		close.setToolTipText("Close the Window!!");
		JLabel label = new JLabel("<html><head></head><body><a href=www.google.com>Google</a></body></html>");
		label.setBounds(150, 20, 80, 30);
		
		JLabel label1 = new JLabel("Anil");
		panel.add(label);
		panel.add(label1);
		panel.add(beep);
		panel.add(close);
		
	}

	public static void main(String[] args) {

		Simple simple = new Simple();
		simple.setVisible(true);

	}
}
