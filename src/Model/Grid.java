package Model;

// Class of the model corresponding to the whole grid of the minesweeper game
public class Grid {
	protected int height;
	protected int width;
	protected int level;
	protected Cell[][] tab;
	protected int nbMines;
	
	public Grid(int height, int width, int level)
	{
		this.height = height;
		this.width = width;
		this.level = level;
		
		// Generation of the cells and calculus of the nbMines attribute
		int counter = 0;
		Cell[][] tab = new Cell[width][height];
		for(int i=0 ; i<width ; i++)
		{
			for(int j=0 ; j<height ; j++)
			{
				Cell cell = new Cell(i, j, level, this);
				tab[i][j] = cell;
				if(cell.isMine) counter++;
			}
		}
		
		this.tab = tab;
		this.nbMines = counter;
	}
	
	// Getters and setters
	
	public Cell[][] getTab()
	{
		return this.tab;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public int getNbMines()
	{
		return this.nbMines;
	}
}
