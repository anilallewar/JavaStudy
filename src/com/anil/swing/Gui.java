/**
 * 
 */
package com.anil.swing;

/**
 * @author anila
 *
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
//import URL_reader.progressBar.ButtonListener;

public class Gui extends Applet implements ActionListener
{
        private TextField URLText = null ;
        private Button URLButton = null;
        final static int interval = 1000;
        int i;
        JLabel label;
        JProgressBar pb;
        Button button;

      //Create a timer.
        Timer timer = new Timer(interval, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if (i == 20){
            			Toolkit.getDefaultToolkit().beep();
            			timer.stop();
            			button.setEnabled(true);
            			pb.setValue(0);
            			String str = "<html>" + "<font color=\"#FF0000\">" + "<b>" + 
            			"Downloading completed." + "</b>" + "</font>" + "</html>";
            			label.setText(str);
            	}
            	i = i + 1;
                pb.setValue(i);
            }
        });
        
        public void init()
        {
                add(new Label("URL"));
                URLText = new TextField(30);
                add(URLText);
                URLButton = new Button("Go");
                add(URLButton);

                URLButton.addActionListener(this);
        }
        //**************************
        public void progressBar() {
        	JFrame frame = new JFrame("Progress Bar For URL Reading ");
            //button = new JButton("Start");
            //button.addActionListener(new ButtonListener());

            pb = new JProgressBar(0, 20);
            pb.setValue(0);
            pb.setStringPainted(true);

            label = new JLabel("Reading in progress");
       
            JPanel panel = new JPanel();
            //panel.add(button);
            panel.add(pb);

            JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            panel1.add(panel, BorderLayout.NORTH);
            panel1.add(label, BorderLayout.CENTER);
            panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            frame.setContentPane(panel1);
            frame.setSize(new Dimension(200, 50));
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String str = "<html>" + "<font color=\"#008000\">" + "<b>" + 
            "Downloading is in process......." + "</b>" + "</font>" + "</html>";
            label.setText(str);
            timer.start();
        }

        class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                button.setEnabled(false);
                i = 0;
                String str = "<html>" + "<font color=\"#008000\">" + "<b>" + 
                "Downloading is in process......." + "</b>" + "</font>" + "</html>";
                label.setText(str);
                timer.start();
            }
        }
        //**************************

        public void actionPerformed(ActionEvent e)
        {
                String actionCommand = e.getActionCommand();
                if (e.getSource() instanceof Button)
                        if (actionCommand.equals("Go"))
                        {
                        	System.out.println("Go");
                        	String text = URLText.getText();      
                        
                try
                {
                	progressBar();
                	conn(text);
                  	AppletContext context = getAppletContext();
                    URL url = new URL(URLText.getText());
                    context.showDocument(url);
                }
                catch(Exception ex)
                {
                        showStatus("Error "+ex);
                }

                        }
        }
        public static void conn(String url) throws Exception {
            URL yahoo = new URL(url);
            URLConnection yc = yahoo.openConnection();
            int length = yc.getContentLength();
            System.out.println("The content length of "+url +" is "+length);
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) 
                System.out.println(inputLine);
            in.close();
        }
    
        public static void main(String[] args){
            Gui gui = new Gui();
          }
}
