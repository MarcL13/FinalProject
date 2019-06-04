import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GameBoardMain extends JFrame implements Updatable,ActionListener
{
	private ArrayList<Ball> balls;
	private guiStartMenu menu;
	private GamePanel game;
	private guiLeaderboard board;
	private int level = 1;
	
	
	public GameBoardMain()
	{
		setBounds(400,200,500,500);
		setLayout(null);
		
		balls = new ArrayList<Ball>();
		balls.add(new Ball(250,500));
		
//		menu = new guiStartMenu();
//		menu.setFrame(this);
//		menu.setVisible(true);
//		menu.setEnabled(true);
//		add(menu);
		
		
		game = new GamePanel();
		game.setVisible(true);
		game.setEnabled(true);
		add(game);
		
		board = new guiLeaderboard();
		board.setVisible(true);
		board.setEnabled(true);
		
		
		
		
		
		Timer t1 = new Timer(1000/60, this);
		t1.start();
		
		repaint();
		
		//general stuff
		//this.setResizable(false);
		this.setVisible(true);		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(Ball b : balls)
		{
			b.setVisible(true);
			b.update();
		}
		for(int i = balls.size() - 1; i >= 0; i--)
		{
			if(balls.get(i).getY() < 0)
			{
				remove(balls.get(i));
			}	
		}
		level++;
	}
	
	public void start()
	{
		this.remove(menu);
		add(game);
		game.setVisible(true);

		repaint();
	
	}
	
	//if we want to go back to main menu
	public void back()
	{
		this.remove(game);
		add(menu);
		repaint();
		this.revalidate();
	}
	
	//when game ends
	public void over()
	{
		this.remove(game);
		add(board);
		repaint();
		this.revalidate();
	}
	
	
	public static void main(String[] args)
	{
		new GameBoardMain();
	}

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	

}
