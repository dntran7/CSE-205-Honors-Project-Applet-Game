import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel
{
	JButton StartButton;
	protected JProgressBar progress;
	private final static int height=600, width=50;
	Player one;
	JPanel jp;
	JPanel pbar;
	JLabel pointlabel;
	GamePanel game;
	boolean started;
	public InfoPanel(Player a)
	{	
		started = false;
		one =a;
		jp= new JPanel();
		pbar = new JPanel();
		jp.setLayout(new GridLayout (2,1));
		StartButton = new JButton ("Start Game");
		String points = Integer.toString(a.getpoints());
		pointlabel = new JLabel ("Points: " + points);
		jp.add(pointlabel);
		jp.add(StartButton);
		progress= new JProgressBar(JProgressBar.VERTICAL,0,200);
		progress.setValue(a.gethealth());
		//pbar.setLayout(new BorderLayout());
		progress.setPreferredSize(new Dimension(40,520));
		pbar.setPreferredSize(new Dimension(40,520));
		pbar.add(progress);
		Border compound = BorderFactory.createLineBorder(Color.black);
		pbar.setBorder((BorderFactory.createTitledBorder(compound, "Health",TitledBorder.CENTER, TitledBorder.CENTER)));
		setLayout(new BorderLayout());
		add (jp,BorderLayout.SOUTH);
		add (pbar,BorderLayout.CENTER);
		updateUI();
	}
	public void updateProgressBar()
	{
		int health =one.gethealth();
		progress.setValue(health);
		updateUI();
	}

}
