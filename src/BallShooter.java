import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BallShooter  extends JComponent  implements Updatable{
int x = 0; int y = 0;
int angleX = 1; int angleY =1;
int speed = 1;
	public BallShooter(int x, int y) {
		 setLocation(x, y);
		Ellipse2D.Double ball =  new Ellipse2D.Double(0,0,10,10);
	
	}
	
	private void move() {
		if(x+ angleX<0)
		{
			angleX=speed;
		}
		else if(x+angleX >getWidth() -10) {
			angleX=-speed;
		}
			else if(y+angleY < 0)
			{
				angleY=speed;
			}
			else if(y +angleY > getHeight() -10) {
				angleY = -speed;
			}
		x=x+angleX;
		y=y+angleY;
		
		//We Need to connect this to the shooter itself somehow
	}
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.fillOval(x,y,10,10);
			
		}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}