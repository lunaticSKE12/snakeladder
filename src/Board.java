public class Board {
	
	public static final int SIZE = 30;
	private Square[] squares;
	
	public Board() {
		squares = new Square[SIZE];
		for(int i = 0; i < squares.length; i++) {
			squares[i] = new Square(i+1);
		}
		squares[squares.length-1].setGoal(true);
	}
	
	public void addPiece(Piece piece, int pos) {
		squares[pos-1].addPiece1(piece);
	}
	
	public void movePiece(Piece piece, int steps) {
		int pos = getPiecePosition(piece);
		squares[pos-1].removePiece(piece);
		
		int newPos = pos + steps;
		int stepsRequiredToGoal;
		int stepsBack;
		
		//If the move exceeds the goal then walk back the remaining steps (stepsBack)
		if(newPos > squares.length) {
			stepsRequiredToGoal = ((squares.length) - pos);
			stepsBack = steps - stepsRequiredToGoal;
			newPos = ((squares.length) - stepsBack);
		}
		//Snake no.1
		if(newPos == 17) {
			newPos = 4;
		}
		//Snake no.2
		if(newPos == 21) {
			newPos = 9;
		}
		//Snake no.3
		if(newPos == 27) {
			newPos = 1;
		}
		//Ladder no.1
		if(newPos == 11) {
			newPos = 26;
		}
		//Ladder no.2
		if(newPos == 3) {
			newPos = 22;
		}
		//Ladder no.3
		if(newPos == 20) {
			newPos = 29;
		}
		addPiece(piece, newPos);
	}
	
	public void movePieceBackward(Piece piece, int steps) {
		int pos = getPiecePosition(piece);
		squares[pos-1].removePiece(piece);
		
		int newPos = pos - steps;
		//Ladder no.1
		if(newPos == 11) {
			newPos = 26;
		
		}
		addPiece(piece, newPos);
	}
	
	public void moveTo(Piece piece, int newPos) {
		int pos = getPiecePosition(piece);
		squares[pos-1].removePiece(piece);
		
		addPiece(piece, newPos);
	}
	
	public int getPiecePosition(Piece piece) {
		for(Square s : squares) {
			if(s.hasPiece(piece)) {
				return s.getNumber();
			}
		}
		return -1;
	}
	
	public boolean pieceIsAtGoal(Piece piece) {
		return squares[getPiecePosition(piece)-1].isGoal(); 
	}
	
	public int getGoalSquare() {
		return squares.length;
	}
	
	public boolean pieceIsAtFreeze(Piece piece) {
		if(squares[getPiecePosition(piece)-1].getNumber() == 6 || squares[getPiecePosition(piece)-1].getNumber() == 25) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean pieceIsAtBackward(Piece piece) {
		if(squares[getPiecePosition(piece)-1].getNumber() == 15) {
			return true;
		}
		else {
			return false;
		}
	}
}
