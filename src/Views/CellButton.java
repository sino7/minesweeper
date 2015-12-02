package Views;

import javax.swing.JButton;

import Model.Cell;

// Class that extends JButton, mapped to a cell
public class CellButton extends JButton {
	private static final long serialVersionUID = 1L;
	protected Cell cell;
	
	public CellButton(Cell cell, String str)
	{
		super(str);
		this.cell = cell;
	}
}
