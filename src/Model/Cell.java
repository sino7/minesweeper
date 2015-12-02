package Model;

// Class of the model that correspond to an individual cell, containing a mine or not

public class Cell {
	protected Grid grid;
	protected boolean isMine ;
	protected int nbMines ;
	protected int x;
	protected int y;
	protected boolean isClicked = false;
	protected boolean isRightClicked = false;

	public Cell(int x, int y, int level, Grid grid)
	{
		this.grid = grid;
		this.x = x;
		this.y = y;
		double lvl = level;
		/* Random function to make this cell a mine or not, 
		the probablity of this cell being a mine increases with the lvl variable */
		this.isMine = (Math.random()<lvl/10);
	}
	
	// Method that counts the number of adjacent cells that are mines
	public int getNbMines()
	{
		int counter = 0;
		for(int i=-1; i<2; i++)
		{
			for(int j=-1; j<2; j++)
			{
				if(this.x+i>=0 && this.y+j>=0 && this.x+i < this.grid.width && this.y+j < this.grid.height && !(i==0 && j==0))
				{
					Cell cell = this.grid.tab[this.x+i][this.y+j];
					counter += cell.isMine ? 1 : 0;
				}
			}
		}
		return counter;
	}
	
	// Getters and setters
	
	public boolean getIsMine()
	{
		return this.isMine;
	}
	
	public boolean getIsClicked()
	{
		return this.isClicked;
	}
	
	public void setIsClicked(boolean isClicked)
	{
		this.isClicked = isClicked;
	}
	
	public boolean getIsRightClicked()
	{
		return this.isRightClicked;
	}
	
	public void setIsRightClicked(boolean isRightClicked)
	{
		this.isRightClicked = isRightClicked;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}
