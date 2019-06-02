import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
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
	private int level = 1;
	private boolean gameRun = true;
	
	private ArrayList<Brick> bricks;
	
	private ArrayList<addBall> addBalls;
	
	public void setFrame(GameBoardMain fr)
	{
		frame = fr;
	}
	
	public GamePanel()
	{
		this.setBounds(0,0,500,500);
		
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
		addBalls = new ArrayList<addBall>();
		int count = balls.size();
		

		
	
//		for(Ball b : balls)
//		{
//			if(b.getX() == enemy.getX() && b.getY() == enemy.getY())
//			{
//				remove(enemy);
//				balls.add(new Ball(10,10));
				//count--;
//			}
//		}
		//whatever
		
		

		
		for(int i=1;i<8;i++)
		{
			double random = Math.random();
			if(random<.5)
			{
				Brick brick = new Brick(i,0,level);
				add(brick);
				bricks.add(brick);
			}
			else if(random>.8)
			{
				addBall addB = new addBall(i,0);
				add(addB);
			}
		}
		
		//addBall
		//for(int i = 1; i < 8; i++)
		//{
		//	double random = Math.random
		//}
		

		

		
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

	//Updates: when each ball reaches bottom it is removed and bricks update with randomization	
	while(gameRun == true) {
		for(Ball b:balls) {
			if(b.getY() == 0) {
				remove(b);
				count--;
			}
			if(count == 0) {
				for(Brick br:bricks) {
					br.update();
					
					for(int i=1;i<8;i++)
					{
						double random = Math.random();
						if(random<.5)
						{
							Brick brick = new Brick(i,0,level);
							add(brick);
							bricks.add(brick);
						}
						else if(random>.8)
						{
							addBall addB = new addBall(i,0);
							add(addB);
						}
					}
					
				}
			}
		}
		//Game End conditions
	for(Brick br: bricks)
		if(br.getX() == 0)
		{
			gameRun = false;
			if(!gameRun)
			{

			}	
			
		}
	}
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}