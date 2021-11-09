package solitaire;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import solitaire.Card.Suit;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	Solitaire game;
   public GUI(Solitaire game){
	   this.game= game;
        //Create and set up the window.
       setTitle("Solitaire");
       setSize(1025,610); //Size that approximates the size of the background image
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new BorderLayout());
       
       // this supplies the background
       try {
    	   File img = new File("D:\\Solitaire\\solitaire\\images\\background.jpg");
    	   setContentPane(new ImagePanel(ImageIO.read(img)));
       }catch(IOException e) {
    	   e.printStackTrace();
       }
       
       //The game area
       JPanel area = new JPanel();
       area.setOpaque(false);
       area.setLayout(new BoxLayout(area, BoxLayout.LINE_AXIS));
       area.setSize(new Dimension(1010,570));
       area.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED));
       
       //Stock border
       JPanel Stock = new JPanel();
       Stock.setOpaque(false);
       Stock.setLayout(new FlowLayout(FlowLayout.CENTER));
       Stock.setMaximumSize(new Dimension(150, 563));
       Stock.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
       
       //Tableau border
       JPanel Tabl = new JPanel();
       Tabl.setOpaque(false);
       Tabl.setMaximumSize(new Dimension(600, 563));
       Tabl.setLayout(new GridLayout(1, 7));
       Tabl.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
       
       //Pile1 border
       JPanel pile1 = new JPanel();
       pile1.setOpaque(false);
       pile1.setMaximumSize(new Dimension(50, 50));
       pile1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
       //Pile2 border
       JPanel pile2 = new JPanel();
       pile2.setOpaque(false);
       pile2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
     //pile3 border
       JPanel pile3 = new JPanel();
       pile3.setOpaque(false);
       pile3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
     //pile2 border
       JPanel pile4 = new JPanel();
       pile4.setOpaque(false);
       pile4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
     //pile5 border
       JPanel pile5 = new JPanel();
       pile5.setOpaque(false);
       pile5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
     //pile6 border
       JPanel pile6 = new JPanel();
       pile6.setOpaque(false);
       pile6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
     //pile7 border
       JPanel pile7 = new JPanel();
       pile7.setOpaque(false);
       pile7.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
       
       //Foundation border
       JPanel Found = new JPanel();
       Found.setOpaque(false);
       Found.setLayout(new FlowLayout(FlowLayout.CENTER));
       Found.setMaximumSize(new Dimension(250, 563));
       Found.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.MAGENTA));
       
       /*******
        * This is just a test to make sure images are being read correctly on your machine. Please replace
        * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
        * game once it's fully created.
        */ 
       
       //TESTING BEGINS HERE
       /////////////////////////////////////
       Card heartsTwo = new Card(2, Suit.Hearts);
       Card spadesFive = new Card(5, Suit.Spades);
       Card heartsSix = new Card(6, Suit.Hearts);
       Card clubsFive = new Card(5, Suit.Clubs);
       Card diamondsFour= new Card(4, Suit.Diamonds);
       Card diamondsThree= new Card(3, Suit.Diamonds);
       Card spadesThree= new Card(3, Suit.Spades);
       Card diamondsFive = new Card(5, Suit.Diamonds);
       Card heartsAce = new Card(1, Suit.Hearts);
       Card spadesFour = new Card(4, Suit.Spades);
       Card spadesSeven = new Card(7, Suit.Spades);
       Card heartsFive = new Card(5, Suit.Hearts);
       Card heartsFour = new Card(4, Suit.Hearts);
       Card clubsThree= new Card(3, Suit.Clubs);
       Card clubsFour= new Card(4, Suit.Clubs);
       
       game.columns.get(0).push(heartsTwo);
       game.columns.get(1).push(diamondsFive);
       game.columns.get(2).push(clubsFour);
       game.columns.get(2).push(heartsSix);
       game.columns.get(2).push(clubsFive);
       game.columns.get(2).push(diamondsFour);
       game.columns.get(2).push(diamondsThree);
       game.columns.get(3).push(spadesThree);
       game.columns.get(4).push(spadesSeven);
       game.columns.get(5).push(heartsFive);
       game.columns.get(6).push(heartsFour);
       
       game.tal.add(spadesFive);

       game.found.get(0).add(heartsAce);
       game.found.get(2).add(clubsThree);
       game.found.get(3).add(spadesFour);
       
       System.out.println("Should be true:" + game.legalMove(heartsTwo, heartsAce));
       
       //pile1.add(drawPile(game.columns.get(0)));
       //pile2.add(drawPile(game.columns.get(1)));
       //pile3.add(drawPile(game.columns.get(2)));
       //pile4.add(drawPile(game.columns.get(3)));
       //pile5.add(drawPile(game.columns.get(4)));
       //pile6.add(drawPile(game.columns.get(5)));
       //pile7.add(drawPile(game.columns.get(6)));
       
       /////////////////////////////////////
       //TESTING ENDS HERE
       
       area.add(Stock);
       this.add(area);
       area.add(Tabl);
       area.add(Found);
       
       Tabl.add(pile1);
       Tabl.add(pile2);
       Tabl.add(pile3);
       Tabl.add(pile4);
       Tabl.add(pile5);
       Tabl.add(pile6);
       Tabl.add(pile7);

       this.setVisible(true);
    }
   
   	public JLayeredPane drawPile(Stack<Card> stackIn) {
	    Object cards[];
	    cards = stackIn.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You’ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position
	    JLayeredPane ret = new JLayeredPane();
	    ret.setPreferredSize(new Dimension(60, 563)); //JLayeredPanes want you to specify everything, including size
	    
	    int offset = 0;
	    
	    //Loop through each card, setting the bounds with an offset value that updates after every loop
	    for (int i = 0; i < cards.length; i++)
	    {
	    	Card in = (Card)cards[i];
	    	in.setBounds(0, offset, 60, 80);
	    	if(i < cards.length-1)
	    		in.isReversed = true;
	    	ret.add(in);
	    	ret.setLayer(in, offset);
	    	offset += 10;
	    }
	    return ret;
   	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
