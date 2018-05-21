import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Button extends JFrame {

	private JButton setup = new JButton("Setup");
	private JButton roll = new JButton("Roll");
	private JButton move = new JButton("Move");
	private JButton restart = new JButton("Restart");

	Game game;
	
	//
	public Button(Game game) {

		super( "Snake & Ladder (Ultimate Edition)" );
		setLayout( new FlowLayout() );

		add(setup);
		add(roll);
		add(move);
		add(restart);
		
		this.game = game;
		
		initialize();

	}

	public void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 275);
		this.setVisible(true);
	}

	public void setActionListener() {
		setup.addActionListener(new Setup());
		roll.addActionListener(new Roll());
		move.addActionListener(new Move());
		restart.addActionListener(new Restart());
	}

	private class Setup implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			game.setup();
		}

	}

	private class Roll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			game.roll();
		}

	}
	private class Move implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			game.move();
		}

	} 
	private class Restart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			game.restart();
		}

	}  
	

}