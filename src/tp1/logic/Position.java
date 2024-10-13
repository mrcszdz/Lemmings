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
	
	public Position(Position pos) {
		this.col = pos.col;
		this.row = pos.row;
	}

	public Position translate(Direction dir) {
		return new Position(this.col+dir.getX(), this.row+dir.getY());
	}
	
	@Override
    public boolean equals(Object obj) {
		Position other = (Position) obj;
		// Compare the values of col and row
		return this.col == other.col && this.row == other.row;
    }
	
}
