/**
 * 
 */
package com.anil.swing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 * @author Rory
 */
public class JFrame1 extends javax.swing.JFrame {

	/** Creates new form JFrame */
	public JFrame1() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jProgressBar1 = new javax.swing.JProgressBar();
		jProgressBar2 = new javax.swing.JProgressBar();
		jProgressBar3 = new javax.swing.JProgressBar();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("File Transfer Application");

		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 0, 13));
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jTextArea1
				.setText("Welcome to  the FIle Transfer  Application !\nSelect  files  for transfer by using  the \"File for transfer\" \n File menu option.\nYou can transfer multiple files simultaneously. Transfer\n progress for each file is displayed below.\n\nThe files are transferred to  \"C:\\ANT\\Destination\" by default.");
		jTextArea1.setWrapStyleWord(true);
		jScrollPane1.setViewportView(jTextArea1);

		jProgressBar1.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null,
				new java.awt.Color(51, 153, 0), null, null));

		jProgressBar2.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null,
				new java.awt.Color(0, 255, 102), null, null));

		jProgressBar3.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null,
				new java.awt.Color(153, 255, 153), null, null));

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane2.setViewportView(jTextArea2);

		jMenu1.setText("File");

		jMenuItem1.setText("Select File for transfer");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText("Exit");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										112, Short.MAX_VALUE).addComponent(
										jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										402,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(110, 110, 110))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(204, 204, 204)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jProgressBar3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jProgressBar2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jProgressBar1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(254, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												155,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												jProgressBar1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(21, 21, 21)
										.addComponent(
												jProgressBar2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												jProgressBar3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(31, Short.MAX_VALUE)));

		pack();
		
	}// </editor-fold>

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// code to handle choosed file here.
			File file = jfc.getSelectedFile();
			jTextArea2.append(file.getName() + " " + "\n");
			
			File directory = new File("C:\\ANT\\Source\\");
			
			if (!directory.exists()){
				//The mkdirs() method will also create any parent directories if they are missing
				directory.mkdirs();
			}
			
			File target = new File(directory, file.getName());
			try{
				transferFile(file, target);
			}catch(IOException ioe){
				JOptionPane.showMessageDialog(this, "The File could NOT be transferred. The exception is: " + ioe.getMessage(), "Error Transferring File", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		// TODO add your handling code here:
	}

	private void transferFile(File source, File target) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(source));
		BufferedWriter writer = new BufferedWriter(new FileWriter(target));
		String s;
		while((s=reader.readLine())!=null){
			writer.write(s + System.getProperty("line.separator"));
		}
		
		reader.close();
		writer.close();

	}
	
	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.exit(0);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JFrame1().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JProgressBar jProgressBar2;
	private javax.swing.JProgressBar jProgressBar3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	// End of variables declaration

}
