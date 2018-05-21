import java.util.Scanner;

public class EndState implements GameState{

	Game game;
	
	public EndState(Game game) {
		
		this.game = game;
		
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		for(int i = 0; i < game.numberOfPlayers; i++) {
			Player player = game.players[i];
			player.moveTo(game.board, game.startSquare);
		}
		
		game.setCurrentPlayerIndex(0);
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxx Setting up xxxxxxxxxxxxxxxxxxxx\n");
		System.out.println("How Many Player? (2 to 4)");
		int numberOfPlayers = sc2.nextInt();
		
		if(numberOfPlayers == 2) {
			game.setNumberOfPlayers(numberOfPlayers);
			game.setGameState(game.getStartState());
			game.printStartMessage();
			
		} else if(numberOfPlayers == 3){
			game.setNumberOfPlayers(numberOfPlayers);
			game.setGameState(game.getStartState());
			game.printStartMessage();
			
		} else if(numberOfPlayers == 4) {
			game.setNumberOfPlayers(numberOfPlayers);
			game.setGameState(game.getStartState());
			game.printStartMessage();
			
		} else {
			System.out.println("Invalid Number!!!");
			//to do: restart this state
		}
		//sc2.close();
	}

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): The Game Has Ended");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): The Game Has Ended");
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println("(System): You Have Decided To Restart The Game\n");
		for(int i = 0; i < game.numberOfPlayers; i++) {
			Player player = game.players[i];
			player.moveTo(game.board, game.startSquare);
		}
		
		game.setCurrentPlayerIndex(0);
		
		game.setGameState(game.getStartState());
		game.printStartMessage();
	}

}
