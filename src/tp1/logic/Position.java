package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private int col;
	private int row;

	
	public Position(int x, int y) {
		this.col = x;
		this.row = y;
	}
	
	public Position(Position pos) {
		this.col = pos.getCol();
		this.row = pos.getRow();
	}
	public int getCol() {
		return this.col;
	}
	
	public int getRow() {
		
		return this.row;
	}
	
	public void setCol(int n) {
		this.col = n;
	}
	
	public void setRow(int n) {
		this.row = n;
	}
	
	
}
