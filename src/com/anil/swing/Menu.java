package com.anil.swing;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Menu extends JFrame {

	private JLabel statusbar;
	private Toolkit toolkit;
	private JPopupMenu popupMenu;

	public Menu() {

		setTitle("Menu");

		// Show the top level menu
		showMenu();

		// Attach the pop up menu
		showPopUpMenu();

		// Show toobal
		showToolbar();

		setSize(250, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * This method is used to show the Top level menu on the frame
	 */
	private void showMenu() {
		JMenuBar menubar = new JMenuBar();
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"MT10_16x16_A.png"));

		JMenu file = new JMenu("File");
		// The file menu can be accessed using ALT+F
		file.setMnemonic(KeyEvent.VK_F);

		JMenu imp = new JMenu("Import");
		file.setMnemonic(KeyEvent.VK_I);

		JMenuItem newsf = new JMenuItem("Import newsfeed list...");
		JMenuItem bookm = new JMenuItem("Import bookmarks...");
		JMenuItem mail = new JMenuItem("Import mail...");

		imp.add(newsf);
		imp.add(bookm);
		imp.add(mail);

		JMenu fileNew = new JMenu("New");
		file.setMnemonic(KeyEvent.VK_N);

		JMenu fileSave = new JMenu("Save");
		file.setMnemonic(KeyEvent.VK_S);

		JMenuItem close = new JMenuItem("Close", icon);
		close.setMnemonic(KeyEvent.VK_C);
		close.setToolTipText("Close the application");

		/*
		 * An accelerator is a key shortcut that launches a menu item. In our
		 * case, by pressing Ctrl + W we close the application.
		 */
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				ActionEvent.CTRL_MASK));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		/*
		 * New menu for showing the check box menu item
		 */
		JMenu view = new JMenu("View");

		JCheckBoxMenuItem sbar = new JCheckBoxMenuItem("Show StatuBar");
		sbar.setState(true);

		sbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (statusbar.isVisible()) {
					statusbar.setVisible(false);
				} else {
					statusbar.setVisible(true);
				}
			}

		});

		// Add sub menu to File menu
		file.add(fileNew);
		file.add(fileSave);
		file.addSeparator();
		file.add(imp);
		file.addSeparator();
		file.add(close);
		// Add sub menu to view menu
		view.add(sbar);

		menubar.add(file);
		menubar.add(view);

		setJMenuBar(menubar);

		statusbar = new JLabel(" Statusbar");
		statusbar.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		add(statusbar, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to show the popup menu on the current frame
	 */
	private void showPopUpMenu() {

		toolkit = getToolkit();
		popupMenu = new JPopupMenu();

		JMenuItem beep = new JMenuItem("Beep Popup");
		beep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// DOES NOT WORK
				//statusbar = new JLabel("Beep Popped!!");
				statusbar.setVisible(true);
				// statusbar.setVisible(true);
				toolkit.beep();
			}
		});

		popupMenu.add(beep);

		JMenuItem close = new JMenuItem("Close Popup");
		close.setMnemonic(KeyEvent.VK_C);
		close.setToolTipText("Close the application");

		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		popupMenu.add(close);

		// Add the mouseListener on the current object(since we are extending
		// the JFrame)
		// so that the popup menu is shown on mouse right click

		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent event) {
				if (event.getButton() == event.BUTTON3) {
					popupMenu.show(event.getComponent(), event.getX(), event
							.getY());
				}
			}
		});

	}

	/**
	 * This method is used to show ToolBar. Note that more than one toolbar can be 
	 * added with vertical or horizontal alignment
	 */
	private void showToolbar() {
		JToolBar toolbar = new JToolBar();

		ImageIcon icon = new ImageIcon(getClass().getResource(
				"MT10_16x16_A.png"));

		JButton exit = new JButton(icon);
		toolbar.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}

		});

		add(toolbar, BorderLayout.NORTH);
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
        }

		new Menu();
	}

}
