package Views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Grid;

/* The frame containing the game. Uses a card layout composed of two views :
 * the WelcomePanel view which is a menu, and the GamePanel view which is the proper game */

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static String[] listContent = {"CARD_1", "CARD_2"};
    protected static CardLayout cl = new CardLayout();
    protected static Color col = Color.darkGray;
    protected static JPanel content = new JPanel();

	public Window(){
	    this.setTitle("Minesweeper");
	    this.setSize(600,670);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setResizable(false);

	    JPanel card1 = new WelcomePanel();

	    content.setLayout(cl);
	    
	    content.add(card1, listContent[0]);
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	}
	
	public static void generateGamePanel(int level)
	{
	    JPanel card2 = new GamePanel(new Grid(20,20,level));
	    content.add(card2, listContent[1]);
	}
	
	public static void goToPanel(int i)
	{
		cl.show(content, listContent[i]);
	}
}
