import java.util.Scanner;

public class SetupState implements GameState{

	Game game;
	
	public SetupState(Game game) {
		
		this.game = game;
		
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxx Setting up xxxxxxxxxxxxxxxxxxxx\n");
		System.out.println("How Many Player? (2 to 4)");
		int numberOfPlayers = sc.nextInt();
		
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
		//sc.close();
	}

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): Please Setup First");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): Please Setup First");
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("(System): You Have To Play The Game First");
	}

}
