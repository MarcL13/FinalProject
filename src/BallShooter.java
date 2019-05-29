import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BallShooter  extends JComponent  {

	public BallShooter(int x, int y) {
		 setLocation(x, y);
		Ellipse2D.Double ball =  new Ellipse2D.Double(0,0,10,10);
	
	}

}