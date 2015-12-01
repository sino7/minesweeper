package Views;

import javax.swing.JButton;

public class CellButton extends JButton {
	private static final long serialVersionUID = 1L;
	protected int i;
	protected int j;
	protected boolean isClicked = false;
	protected boolean isRightClicked = false;
	
	public CellButton(int i, int j, String str)
	{
		super(str);
		this.i=i;
		this.j=j;
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
}
