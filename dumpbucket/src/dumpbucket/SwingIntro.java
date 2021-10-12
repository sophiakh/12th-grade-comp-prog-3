package dumpbucket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingIntro implements ActionListener
{ 
	//Instance variables; a surprise tool that will help us later
	private JFrame f=new JFrame();
	private JFrame f2 = new JFrame();
	
	private JLabel a = new JLabel("Hello World", SwingConstants.CENTER);
	private JLabel b = new JLabel ("Matt is the best java coder EVER");
	
	private JButton but1 = new JButton("Press Me!");
	private JButton but2 = new JButton("Press Me!!");
	private JButton but3 = new JButton("Press Me!!!");
	
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("Menu");
	private JMenuItem m1 = new JMenuItem("Switch Programs!");
	
	private JMenuBar bar2 = new JMenuBar();
	private JMenu menu2 = new JMenu("Menu");
	private JMenuItem m2 = new JMenuItem("Switch Programs!");
	
	//The main method: A single call to one constructor!!!!
	public static void main(String[] args) 
	{  
		SwingIntro aaaaaaaaaa = new SwingIntro();
	} 
	
	//The awesome class constructor
	public SwingIntro()
	{	
		f.setVisible(true);//making frame1 visible 
		f.setSize(1000, 1000);//setting comfortable size for frame1
		f.setLayout(new GridLayout(2, 2));//setting gridlayout to be 2x2 so that it works with the 3 buttons we use later (+ the label)
		
		f2.setVisible(false);//making frame2 invisible so we don't see the second page just yet
		f2.setSize(1000, 1000);//setting comfortable size for frame2
		f2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 400));//sets FlowLayout to have a "CENTER" alignment, which just means it's centered horizontally, not vertically. So we set the horizontal adjustment to 0 (as the alignemnt already has us covered on that front) and we change the vertical adjustment by 400 so the text on frame2 looks about centered
		
		menu.add(m1);//adds m1 (a menu item) to the first menu object
		bar.add(menu);//adds first menu object to first bar object
		menu2.add(m2);//adds m2 (a menu item) to the second menu object (for frame2)
		bar2.add(menu2);//adds second menu object to second bar object (for frame2)
		
		//Adds action listeners to the buttons 
		but1.addActionListener(this);//"this" refers to the currently used instance of SwingIntro class, which implements ActionListener
		but2.addActionListener(this);
		but3.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		
		//Adds buttons and labels to frame1 and frame2
		f.add(a);
		f.add(but1);
		f.add(but2);
		f.add(but3);
		f2.add(b);
		
		//adds and then sets menu bars on frame1 and frame2
		f.add(bar);
		f.setJMenuBar(bar);
		f2.add(bar2);
		f2.setJMenuBar(bar2);
	}
	
	//Once actionlistener detects input, it calls this method to do stuff
	public void actionPerformed(ActionEvent e)
	{
		//each if statement is for each button that needs to do stuff
		if (e.getSource() == but1)
			a.setText("You did it!");
		if (e.getSource() == but2)
			a.setText("You done it!");
		if (e.getSource() == but3)
			a.setText("You rapscallion, you went ahead and gosh darn done it!");
		if (e.getSource() == m1)
		{
			f.setVisible(false);
			f2.setVisible(true);
		}
		if (e.getSource() == m2)
		{
			f.setVisible(true);
			f2.setVisible(false);
		}
	}
}