
public class MoveState implements GameState{

	Game game;
	
	public MoveState(Game game) {
		
		this.game = game;
		
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): Game Is Already Started");
	}

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): Already Rolled");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Player currentPlayer = game.players[game.currentPlayerIndex];
		
		System.out.println();
		System.out.print("(System): " + currentPlayer.getPiece().getName() +" Moved from "+ game.board.getPiecePosition(currentPlayer.getPiece()));
		
		if(currentPlayer.getStatus() == "Backward") {
			currentPlayer.movePieceBackward(game.board, game.die.getFace());
			currentPlayer.setStatus("Normal");
		}
		else {
			currentPlayer.movePiece(game.board, game.die.getFace());
		}
		
		System.out.println(" To "+ game.board.getPiecePosition(currentPlayer.getPiece()));
		
		game.setCurrentPlayerIndex(game.currentPlayerIndex + 1);
		if(game.currentPlayerIndex > game.numberOfPlayers - 1) {
			game.currentPlayerIndex = 0;
		}
		//if win, show winner, otherwise show who'll move next
		if(game.board.pieceIsAtGoal(currentPlayer.getPiece())) {
			System.out.println();
			System.out.println("(System): Congratulations To " + currentPlayer.getName() + ", You Are The Winner!\n");
			System.out.println("(System): You Can Now Restart Or Setup A New Game\n");
			
			game.setGameState(game.getEndState());
			return;
		}
		//if freeze, set status to skip
		else if(game.board.pieceIsAtFreeze(currentPlayer.getPiece())) {
			currentPlayer.setStatus("Skip");
			System.out.println();
			System.out.println("(System): " + currentPlayer.getName() + " Skips One Turn");
			
			Player nextPlayer = game.players[game.currentPlayerIndex];
			
			if(nextPlayer.getStatus() == "Skip" && nextPlayer.getSkipCount() == 0) {
				game.setCurrentPlayerIndex(game.currentPlayerIndex + 1);
				if(game.currentPlayerIndex > game.numberOfPlayers - 1) {
					game.currentPlayerIndex = 0;
				}
				nextPlayer.setSkipCount(1);
			}
			
			else if(nextPlayer.getStatus() == "Skip" && nextPlayer.getSkipCount() == 1) {
				nextPlayer.setStatus("Normal");
				nextPlayer.setSkipCount(0);
			}
			
			Player nextNextPlayer = game.players[game.currentPlayerIndex];
			
			System.out.println();
			System.out.println("(System): " + nextNextPlayer.getName() + "'s Turn");
		}
		//if backward
		else if(game.board.pieceIsAtBackward(currentPlayer.getPiece())) {
			currentPlayer.setStatus("Backward");
			System.out.println();
			System.out.println("(System): " + currentPlayer.getName() + " Roll Again To Move Backward");
			
			game.setCurrentPlayerIndex(game.currentPlayerIndex - 1);
			if(game.currentPlayerIndex < 0) {
				game.currentPlayerIndex = game.numberOfPlayers - 1;
			}
			
			Player nextNextPlayer = game.players[game.currentPlayerIndex];
			
			System.out.println();
			System.out.println("(System): " + nextNextPlayer.getName() + "'s Turn");
		}
		
		else {
			Player nextPlayer = game.players[game.currentPlayerIndex];
			
			if(nextPlayer.getStatus() == "Skip" && nextPlayer.getSkipCount() == 0) {
				game.setCurrentPlayerIndex(game.currentPlayerIndex + 1);
				if(game.currentPlayerIndex > game.numberOfPlayers - 1) {
					game.currentPlayerIndex = 0;
				}
				nextPlayer.setSkipCount(1);
			}
			
			else if(nextPlayer.getStatus() == "Skip" && nextPlayer.getSkipCount() == 1) {
				nextPlayer.setStatus("Normal");
				nextPlayer.setSkipCount(0);
			}
			
			Player nextNextPlayer = game.players[game.currentPlayerIndex];
			
			if(nextNextPlayer.getStatus() == "Skip" && nextNextPlayer.getSkipCount() == 0) {
				game.setCurrentPlayerIndex(game.currentPlayerIndex + 1);
				if(game.currentPlayerIndex > game.numberOfPlayers - 1) {
					game.currentPlayerIndex = 0;
				}
				nextNextPlayer.setSkipCount(1);
			}
			
			System.out.println();
			System.out.println("(System): " + nextNextPlayer.getName() + "'s Turn");
		}
		
		game.setGameState(game.getStartState());
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): You Must End The Game First");
	}
	

}
