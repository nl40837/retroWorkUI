//nloparev (nl40837@uga.edu)
//UGAHacks 7 Submissin
//
//A retro-style app that provides a look into what apps would look like if the design 
//decisions of the early to mid 1990s remained in place.
//
//AppPanel creates the main panel for the app.

package retroWorkerApp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class AppPanel extends JFrame 
{
	static JFrame homeFrame;
	static JLabel titleLabel, logoLabel;
	static JButton MainOK;
	
	public static void main(String[] args) throws IOException
	{
		
		JPanel jp = new JPanel();
		
		homeFrame = new JFrame("Home");
		titleLabel = new JLabel("Home");
		MainOK = new JButton("OK");
		BufferedImage logo = ImageIO.read(new File("images\\logo.jpg"));
		logoLabel = new JLabel(new ImageIcon(logo));
		
		jp.add(titleLabel, BorderLayout.NORTH);
		jp.add(MainOK, BorderLayout.EAST);
		jp.add(logoLabel);
		
		jp.setBackground(Color.GRAY);
		
		homeFrame.add(jp);
		homeFrame.setSize(640, 480);
		//homeFrame.show();
		
		//homeFrame.pack();
		homeFrame.setVisible(true);
		homeFrame.setDefaultCloseOperation(homeFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
}
