import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Brick extends JComponent implements Updatable
{
	private Rectangle2D.Double brick;
	private int hp;
	private int level;
	
	
	public Brick(int x, int y, int level)
	{
		this.level = level;
		//this.setPreferredSize(new Dimension(75,50));
		setBounds(x,y,20,20);
		brick = new Rectangle2D.Double(x,y,74,49);
		if(Math.random()<.2)
			hp = level*2;
		else
			hp = level;
		
	}
	
	public void update()
	{
		setLocation(getX(), getY() + 50);
		level++;
	}
	
	public void updateHp()
	{
		hp--;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Dimension brickSize=this.getSize();
		int brickHeight = brickSize.height;
		int brickWidth = brickSize.width;
		
		g2.draw(brick);
		g2.drawString("" + hp, brickHeight/2, brickWidth/2);
		
	}
}