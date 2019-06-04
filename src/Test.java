import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;


import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class Test extends JFrame implements ActionListener
{
	private int i = 0;
	ArrayList<Ball> balls = new ArrayList<>();
	private BallShooter shot;
	public Test()
	{

	this.setBounds(0,0,500,500);
	this.setLayout(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	shot = new BallShooter(getWidth()/2,getHeight());
	this.add(shot);
	Ball ball = new Ball(shot.getX(), shot.getY());
	balls.add(ball);
	Ball ball1 = new Ball(shot.getX(), shot.getY());
	balls.add(ball1);
	addKeyListener(new KeyListener()
		{
		public void keyPressed(KeyEvent e)
		{
			
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				 
			for(int i = 0; i < balls.size(); i++)
			{
			
			add(balls.get(i));
			
			}
		            
			}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				for(int i = 0; i< balls.size(); i++) {
					(balls.get(i)).setDX(balls.get(i).getDx()-1);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				for(int i = 0; i< balls.size(); i++) {
					(balls.get(i)).setDX(balls.get(i).getDx()+1);
				}
			}

		}
			
		
		public void keyReleased(KeyEvent e)
		{
			
		}

		@Override
		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}});
	
	
		
	setVisible(true);
	
	Timer t1 = new Timer(1000/60,this);
	t1.start();
	
	shot.setFocusable(false);
	setFocusable(true);
	}
public void actionPerformed(ActionEvent e)
{
	

	for(Ball b : balls)
	{
		
		b.update();
	}
	for(int i = 0; i < balls.size(); i++)
	{
	
	if((balls.get(i)).getX() >= getWidth() || (balls.get(i)).getX() <= 0)
	{
		(balls.get(i)).setDX(-((balls.get(i)).getDx()));
		
	}
	if(((balls.get(i)).getY() >= getHeight() || (balls.get(i)).getY() <= 0))
	{
		(balls.get(i)).setDY(-((balls.get(i)).getDy()));
	}
	
	}
	
	
	repaint();
}
	
	
	public static void main(String[] args)
	{
		new Test();
	}
}
