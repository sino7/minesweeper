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

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public WelcomePanel()
	{
		JPanel north = new JPanel();
		north.setBackground(Color.darkGray);

		JLabel label = new JLabel("Choose your difficulty level.");
		label.setForeground(Color.white);
		north.add(label);

	    JPanel center = new JPanel();
	    
	    JButton button1 = new JButton();
	    JButton button2 = new JButton();
	    JButton button3 = new JButton();
	    button1.setPreferredSize(new Dimension(500, 200));
	    ImageIcon beginner = new ImageIcon(GamePanel.class.getResource("/beginner.png"));
		button1.setIcon(beginner);
	    button2.setPreferredSize(new Dimension(500, 200));
	    ImageIcon intermediate = new ImageIcon(GamePanel.class.getResource("/intermediate.png"));
		button2.setIcon(intermediate);
	    button3.setPreferredSize(new Dimension(500, 200));
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
