/**
 * 
 */
package com.anil.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

class Mainframe extends JFrame {
	private static final long serialVersionUID = 1581133201499203821L;

	GridBagConstraints moduleGBConstraints = new GridBagConstraints();

	EditColorsDialog editColorsDiag = new EditColorsDialog(this);

	public Mainframe(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridBagLayout());

		buildMenuLine();
		buildButtonLine();

		DrawingPanel dPanel = new DrawingPanel();
		dPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		moduleGBConstraints.gridx++;
		moduleGBConstraints.gridheight = 1;
		moduleGBConstraints.weightx = 0.7;
		moduleGBConstraints.weighty = 0;
		moduleGBConstraints.gridheight = 6;
		add(dPanel, moduleGBConstraints);
	}

	private void buildMenuLine() {
		JMenu mainMenu = new JMenu("File");
		JMenuItem menuItem = new JMenuItem("Save");
		MenuListener listener = new MenuListener();
		mainMenu.add(menuItem);
		menuItem.addActionListener(listener);

		menuItem = new JMenuItem("Load");
		mainMenu.add(menuItem);
		menuItem.addActionListener(listener);

		menuItem = new JMenuItem("Close");
		mainMenu.add(menuItem);
		menuItem.addActionListener(listener);

		menuItem = new JMenuItem("Exit");
		mainMenu.add(menuItem);
		menuItem.addActionListener(listener);

		JMenu optionsMenu = new JMenu("Options");
		menuItem = new JMenuItem("Edit Colors");
		optionsMenu.add(menuItem);
		menuItem.addActionListener(listener);

		menuItem = new JMenuItem("About");
		optionsMenu.add(menuItem);
		menuItem.addActionListener(listener);

		JMenuBar menuLine = new JMenuBar();
		menuLine.add(mainMenu);
		menuLine.add(optionsMenu);

		setJMenuBar(menuLine);
	}

	private void buildButtonLine() {
		JToolBar buttonRow = new JToolBar("Colors", 1); // VERTICAL doesn't
		// work, using 1
		buttonRow.setLayout(new GridLayout(5, 1, 4, 4));
		ButtonListener listener = new ButtonListener();
		int buttonx = 50;
		int buttony = 30;
		Dimension d = new Dimension(buttonx, buttony);

		buttonRow.setPreferredSize(null);

		JButton button = new JButton("Yellow");
		button.setPreferredSize(d);
		buttonRow.add(button);
		button.addActionListener(listener);

		button = new JButton("Red");

		button.setPreferredSize(d);
		buttonRow.add(button);
		button.addActionListener(listener);

		button = new JButton("Blue");
		button.setPreferredSize(d);
		buttonRow.add(button);
		button.addActionListener(listener);

		button = new JButton("Orange");
		button.setPreferredSize(d);
		buttonRow.add(button);
		button.addActionListener(listener);

		button = new JButton("Green");
		button.setPreferredSize(d);
		buttonRow.add(button);
		button.addActionListener(listener);

		moduleGBConstraints.fill = GridBagConstraints.VERTICAL;
		moduleGBConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		moduleGBConstraints.gridx = 0;
		moduleGBConstraints.gridy = 1;
		moduleGBConstraints.gridheight = 1;
		moduleGBConstraints.weightx = 0.3;
		moduleGBConstraints.weighty = 0;
		moduleGBConstraints.gridheight = 6;

		add(buttonRow, moduleGBConstraints);
	}

	private class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String itemName = event.getActionCommand();
			System.out.println("You pushed the menu item named \"" + itemName
					+ "\"..");
			if (itemName == "Exit") {
				System.out.println("Exiting..");
				dispose();
				System.exit(0);
			} else if (itemName == "Edit Colors") {
				editColorsDiag.showDialog();
			}
		}
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String buttonName = event.getActionCommand();
			System.out.println("You pushed the button named \"" + buttonName
					+ "\"..");
		}
	}

	@SuppressWarnings("serial")
	private class DrawingPanel extends JPanel {
		public DrawingPanel() {
			add(new JTextField("Drawing Window"));
			add(new JTextField("- Testing"));
		}
	}
}

@SuppressWarnings("serial")
class EditColorsDialog extends JDialog {
	JButton exitButton = new JButton("Close");
	ButtonListener listener = new ButtonListener();

	public EditColorsDialog(JFrame parent) {
		super(parent, "Edit Colors", true);
		add(new JLabel("Pane for editing colors"), BorderLayout.NORTH);
		add(new JLabel(), BorderLayout.CENTER);
		add(exitButton, BorderLayout.SOUTH);
		exitButton.addActionListener(listener);
		setSize(200, 300);
		setResizable(false);
	}

	public void showDialog() {
		setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String buttonName = event.getActionCommand();
			if (buttonName == "Close") {
				setVisible(false);
			}
		}
	}
}

public class Colorizer {
	public static void main(String[] args) {
		Mainframe newFrame = new Mainframe("Colorizer");
		newFrame.setVisible(true);
		newFrame.setSize(300, 400);
		newFrame.setResizable(false);
	}
}
