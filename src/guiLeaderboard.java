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

public class guiLeaderboard extends JPanel implements ActionListener{

	private GameBoardMain frame;
	
	public guiLeaderboard() {
		
		this.setBounds(0,0,500,500);
		setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel over = new JLabel("Game Over");
		gbc.gridwidth = 2;
		add(over,gbc);
		
		setVisible(true);
	}
	
	public void setFrame(GameBoardMain fr)
	{
		frame = fr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
