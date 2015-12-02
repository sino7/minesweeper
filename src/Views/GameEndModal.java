package Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Class extending JFrame that corresponds to the modal that 
appears at the end of the game, whether you win or loose */

public class GameEndModal extends JFrame{
	private static final long serialVersionUID = 1L;
	protected boolean hasWon;
	
	public GameEndModal(boolean hasWon)
	{
		this.hasWon = hasWon;
		
		String title = hasWon ? "Congrats ! You have won !" : "Too bad ! You stepped on a mine...";
		
		this.setTitle(title);
	    this.setSize(400,200);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	    JPanel content = new JPanel();
	    JButton bback = new JButton("Go back to menu");
		JButton brestart = new JButton("Restart this game");

		brestart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		JFrame frame = (JFrame) SwingUtilities.getRoot(bback);
	    		frame.dispose();
	    		Window.generateGamePanel(GamePanel.grid.getLevel());
	    		Window.goToPanel(1);
	    	}
	    });
		
		bback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		JFrame frame = (JFrame) SwingUtilities.getRoot(bback);
	    		frame.dispose();
	    		Window.goToPanel(0);
	    	}
	    });
		
		brestart.setPreferredSize(new Dimension(300, 80));
		bback.setPreferredSize(new Dimension(300, 80));
		
		content.add(bback);
		content.add(brestart);
		
		this.getContentPane().add(content);
		this.setVisible(true);
	}
}
