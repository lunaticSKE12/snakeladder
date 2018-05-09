
public class Game {
	
	private Player[] players;
	private Die die;
	private Board board;
	private int currentPlayerIndex;
	
	public Game() {
		players = new Player[2];
		players[0] = new Player("p1");
		players[1] = new Player("p2");
		
		die = new Die();
		board = new Board();
	}
	
	public void start() {
		board.addPiece(players[0].getPiece(), 0);
		board.addPiece(players[1].getPiece(), 0);
		currentPlayerIndex=0;
		while(true) {
			System.out.println("---------------------------------");
			Player currentPlayer = players[currentPlayerIndex];
			System.out.println("current player is "+ currentPlayer.getName());
			int face = currentPlayer.roll(die);
			System.out.println("The die is rooled face = "+face);
			currentPlayer.movePiece(board, face);
			System.out.println("");
			
			
			
			if(board.pieceIsAtGoal(currentPlayer.getPiece())) {
				break;
			}
			currentPlayerIndex = 1;
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
