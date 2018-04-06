import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartPanel extends JPanel
{
	Image background;
	ImageIcon doggo;
	ImageIcon title;
	JLabel doggolabel;
	JButton start;
	JButton instructions;
	JPanel middle;
	JPanel buttons;
	public StartPanel()
	{
		middle = new JPanel();
		buttons = new JPanel();
		start = new JButton("PLAY");
		instructions = new JButton("INSTRUCTIONS");
		background = (new ImageIcon(StartPanel.class.getResource("background.jpg"))).getImage();
		doggo = (new ImageIcon(StartPanel.class.getResource("giphy.gif")));
		title = (new ImageIcon(StartPanel.class.getResource("title.png")));
		doggolabel = new JLabel(doggo);
		middle.setLayout(new GridLayout(3,1));
		buttons.setLayout(new GridLayout(2,1));
		JPanel temp = new JPanel();
		buttons.setPreferredSize(new Dimension(200,100));
		buttons.add(start);
		//buttons.add(new JPanel());
		buttons.add(instructions);
		start.setPreferredSize(new Dimension(100,50));
		instructions.setPreferredSize(new Dimension(100,50));
		temp.add(buttons);
		temp.setPreferredSize(new Dimension(200,100));
		temp.setOpaque(false);
		middle.add(new JLabel(title));
		middle.add(doggolabel);
		middle.add(temp);
		middle.setOpaque(false);
		setLayout(new BorderLayout());
		add(middle,BorderLayout.CENTER);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background,0,0,this);
	}
}
