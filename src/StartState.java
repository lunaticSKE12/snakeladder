
public class StartState implements GameState{
	
	Game game;
	
	public StartState(Game game) {

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
		//
		Player currentPlayer = game.players[game.currentPlayerIndex];
		int face = currentPlayer.roll(game.die);
		game.die.setDieFace(face);
		
		System.out.println();
		System.out.println("(System): The Die Is Rolled Face = " + face);

		game.setGameState(game.getMoveState());
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): Roll First");
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): You Must End The Game First");
		
	}
	
	

}
