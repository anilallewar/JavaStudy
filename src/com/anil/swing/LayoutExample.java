package com.anil.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LayoutExample extends JFrame{

	public LayoutExample(){
		super.setTitle("Layout Example");
	}
	
	/**
	 * This is the simplest layout manager in the Java Swing toolkit. It is mainly 
	 * used in combination with other layout managers. When calculating it's children 
	 * size, a flow layout lets each component assume its natural (preferred) size.
	 * 
	 * The components can be added from the right to the left or vice versa. Implicitly, 
	 * the components are centered and there is 5px space among components and components 
	 * and the edges of the container. 
	 */
	public void showFlowLayout(){
		
		/*
		 *The implicit layout manager of the JPanel component is a flow layout manager.
		 */
		JPanel panel = new JPanel();
		
		JTextArea area = new JTextArea();
		//If we didn't set the preferred size, the component would have a size of it's text.
		area.setPreferredSize(new Dimension(100,100));
		
		JButton button = new  JButton("Button");
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.out.println("Button Clicked");
			}
		});
		
		panel.add(button);
		
		/*
		 * If we create an empty tree component, there are some default values 
		 * inside the component.
		 */
		JTree tree = new JTree();
		panel.add(tree);
		
		panel.add(area);
		
		JTextField name = new JTextField(10);
		
		panel.add(name);
		//Add the panel to the top level JFrame container
		add(panel);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	/**
	 * The GridLayout layout manager lays out components in a rectangular grid. 
	 * The container is divided into equally sized rectangles. One component is 
	 * placed in each rectangle. 
	 */
	public void showGridLayout(){
		
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		/*
		 * The layout manager takes four parameters. The number of rows, the number 
		 * of columns and the horizontal and vertical gaps between components. 
		 */
		panel.setLayout(new GridLayout(5, 4, 5,5));
		
		String[] buttons = {
	            "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4", 
	            "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"
	        };


	        for (int i = 0; i < buttons.length; i++) {

	            if (i == 2) 
	                panel.add(new JLabel(buttons[i]));
	            else 
	                panel.add(new JButton(buttons[i]));
	        }

	        add(panel);

	        setSize(350, 300);

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);

	}
	
	/**
	 * BorderLayout divides the space into five regions. North, West, South, East and Centre. 
	 * Each region can have only one component. If we need to put more components into 
	 * a region, we can simply put a panel there with a manager of our choice. The components 
	 * in N, W, S, E regions get their preferred size. The component in the centre takes 
	 * up the whole space left.<br><pre>
	 * 		N		<br>
	 * 		|		<br>
	 * 	W -	C -	E	<br>
	 * 		|		<br>
	 * 		S		<br></pre>
	 */
	public void showBorderLayout(){
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		menubar.add(menu);
		
		setJMenuBar(menubar);
		
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("MT10_16x16_A.png"));
		
		JButton exit = new JButton(icon);
		exit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		toolbar.add(exit);
		add(toolbar, BorderLayout.NORTH);
		
		JToolBar vertical = new JToolBar(JToolBar.VERTICAL);
		vertical.setFloatable(true);
		vertical.setMargin(new Insets(5,5,5,5));
		
		JButton selectb = new JButton(icon);
        selectb.setBorder(new EmptyBorder(3, 0, 3, 0));

        JButton freehandb = new JButton(icon);
        freehandb.setBorder(new EmptyBorder(3, 0, 3, 0));
        JButton shapeedb = new JButton(icon);
        shapeedb.setBorder(new EmptyBorder(3, 0, 3, 0));

        vertical.add(selectb);
        vertical.add(freehandb);
        vertical.add(shapeedb);

        add(vertical, BorderLayout.WEST);

        add(new JTextArea(), BorderLayout.CENTER);

        JLabel statusbar = new JLabel(" Statusbar");
        statusbar.setPreferredSize(new Dimension(-1, 22));
        statusbar.setBorder(LineBorder.createGrayLineBorder());
        add(statusbar, BorderLayout.SOUTH);

        setSize(350, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
       System.out.println("String".replace('t','g') == "Sgring");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LayoutExample layout = new LayoutExample();
		//layout.showFlowLayout();
		
		//layout.showGridLayout();
		
		layout.showBorderLayout();
	}

}
