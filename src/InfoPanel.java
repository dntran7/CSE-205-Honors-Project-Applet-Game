import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InfoPanel extends JPanel
{
	JButton StartButton;
	protected JProgressBar progress;
	private final static int height=600, width=50;

	private static final Color LIGHT_BLUE = new Color(160,225,225);
	Player one;
	JPanel jp;
	JPanel pbar;
	JLabel pointlabel;
	GamePanel game;
	Image background = (new ImageIcon(MainProject.class.getResource("background.jpg")).getImage());
	boolean started;
	public InfoPanel(Player a)
	{	
		setBackground(Color.blue);
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
		progress.setForeground(LIGHT_BLUE);
		progress.setPreferredSize(new Dimension(40,520));
		pbar.setPreferredSize(new Dimension(40,520));
		pbar.add(progress);
		//setBackground(Color.BLUE);
		
		pbar.setOpaque(false);
		//Border compound = BorderFactory.createLineBorder(Color.black);
		Border compound = BorderFactory.createEmptyBorder();
		pbar.setBorder((BorderFactory.createTitledBorder(compound, "Health",TitledBorder.CENTER, TitledBorder.CENTER,progress.getFont(),Color.white)));
		setLayout(new BorderLayout());
		add (jp,BorderLayout.SOUTH);
		add (pbar,BorderLayout.CENTER);
		updateUI();
	}
	public void paintComponent(Graphics graph)
	{
		super.paintComponent(graph);
		graph.drawImage(background,0,0,this);
	}
	public void updateProgressBar()	
	{
		int health =one.gethealth();
		progress.setValue(health);
		updateUI();
	}

}
