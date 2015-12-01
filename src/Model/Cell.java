package Model;

public class Cell {
	protected Grid grid;
	protected boolean isMine ;
	protected int nbMines ;
	protected int x;
	protected int y;

	public Cell(int x, int y, int level, Grid grid)
	{
		this.grid = grid;
		this.x = x;
		this.y = y;
		double lvl = level;
		this.isMine = (Math.random()<lvl/10);
	}
	
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
	
	public boolean getIsMine()
	{
		return this.isMine;
	}
}
