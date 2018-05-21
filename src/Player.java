
public class Player {
	
	private String name;
	private Piece piece;
	private String status;
	private int skipCount;
	
	public Player(String name) {
		this.name = name;
		piece = new Piece(name);
		this.status = "Normal";
		this.skipCount = 0;
	}
	
	public int roll(Die die) {
		die.roll();
		return die.getFace();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void movePiece(Board board,int steps) {
		board.movePiece(piece, steps);
	}
	
	public void moveTo(Board board, int pos) {
		board.moveTo(piece, pos);
	}
	
	public void movePieceBackward(Board board, int steps) {
		board.movePieceBackward(piece, steps);
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
	
	public void setSkipCount(int count) {
		this.skipCount = count;
	}
	
	public int getSkipCount() {
		return this.skipCount;
	}
}
