
public class Game {

	GameState setupState;
	GameState startState;
	GameState moveState;
	GameState endState;
	
	GameState gameState;
	
	int numberOfPlayers = 0;
	public Player[] players;
	public Die die;
	public Board board;
	public int currentPlayerIndex = 0;
	public int startSquare = 1;
	
	public Game() {
		
		setupState = new SetupState(this);
		startState = new StartState(this);
		moveState = new MoveState(this);
		endState = new EndState(this);
		
		gameState = setupState;
		
		die = new Die();
		board = new Board();
		
		System.out.println("xxxxxxxxxxxxxxxxxxxx Snake & Ladder (Ultimate Edition) xxxxxxxxxxxxxxxxxxxx \n");
		System.out.println("Rules:\n");
		System.out.println("- All players starts at square number 1\n");
		System.out.println("- Goal at square number " + board.getGoalSquare() + "\n");
		System.out.println("- Ladder Square : If a player lands on this square, he/she moves up to the ladder's higher-numbered square\n");
		System.out.println("- Snake Square : If a player lands on this square, he/she moves down to the snake's lower-numbered square \n");
		System.out.println("- Freeze Square : If a player lands on this square, he/she skips one turn\n");
		System.out.println("- Backward Square : If a player lands on this square, he/she rolls a die and move backward according to the die's face\n");
		System.out.println("- 3 Ladder Square : (3 to 22), (11 to 26), (20 to 29)\n");
		System.out.println("- 3 Snake Square : (17 to 4), (21 to 9), (27 to 1)\n");
		System.out.println("- 2 Freeze Square : 6, 25\n");
		System.out.println("- 1 Backward Square : 15");
		
	}
	
	void setGameState(GameState newGameState) {
		gameState = newGameState;
	}
	
	//Setup players stuff
	public void setNumberOfPlayers(int newNumberOfPlayers) {
		numberOfPlayers = newNumberOfPlayers;
		players = new Player[numberOfPlayers];
		
		for(int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player("P"+ (i+1));
			System.out.println("- " + players[i].getName() + " has joined the game\n");
		}
		
		setupPiece(numberOfPlayers);
		
	}
	
	//Place pieces at the start square of the board
	public void setupPiece(int numberOfPlayers) {
		for(int i = 0; i < numberOfPlayers; i++) {
			board.addPiece(players[i].getPiece(), startSquare);
		}
	}
	
	//
	public void setCurrentPlayerIndex(int nextPlayerIndex) {
		currentPlayerIndex = nextPlayerIndex;
	}
	
	public void printStartMessage() {
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxx START xxxxxxxxxxxxxxxxxxxx");
		
		Player currentPlayer = players[currentPlayerIndex];
		System.out.println();
		System.out.println("(System): " + currentPlayer.getName() + "'s Turn");
	}
	
	public void setup() {
		gameState.setup();
	}
	
	public void roll() {
		gameState.roll();
	}
	
	public void move() {
		gameState.move();
	}
	
	public void restart() {
		gameState.restart();
	}
	
	public GameState getSetupState() {
		return setupState;
	}
	
	public GameState getStartState() {
		return startState;
	}
	
	public GameState getMoveState() {
		return moveState;
	}
	
	public GameState getEndState() {
		return endState;
	}
	
}
