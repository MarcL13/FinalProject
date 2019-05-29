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
		setBounds(x,y,9,9);
		brick = new Rectangle2D.Double(0,0,10,10);
		if(Math.random()<.2)
			hp = level*2;
		else
			hp = level;
		JLabel lbl1 = new JLabel("" + hp);
		lbl1.setBounds(0,0, 20,10);
		add(lbl1);
	}
	
	public void update()
	{
		setLocation(getX(), getY() + 10);
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
		g2.fill(brick);
		
	}
}