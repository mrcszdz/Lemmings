package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;

	
	public Position(int x, int y) {
		this.col = x;
		this.row = y;
	}
	
	public int getRow() {
        return this.row;
    }
	
	public Position(Position pos) {
		this.col = pos.col;
		this.row = pos.row;
	}
	
	 public Position() {
		col = 0;
		row = 0;
	}

	public int getCol() {
		 return this.col;
    }

	public Position translate(Direction dir) {
		return new Position(this.col+dir.getX(), this.row+dir.getY());
	}
	
	@Override
    public boolean equals(Object obj) {
		Position other = (Position) obj;
		// Compare the values of col and row
		return this.col == other.getCol() && this.row == other.getRow();
    }
	
	public boolean overflowY( int maxY) {
		return ((this.row < 0) || (this.row >= maxY));
	}
	
	public boolean overflowX(int maxX) {
		return ((this.col < 0) || (this.col > maxX));
	}
}
