package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import Model.Grid;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/* This class corresponds to the second panel of the card layout, 
the view where we really play the game */

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected static Grid grid;
	protected static CellButton[][] buttonTab;
	protected static int buttonClicked;
	protected static JLabel minesLeft = new JLabel();
	
	
	public GamePanel(Grid grid)
	{
		GamePanel.grid=grid;
		buttonClicked = 0;
		minesLeft.setForeground(Color.white);
		minesLeft.setText(""+grid.getNbMines());

		/* This panel uses a border layout, with two buttons and a label in the north, 
		and the minesweeper array in the center */
		this.setLayout(new BorderLayout());
		
		// Creation of the center panel, containing 20 x 20 buttons of the CellButton class
		JPanel center = new JPanel();
		buttonTab = new CellButton[grid.getHeight()][grid.getWidth()];
		for(int i=0;i<grid.getHeight();i++)
		{
			for(int j=0;j<grid.getWidth();j++)
			{
				CellButton button = new CellButton(grid.getTab()[i][j], "");
				buttonTab[i][j] = button;
				button.setPreferredSize(new Dimension(600/grid.getWidth()-5,600/grid.getHeight()-5));
				button.addMouseListener(new java.awt.event.MouseAdapter() {
				    public void mouseClicked(MouseEvent event) {
			    		if (SwingUtilities.isRightMouseButton(event))
			    		{
			    			GamePanel.onRightClick(button);
			    		}
			    		else if(SwingUtilities.isLeftMouseButton(event))
			    		{
			    			GamePanel.onLeftClick(button);
			    		}
				    }
				});
				center.add(button);
			}
		}
		
		// Creation of the north panel, the label and the two buttons
		JPanel north = new JPanel();
		north.setBackground(Color.darkGray);
		JButton bback = new JButton("Go back to menu");
		JButton brestart = new JButton("Restart this game");

		brestart.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		Window.generateGamePanel(GamePanel.grid.getLevel());
	    		Window.goToPanel(1);
	    	}
	    });
		
		bback.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event){
	    		Window.goToPanel(0);
	    	}
	    });
		
		JLabel legend = new JLabel("Remaining mines : ");
		legend.setForeground(Color.white);
		
		north.add(bback);
		north.add(legend);
		north.add(minesLeft);
		north.add(brestart);
		
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
	}
	
	// Action triggered by the left click on one of the cell-buttons
	public static void onLeftClick(CellButton button)
	{
		if(!button.cell.getIsClicked())
		{
			int i = button.cell.getX();
			int j = button.cell.getY();
			button.cell.setIsClicked(true);
			if(grid.getTab()[i][j].getIsMine())
			{
				ImageIcon cellMine = new ImageIcon(GamePanel.class.getResource("/cell-mine.png"));
				button.setIcon(cellMine);
				buttonClicked = -1;
				GamePanel.revealGame();
				new GameEndModal(false);
			}
			else 
			{
				buttonClicked ++;
				if (grid.getTab()[i][j].getNbMines()>0)	
				{
					button.setIcon(null);
					button.setText(""+grid.getTab()[i][j].getNbMines());
				}
				else
				{
					ImageIcon cellEmpty = new ImageIcon(GamePanel.class.getResource("/cell-empty.png"));
					button.setIcon(cellEmpty);
					for(int k=-1; k<2; k++)
					{
						for(int l=-1; l<2; l++)
						{
							if(k+i>=0 && l+j>=0 && k+i < grid.getWidth() && l+j < grid.getHeight() && !(k==0 && l==0))
							{
								GamePanel.onLeftClick(buttonTab[i+k][j+l]);
							}
						}
					}
				}
				
				if(buttonClicked == grid.getHeight()*grid.getWidth()-grid.getNbMines())
				{
					buttonClicked = 0;
					GamePanel.revealGame();
					new GameEndModal(true);
				}
			}	
		}
	}
	
	// Action triggered by the right click on one of the cell-buttons
	public static void onRightClick(CellButton button)
	{
		if(!button.cell.getIsClicked())
		{
			if(!button.cell.getIsRightClicked())
			{
				button.cell.setIsRightClicked(true);
				minesLeft.setText(""+(Integer.parseInt(minesLeft.getText())-1));
				ImageIcon cellFlag = new ImageIcon(GamePanel.class.getResource("/cell-flag.png"));
				button.setIcon(cellFlag);
			}	
			else
			{
				button.cell.setIsRightClicked(false);
				minesLeft.setText(""+(Integer.parseInt(minesLeft.getText())+1));
				button.setIcon(null);
			}
		}
	}
	
	// Method to reveal the content of a cell at the end of the game, called in the revealGame method
	public static void revealCell(CellButton button)
	{
		int i = button.cell.getX();
		int j = button.cell.getY();
		
		if(grid.getTab()[i][j].getIsMine())
		{
			ImageIcon cellMine = new ImageIcon(GamePanel.class.getResource("/cell-mine.png"));
			button.setIcon(cellMine);
		}
		else if (grid.getTab()[i][j].getNbMines()>0)	
		{
			button.setIcon(null);
			button.setText(""+grid.getTab()[i][j].getNbMines());
		}
		else
		{
			ImageIcon cellEmpty = new ImageIcon(GamePanel.class.getResource("/cell-empty.png"));
			button.setIcon(cellEmpty);
		}
	}
	
	// Method to reveal the contents of all the cells at the end of the game
	public static void revealGame()
	{
		for(int i=0;i<grid.getHeight();i++)
		{
			for(int j=0;j<grid.getWidth();j++)
			{
				grid.getTab()[i][j].setIsClicked(true);
				GamePanel.revealCell(buttonTab[i][j]);
			}
		}
	}
}
