import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GameBoardMain extends JFrame implements Updatable,ActionListener
{
	private ArrayList<Ball> balls;
	private guiStartMenu menu;
	private GamePanel game;
	private guiLeaderboard board;
	
	
	public GameBoardMain()
	{
		setBounds(400,200,500,500);
		setLayout(null);
		
		menu = new guiStartMenu();
		menu.setFrame(this);
		menu.setVisible(true);
		menu.setEnabled(true);
		add(menu);
		
		
		game = new GamePanel();
		game.setVisible(true);
		game.setEnabled(true);
		
		board = new guiLeaderboard();
		board.setVisible(true);
		board.setEnabled(true);
		
		
		
		
		
		//general stuff
		this.setResizable(false);
		this.setVisible(true);		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(Ball b : balls)
		{
			b.update();
		}
		for(int i = balls.size() - 1; i >= 0; i--)
		{
			if(balls.get(i).getY() < 0)
			{
				remove(balls.get(i));
			}	
		}
	}
	
	public void start()
	{
		this.remove(menu);
		add(game);
		repaint();
		this.revalidate();
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
