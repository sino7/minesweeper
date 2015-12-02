package Views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* This class corresponds to the first panel of the card layout
 * it displays a menu where we choose the difficulty level */
public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public WelcomePanel()
	{
		
		// North panel of the border layout, simply containing a label
		JPanel north = new JPanel();
		north.setBackground(Color.darkGray);
		JLabel label = new JLabel("Choose your difficulty level.");
		label.setForeground(Color.white);
		north.add(label);

		// Center panel of the border layout, containing three buttons corresponding to the difficulty modes
		
	    JPanel center = new JPanel();
	    
	    JButton button1 = new JButton();
	    JButton button2 = new JButton();
	    JButton button3 = new JButton();
	    button1.setPreferredSize(new Dimension(500, 200));
	    button2.setPreferredSize(new Dimension(500, 200));
	    button3.setPreferredSize(new Dimension(500, 200));
	    ImageIcon beginner = new ImageIcon(GamePanel.class.getResource("/beginner.png"));
		button1.setIcon(beginner);
	    ImageIcon intermediate = new ImageIcon(GamePanel.class.getResource("/intermediate.png"));
		button2.setIcon(intermediate);
	    ImageIcon expert = new ImageIcon(GamePanel.class.getResource("/expert.png"));
		button3.setIcon(expert);
	    center.add(button1);
	    center.add(button2);
	    center.add(button3);
	    
		this.setLayout(new BorderLayout());
	    this.add(north, BorderLayout.NORTH);
	    this.add(center, BorderLayout.CENTER);
	    this.setVisible(true);
	    
	    button1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		Window.generateGamePanel(1);
	    		Window.goToPanel(1);
	    	}
	    });
	    
	    button2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		Window.generateGamePanel(2);
	    		Window.goToPanel(1);
	    	}
	    });
	    
	    button3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		Window.generateGamePanel(3);
	    		Window.goToPanel(1);
	    	}
	    });
	}
}
