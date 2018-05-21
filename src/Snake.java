import java.util.ArrayList;
import java.util.List;


public class Snake{

	private List<Piece> pieces;
	private int head;
	private int tail;
	
	public Snake(int head, int tail) {
		this.head = head;
		this.tail = tail;
		pieces = new ArrayList<Piece>();
	}
	
	public void addPiece1(Piece piece) {
		pieces.add(piece);
	}
	
	public void removePiece(Piece piece) {
		pieces.remove(piece);
	}
	
	public boolean hasPiece(Piece piece) {
		return pieces.contains(piece);
	}
	
	public int getHead() {
		return head;
	}
	
	public int getTail() {
		return tail;
	}

}
