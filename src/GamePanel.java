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
		balls.add(new Ball(getWidth()/2,getHeight()));
		bricks = new ArrayList<Brick>();
		addBalls = new ArrayList<addBall>();
		int count = balls.size();
		
      for(Ball b : balls) {
    	  b.setDX(1);
    	  b.setDY(1);
    	  
      }
	
      Ball iniball = new Ball (getWidth()/2,getHeight()/2);
     balls.add(iniball);
		add(iniball);
		repaint();
		
		
		JButton Fire = new JButton("Fire");
		Fire.setBounds(50,350,100,25);
		add(Fire);
		Fire.setVisible(true);
		
		JLabel launch = new JLabel("Enter Launch angle.  Between 30 and 150");
		launch.setBounds(50,390,400,25);
		add(launch);
		launch.setVisible(true);
		
		JTextField answer = new JTextField();
		answer.setBounds(50,415,200,25);
		add(answer);
		answer.setVisible(true);
		
	
		
		Fire.addActionListener(new ActionListener()
			{
				public void ActionPerformed(ActionEvent e)
				{
					String ans1 = answer.getText();
					Integer ans = Integer.parseInt(ans1);
					if(ans < 90)
					{
						for(Ball ball : balls)
						{
							ball.setDX(-10);
							ball.setDY((int)(-(Math.sin(ans*((Math.PI)/180)))));
						}
					}
					else if(ans == 90)
					{
						for(Ball ball : balls)
						{
							ball.setDX(0);
							ball.setDY(-1);
						}
					}
					else if(ans > 90)
					{
						for(Ball ball : balls)
						{
							ball.setDX(10);
							ball.setDY((int)(-(Math.sin(ans*((Math.PI)/180)))));
						}
					}
					
//					Ball newBall = new Ball(250,500);
//					balls.add(newBall);
//					add(newBall);
//					newBall.update();


					for(Ball b: balls) {
						b.setLocation(getWidth()/2,getHeight()/2);
						b.update();
						repaint();
					}
					
					answer.setText("");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		
		
//		int randLocation = (int)(Math.random() * 7) + 1;
//		if(randLocation != random)
//		{
//			addBall addB = new addBall(randLocation, 0);
//			addBalls.add(addB);
//			add(addB);
//		}
		Timer t1 = new Timer(1,this);
		t1.start();

		//bricks
		double random = 0;
		for(int i=1;i<8;i++)
		{
			random = Math.random();
			if(random<.4)
			{
				Brick brick = new Brick((i+1)*70,0,level);
				bricks.add(brick);
				add(brick);
				
				
			}
			else if(.4<=random && random<=.6)
			{
				addBall addB = new addBall((i+1)*70,0);
				addBalls.add(addB);
				add(addB);
			}
		}
		
		
		
		
		
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
						repaint();
					}
				}
				 
			}
	
			});
		
		//removing the addBalls
		for(Ball b : balls)
		{
			for(addBall enemy : addBalls)
			{
				if(b.getX() == enemy.getX() && b.getY() == enemy.getY())
				{
					remove(enemy);
					addBalls.remove(enemy);
					balls.add(new Ball(10,10));
					
				}
			}	
		}



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
					
					for(int j=1;j<8;j++)
					{
						double randomBrick = Math.random();
						if(randomBrick<.4)
						{
							Brick brick = new Brick(j,0,level);
							add(brick);
							bricks.add(brick);
						}
						else if(randomBrick>=.4 && randomBrick<=.6)
						{
							addBall addB = new addBall(j,0);
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
		setLayout(null);
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}