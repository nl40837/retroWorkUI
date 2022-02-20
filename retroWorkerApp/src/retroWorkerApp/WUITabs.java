//nloparev (nl40837@uga.edu)
//UGAHacks 7 Submission
//
//A retro-style app that provides a look into what apps would look like if the design 
//decisions of the early to mid 1990s remained in place.
//
//AppPanel creates the main panel for the app.
//
//References were almost entirely comprised of oracle.com's tutorial and API pages. 
//
//I made this by myself from scratch, using eclipse, over the course of ~15-20 hours.

package retroWorkerApp;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class WUITabs extends JFrame implements ActionListener
{
	   
	   static JTextArea textArea, textArea2, textArea3;
	   static JScrollPane scroll, scroll2, scroll3;
	   static JFrame frame;
	   static JButton openButton, openButton2, openButton3;
	   static JButton saveButton, saveButton2, saveButton3;
	   static JFileChooser fc;
	   static private final String newline = "\n";
	   
	   public static void main(String[] args) throws IOException
	   {
		   makeWorkUI();
	      
	   }

	   private static void makeWorkUI() throws IOException 
	   {    
	      
		  frame = new JFrame("RetroWorkUI");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      createGenUI(frame);
	      frame.setSize(640, 520);      
	      frame.setLocationRelativeTo(null);  
	      frame.setVisible(true);
	      
	      JFrame splash = new JFrame("Welcome To RetroWorkUI");
	      splash.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	      createSplash(splash);
	      splash.setSize(450, 430);
	      splash.setLocationRelativeTo(frame);
	      splash.setVisible(true);
	   }

	   private static void createGenUI(final JFrame frame) throws IOException
	   {  
		   
		  Icon tabIcon = new ImageIcon("images/tabLogo.jpg");
		  Icon tabIconEmp = new ImageIcon("images/tabLogoEmployee.jpg");
		  Icon tabIconSche = new ImageIcon("images/tabLogoSchedule.jpg");
		  Icon tabIconInv = new ImageIcon("images/tabLogoInv.jpg");
		  BufferedImage splashLogo = ImageIO.read(new File("images/fgthfghx.jpg"));
		  BufferedImage workLogo = ImageIO.read(new File("images/workBar.jpg"));
		  JLabel splashImgLabel = new JLabel(new ImageIcon(splashLogo));
		  JLabel mainLogoImgLabel = new JLabel(new ImageIcon(workLogo));
	      
		  //tabbed pane setup 
		  
		  JTabbedPane tabbedPane = new JTabbedPane();
		  
		  //JTabbedPane tabbedPane2 = new JTabbedPane();
		 
	      //panel1 setup (employees)
	      JPanel panel1 = new JPanel(false);
	      JLabel label = new JLabel("Tab 1");
	      JLabel label1a = new JLabel("Test 1a");
	      openButton = new JButton("Open");
	      saveButton = new JButton("Save");
	      textArea=new JTextArea("Enter employee data here.");
	      scroll = new JScrollPane(textArea);
	      textArea.setBounds(10,30, 200,200);  
	      
	      fc = new JFileChooser();
	      
	      /*
	      JMenuBar menuBar = new JMenuBar();
	      JMenu mb1 = new JMenu("File");
	      JMenuItem mI1 = new JMenuItem("New");
	      JMenuItem mI2 = new JMenuItem("Open");
	      JMenuItem mI3 = new JMenuItem("Save");
	      //mS1.addActinListener(panel1);
	      mb1.add(mI1);
	      menuBar.add(mI1);
	      frame.setJMenuBar(menuBar);
	      */
		  
	      label.setHorizontalAlignment(JLabel.CENTER);
	      panel1.setLayout(new GridLayout(1, 1));
	      //panel1.add(textArea);
	      panel1.add(scroll);
	      //panel1.add(label);
	      //panel1.add(label1a);
	      //panel1.add(imgLabel);
	      //panel1.add(tabIcon);
	      //saveButton.setSize(10, 25);
	      //openButton.setSize(12, 25);
	      panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
	      //panel1.setLayout(new FlowLayout());
	      //panel1.setLayout(new BorderLayout());
	      
	      WUITabs ALinstance = new WUITabs();
	      saveButton.addActionListener(ALinstance);
	      openButton.addActionListener(ALinstance);
	      panel1.add(openButton);
	      panel1.add(saveButton);
	     
	      tabbedPane.addTab("Employees", tabIconEmp, panel1,"Enter your employee information here, "
	      		+ "such as position, wages and hours. (ALT + 1)");
	      tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	      
	      //panel2 setup (schedule)
	      
	      JPanel panel2 = new JPanel(false);
	      JLabel label2 = new JLabel("Tab 2?");
	      label2.setHorizontalAlignment(JLabel.CENTER);
	      panel2.setLayout(new GridLayout(1, 1));
	      openButton2 = new JButton("Open");
	      saveButton2 = new JButton("Save");
	      textArea2=new JTextArea("Enter schedules here.");
	      scroll2 = new JScrollPane(textArea2);
	      textArea2.setBounds(10,30, 200,200);
	      //panel2.add(label2);
	      tabbedPane.addTab("Schedule", tabIconSche, panel2,"Enter your scheduling information. (ALT + 2)");
	      tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);  
	      
	      panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
	      
	      saveButton2.addActionListener(ALinstance);
	      openButton2.addActionListener(ALinstance);
	      panel2.add(scroll2);
	      panel2.add(openButton2);
	      panel2.add(saveButton2);
	      
	      //panel3 setup (Inventory)
	      
	      JPanel panel3 = new JPanel(false);
	      JLabel label3 = new JLabel("Tab 3");
	      label3.setHorizontalAlignment(JLabel.CENTER);
	      panel3.setLayout(new GridLayout(1, 1));
	      openButton3 = new JButton("Open");
	      saveButton3 = new JButton("Save");
	      textArea3=new JTextArea("Enter inventory here.");
	      scroll3 = new JScrollPane(textArea3);
	      textArea3.setBounds(10,30, 200,200);
	      //panel3.add(label3);
	      tabbedPane.addTab("Inventory", tabIconInv, panel3,"Enter your inventory information. (ALT + 3)");
	      tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	      
	      panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
	      
	      saveButton3.addActionListener(ALinstance);
	      openButton3.addActionListener(ALinstance);
	      panel3.add(scroll3);
	      panel3.add(openButton3);
	      panel3.add(saveButton3);
	      
	      //panel4 setup
	      
	      /*
	      JPanel panel4 = new JPanel(false);
	      JLabel label4 = new JLabel("Tab 4");
	      label4.setHorizontalAlignment(JLabel.CENTER);
	      panel4.setLayout(new GridLayout(1, 1));
	      panel4.add(label4);
	      tabbedPane.addTab("Tab 4", tabIcon, panel4,"Tab 4's tooltip");
	      tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
	      */
	      
	      frame.getContentPane().add(tabbedPane, BorderLayout.CENTER); 
	      //frame.getContentPane().add(tabbedPane2, BorderLayout.CENTER);
	      //frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	      frame.getContentPane().add(mainLogoImgLabel, BorderLayout.NORTH);
	   }
	   
	   private static void createSplash(final JFrame splash) throws IOException
	   {  
		   BufferedImage myPicture = ImageIO.read(new File("images/fgthfghx.jpg"));
		   
		   JPanel homePanel = new JPanel(false);
		   homePanel.setBackground(Color.gray);
		   homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
		   //homeA.setLayout(new GridLayout(1, 1));
		   
		   JLabel imgLabel = new JLabel(new ImageIcon(myPicture));
		   
		   
		   JLabel homeLabel = new JLabel("<html> ----------------------------------Welcome to Retro Work UI!--------------------------------- <br> "
		   		+ "This software is "
		   		+ " totally not trademarked and not copyright protected. Please do not make illegal "
		   		+ "copies of this software. Violations will be pretty much ignored, but I would prefer "
		   		+ "if you at least gave me some credit.<html>");
		   //JLabel homeLabel2 = new JLabel("testHome2");
		   //JLabel homeLabel3 = new JLabel("testHome3");
		   //JLabel homeLabel4 = new JLabel("testHome4");
		   //homeLabel.setHorizontalAlignment(JLabel.CENTER);
		   
		   homeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		   imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		   
		   
		   splash.add(homePanel);
		   
		   homePanel.add(imgLabel);
		   homePanel.add(homeLabel);
		   //homePanel.add(homeLabel2);
		   //homePanel.add(homeLabel3);
		   //homePanel.add(homeLabel4);
		   
		   
		   
	   }

	
	public void actionPerformed(ActionEvent e) 
	{
		String text = textArea.getText();
		
		//panel 1 action listeners
		if (e.getSource() == openButton) 
		{
			
		      int returnVal = fc.showOpenDialog(WUITabs.this);
		      
		      
		      if (returnVal == JFileChooser.APPROVE_OPTION) 
		      {
		    	    File f = fc.getSelectedFile();
		    	    String filepath=f.getPath();
		    	    try {
		    	     BufferedReader br=new BufferedReader(new FileReader(filepath));
		    	     String s1 = "";
		    	     String s2 = "";
		    	     while((s1=br.readLine())!=null){
		    	      s2 += s1 + "\n";
		    	     }
		    	     textArea.setText(s2);
		    	     br.close();
		    	    }
		    	    catch (Exception ex) {
		    	     ex.printStackTrace();
		    	     JOptionPane.showMessageDialog(this, "File cannot be opened because it is corrupt or"
		    	     		+ " does not exist.",  
	    		                "Failure: cannot open file.", JOptionPane.INFORMATION_MESSAGE);
		    	    }
		    	   
		      } 
		      
		    
		  } 
			else if (e.getSource() == saveButton) 
			{
		      int returnVal = fc.showSaveDialog(WUITabs.this);
		      File file = fc.getSelectedFile();
		      BufferedWriter writer = null;
		      if (returnVal == JFileChooser.APPROVE_OPTION) 
		      {
		    	  try {  
		    		    writer = new BufferedWriter( new FileWriter( file.getAbsolutePath()+".txt")); 
		    		    textArea.write(writer); 
		    		    writer.close( );  
		    		    JOptionPane.showMessageDialog(this, "File has been saved!",  
		    		                "Success", JOptionPane.INFORMATION_MESSAGE);  
		    		    }  
		    		    catch (IOException ioe) {
		    		    	ioe.printStackTrace();
		    		    	JOptionPane.showMessageDialog(this, "File was not saved.",  
		    		                "Failure: cannot save file.", JOptionPane.INFORMATION_MESSAGE);  
		    		    }  
		      } 
		      
		    }
		
		
		//panel 2 action listeners
				if (e.getSource() == openButton2) 
				{
					
				      int returnVal = fc.showOpenDialog(WUITabs.this);
				      
				      
				      if (returnVal == JFileChooser.APPROVE_OPTION) 
				      {
				    	    File f2 = fc.getSelectedFile();
				    	    String filepath=f2.getPath();
				    	    try {
				    	     BufferedReader br2=new BufferedReader(new FileReader(filepath));
				    	     String s1 = "";
				    	     String s2 = "";
				    	     while((s1=br2.readLine())!=null){
				    	      s2 += s1 + "\n";
				    	     }
				    	     textArea2.setText(s2);
				    	     br2.close();
				    	    }
				    	    catch (Exception ex2) {
				    	     ex2.printStackTrace();
				    	     JOptionPane.showMessageDialog(this, "File cannot be opened because it is corrupt or"
					    	     		+ " does not exist.",  
				    		                "Failure: cannot open file.", JOptionPane.INFORMATION_MESSAGE);
				    	    }
				    	   
				      } 
				      
				    
				  } 
					else if (e.getSource() == saveButton2) 
					{
				      int returnVal = fc.showSaveDialog(WUITabs.this);
				      File file2 = fc.getSelectedFile();
				      BufferedWriter writer2 = null;
				      if (returnVal == JFileChooser.APPROVE_OPTION) 
				      {
				    	  try {  
				    		    writer2 = new BufferedWriter( new FileWriter( file2.getAbsolutePath()+".txt")); 
				    		    textArea2.write(writer2); 
				    		    writer2.close( );  
				    		    JOptionPane.showMessageDialog(this, "File has been saved!",  
				    		                "Success", JOptionPane.INFORMATION_MESSAGE);  
				    		    }  
				    		    catch (IOException ioe2) {
				    		    	ioe2.printStackTrace();
				    		    	JOptionPane.showMessageDialog(this, "File was not saved.",  
				    		                "Failure: cannot save file.", JOptionPane.INFORMATION_MESSAGE);  
				    		    }  
				      } 
				      
				    }
				
				//panel 3 action listeners
				if (e.getSource() == openButton3) 
				{
					
				      int returnVal = fc.showOpenDialog(WUITabs.this);
				      
				      
				      if (returnVal == JFileChooser.APPROVE_OPTION) 
				      {
				    	    File f3 = fc.getSelectedFile();
				    	    String filepath=f3.getPath();
				    	    try {
				    	     BufferedReader br3=new BufferedReader(new FileReader(filepath));
				    	     String s1 = "";
				    	     String s2 = "";
				    	     while((s1=br3.readLine())!=null){
				    	      s2 += s1 + "\n";
				    	     }
				    	     textArea3.setText(s2);
				    	     br3.close();
				    	    }
				    	    catch (Exception ex3) {
				    	     ex3.printStackTrace();
				    	     JOptionPane.showMessageDialog(this, "File cannot be opened because it is corrupt or"
					    	     		+ " does not exist.",  
				    		                "Failure: cannot open file.", JOptionPane.INFORMATION_MESSAGE);
				    	    }
				    	   
				      } 
				      
				    
				  } 
					else if (e.getSource() == saveButton3) 
					{
				      int returnVal = fc.showSaveDialog(WUITabs.this);
				      File file3 = fc.getSelectedFile();
				      BufferedWriter writer3 = null;
				      if (returnVal == JFileChooser.APPROVE_OPTION) 
				      {
				    	  try {  
				    		    writer3 = new BufferedWriter( new FileWriter( file3.getAbsolutePath()+".txt")); 
				    		    textArea3.write(writer3); 
				    		    writer3.close( );  
				    		    JOptionPane.showMessageDialog(this, "File has been saved!",  
				    		                "Success", JOptionPane.INFORMATION_MESSAGE);  
				    		    }  
				    		    catch (IOException ioe3) {
				    		    	ioe3.printStackTrace();
				    		    	JOptionPane.showMessageDialog(this, "File was not saved.",  
				    		                "Failure: cannot save file.", JOptionPane.INFORMATION_MESSAGE);  
				    		    }  
				      } 
				      
				    }
		
		
		
		
	}  
		
		
	   
	   
}