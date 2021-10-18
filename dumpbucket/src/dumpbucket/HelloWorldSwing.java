package dumpbucket;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*; 

public class HelloWorldSwing {

    private static void createAndShowGUI() throws Exception{
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BufferedImage myPicture = ImageIO.read(new URL("https://cdn.mos.cms.futurecdn.net/jfkAU4tM8XMUAPZDm4h5Nh-1200-80.jpeg"));
        BufferedImage myPicture2 = ImageIO.read(new URL("https://i.insider.com/5dfab6ce855cc20c514e79f6?width=1000&format=jpeg&auto=webp"));
        JLabel label = new JLabel(new ImageIcon(myPicture));
        JLabel label2 = new JLabel(new ImageIcon(myPicture2));
        frame.getContentPane().add(label);
        frame.getContentPane().add(label2);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					createAndShowGUI();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}