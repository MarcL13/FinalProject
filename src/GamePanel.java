
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener 
{
	private GameBoardMain frame;
	private ArrayList<Ball> balls = new ArrayList<>();
	private BallShooter shotta = new BallShooter(getWidth()/2, getHeight());
	Ball newBall = new Ball(shotta.getX(), shotta.getY());
	
	private ArrayList<Brick> bricks;
	
	public GamePanel()
	{
		this.setBounds(0,0,500,500);
		setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		//making a button to go back to main menu
		//JButton back = new JButton("Main Menu");
		//gbc.gridx = 0;
		
		//add(back,gbc);
		//back.addActionListener(new ActionListener() 
		//{

			//public void actionPerformed(ActionEvent e) 
			//{
				//frame.back();
		//	}
			
	//	});
		
		balls = new ArrayList<Ball>();
		bricks = new ArrayList<Brick>();
		
		addBall enemy = new addBall(10,10);
		
		enemy.setVisible(true);
//		for(Ball b : balls)
//		{
//			if(b.getX() == enemy.getX() && b.getY() == enemy.getY())
//			{
//				remove(enemy);
//				balls.add(new Ball(10,10));
//			}
//		}
		//whatever
		Brick brick = new Brick(10,10,1);
		gbc.gridx = 1;
		add(brick,gbc);
		

		
		add(shotta);
		addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					for(Ball b: balls)
					{
						b.setDX(b.getDX()-1);
					}
			    		        
			    }

			     if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			    	 for(Ball b: balls)
						{
							b.setDX(b.getDX()+1);
						}
			    		
			    }
			}
			public void keyReleased(KeyEvent e)
			{
				
				
			}

			@Override
			public void keyTyped(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					for(Ball b: balls)
					{
						add(b);
					}
				}
				 
			}
	
			});

Timer t1 = new Timer(1000/60,this);
t1.start();

		
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void setFrame(GameBoardMain fr)
	{
		frame = fr;
	}
	
	
}
