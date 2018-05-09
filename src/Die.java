import java.util.Random;

public class Die {
	public static final int MAX_FACE = 6;
	private int face;
	
	public Die(){
		face = 1;
	}
	

	public int getFace() {
		return face;
	}

	public void roll() {
		// TODO Auto-generated method stub
		face = 1 + new Random().nextInt(MAX_FACE);
	}

}
