
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class guiStartMenu extends JPanel implements ActionListener
{
	private GameBoardMain frame;
	
	public guiStartMenu()
	{

		
	

	this.setBounds(0,0,500,500);
	setLayout(new GridBagLayout());
	JPanel panel = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.gridx = 0;
	gbc.gridy = 0;
	
	JLabel welcome = new JLabel("Welcome to Ballz");
	gbc.gridwidth = 2;
	add(welcome,gbc);
	
	JButton start = new JButton("Start");
	gbc.gridy = 1;
	add(start,gbc);
	
	JButton leaderboard = new JButton("Leaderboard");
	gbc.gridy = 2;
	add(leaderboard,gbc);
	
	
	start.addActionListener(new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{
			frame.start();
		}
		
	});
	
	leaderboard.addActionListener(new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) 
		{

		}
		
	});
	
	setVisible(true);
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