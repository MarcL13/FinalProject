import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;



	public class addBall extends JComponent implements Updatable{
		
		private Ellipse2D.Double addBall;
	
		
		private int dx = 0, dy = 0;
		
		public void update() {}
		
		public addBall(int x,  int y) {
			
			setBounds(x,y,20,20);
			
			addBall = new Ellipse2D.Double(0, 0 , 19, 19);
	}
		
	public void paintComponent (Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(addBall);
		g2.fill(addBall);
	}
	}

//boolean dead = false;
	//addBall enemy = new addBall();
	// j = 0;

//	for(ball m: balls){
//	m.update();
//	if(m.getX() >= border){ remove(m);}
//	if((m.getX() >= enemy.getX() && m.getY() >= enemy.getY() && m.getX() <= enemy.getX() + 20 && m.getY() <= enemy.getY() + 20))
//	{
//	    remove(enemy);
//	    dead = true;
//	}
//	if(dead)
//	{
//	Arraylist for Ball declaration.add(j,boi);
//	j++;