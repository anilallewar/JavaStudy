package com.anil.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.SeparatorUI;

@SuppressWarnings("serial")
public class EventsExample extends JFrame implements ActionListener, ComponentListener {

	private JList list;
	private DefaultListModel model;
	private JButton ok, cancel, doNothing;
	private JSpinner spinner;
    private JLabel labelx;
    private JLabel labely;
    private JPanel panel;

	public EventsExample() {
		setTitle("Events Example");
	}

	protected void showActionEventDetails() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		model = new DefaultListModel();
		list = new JList(model);

		ok = new JButton("OK");
		ok.setPreferredSize(new Dimension(100, 20));

		ok.addActionListener(this);

		cancel = new JButton("Cancel");
		cancel.setPreferredSize(new Dimension(100, 20));

		cancel.addActionListener(this);
		
		// Anonymous inner class - second listener
		// Show a color chooser on clicking the cancel button
		cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Color color = JColorChooser.showDialog(panel, "Choose Color", Color.white);
                list.setBackground(color);
            }
        });

		doNothing = new JButton("Do Nothing");
		doNothing.setPreferredSize(new Dimension(100, 20));

		doNothing.addActionListener(this);

		// Anonymous inner class - second listener
		doNothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Integer val = (Integer) spinner.getValue();
				spinner.setValue(++val);
			}
		});

		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);

		//The SpinnerNumberModel arguments are initial value, min, max values and the step. 
		SpinnerModel yearModel = new SpinnerNumberModel(currentYear,
				currentYear - 100, currentYear + 100, 1);

		spinner = new JSpinner(yearModel);
		//# is to remove the thousands separator
		spinner.setEditor(new JSpinner.NumberEditor(spinner, "#"));
		spinner.setPreferredSize(new Dimension(100, 30));
		
		labelx = new JLabel("x: ");
        labelx.setFont(new Font("Serif", Font.BOLD, 14));
        labelx.setBounds(20, 20, 60, 25);

        labely = new JLabel("y: ");
        labely.setFont(new Font("Serif", Font.BOLD, 14));
        labely.setBounds(20, 45, 60, 25);

        panel.add(ok);
		panel.add(cancel);
		panel.add(doNothing);
		panel.add(new JSeparator(SwingConstants.HORIZONTAL)).setPreferredSize(new Dimension(400,2));
		panel.add(spinner);
		panel.add(list);
		panel.add(new JSeparator(SwingConstants.HORIZONTAL)).setPreferredSize(new Dimension(400,2));
		panel.add(labelx);
        panel.add(labely);

		add(panel);
		
		//Add the component listener
		addComponentListener(this);
		
		setPreferredSize(new Dimension(400, 300));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if (!model.isEmpty()) {
			model.clear();
		}

		if (event.getID() == ActionEvent.ACTION_PERFORMED) {
			model.addElement("Event Id: ACTION_PERFORMED: "
					+ (event.getSource() == ok));
		}

		Locale locale = Locale.getDefault();
		Date date = new Date();

		String time = DateFormat.getTimeInstance(DateFormat.LONG, locale)
				.format(date);
		model.addElement("Date: " + time);

		JButton source = (JButton) event.getSource();
		model.addElement("Source: " + source.getText());

		int modifier = event.getModifiers();

		StringBuilder buffer = new StringBuilder("Modifiers: ");

		System.out.println("The modifier is: " + modifier
				+ " and the value of ActionEvent.ALT_MASK: "
				+ ActionEvent.ALT_MASK
				+ " and the value of modifier & ActionEvent.ALT_MASK is: "
				+ (modifier & ActionEvent.ALT_MASK));
		if ((modifier & ActionEvent.ALT_MASK) > 0) {
			buffer.append("Alt ");
		} else if ((modifier & ActionEvent.CTRL_MASK) > 0) {
			buffer.append("Ctrl ");
		} else if ((modifier & ActionEvent.SHIFT_MASK) > 0) {
			buffer.append("Shift ");
		} else if ((modifier & ActionEvent.META_MASK) > 0) {
			buffer.append("Meta ");
		}

		model.addElement(buffer);
		
		model.addElement("Spinner value: " + spinner.getValue());
		
		//If clicked on cancel button, a modal dialog box will  be displayed
		if (source == ok){
			JOptionPane.showMessageDialog(this, "Testing message", "Title", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventsExample example = new EventsExample();
		example.showActionEventDetails();
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		int x = e.getComponent().getX();
        int y = e.getComponent().getY();
        labelx.setText("x: " + x);
        labely.setText("y: " + y);
	}

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
