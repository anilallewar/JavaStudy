package com.anil.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class ToolTip extends JDialog{

	public ToolTip(){
		setTitle("Tool Tip");
		showToolTip();
	}
	
	private void showToolTip(){
		
		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
		/*
		 * The basic panel is added to the default JDialog component. 
		 * This component has a border layout manager by default. 
		 */
		add(basic);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout(0,0));
		/*
		 * If we want to have a panel, that is not greater than it's components, we must 
		 * set it's maximum size. The zero value is ignored. The manager calculates the 
		 * necessary heights. 
		 */
		topPanel.setMaximumSize(new Dimension(450,0));
		
		JLabel hint = new JLabel("JDeveloper Productivity Hints");
        hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        //For BorderLayout, the component is added by default to CENTER
        topPanel.add(hint);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("MT10_16x16_A.png"));
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        topPanel.add(label, BorderLayout.EAST);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.gray);
        topPanel.add(separator, BorderLayout.SOUTH);
        
        basic.add(topPanel);
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        
        JTextPane pane = new JTextPane();
        
        pane.setContentType("text/html");
        String text = "<p><b>Closing windows using the mouse wheel</b></p>" +
            "<p>Clicking with the mouse wheel on an editor tab closes the window. " +
            "This method works also with dockable windows or Log window tabs.</p>";
        pane.setText(text);
        pane.setEditable(false);
        textPanel.add(pane);

        basic.add(textPanel);
        
        JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20,0));
        
        JCheckBox box = new JCheckBox("Show Tool Tip at startup");
        box.setMnemonic(KeyEvent.VK_S);
        
        boxPanel.add(box);
        basic.add(boxPanel);
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton ntip = new JButton("Next Tip");
        ntip.setMnemonic(KeyEvent.VK_N);
        JButton close = new JButton("Close");
        close.setMnemonic(KeyEvent.VK_C);

        bottomPanel.add(ntip);
        bottomPanel.add(close);
        basic.add(bottomPanel);

        bottomPanel.setMaximumSize(new Dimension(450, 0));

        setSize(new Dimension(450, 350));
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToolTip tip = new ToolTip();
	}

}
