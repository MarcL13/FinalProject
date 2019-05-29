
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel
{
	private ArrayList<Ball> balls;
	
	public GamePanel()
	{
		this.setBounds(0,0,500,500);
		setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		balls = new ArrayList<Ball>();
		
		addBall enemy = new addBall();
		
		enemy.setVisible(true);
		for(Ball b : balls)
		{
			if(b.getX() == enemy.getX() && b.getY() == enemy.getY())
			{
				remove(enemy);
				balls.add(new Ball(10,10));
			}
		}
		
		Brick brick = new Brick(10,10,1);
		gbc.gridx = 1;
		add(brick,gbc);
		
		
		
		
		
		
		
		
		
	}
	
	
}
