import java.awt.*;

import javax.swing.*;

import java.awt.color.*;
import java.awt.image.*;

public class MainProject extends JApplet
{
	GamePanel game;
	InfoPanel info;
	private final static int width = 900, height = 600;
	Player one;
	Food apple;
	Image background;
	String startmessage;
	JTextArea sm;
	FoodPanel foodpan;
	JPanel left =new JPanel();
	public void init()
	{
		
		startmessage ="\t     Welcome to Feed the Pup! \nObjective: lead the puppy to nutritious items and avoid poisonous ones! \n\t         Click OK to continue";
		sm = new JTextArea(startmessage);
		sm.setOpaque(false);
		background = (new ImageIcon(MainProject.class.getResource("background.jpg")).getImage());
		one= new Player();
		apple= new Food();
		info= new InfoPanel(one);
		info.setPreferredSize(new Dimension(120,50));
		game= new GamePanel(one, info);
		foodpan = game.foodpan;
		foodpan.setPreferredSize(new Dimension(50,120));
		left.setLayout(new BorderLayout());
		left.add(game,BorderLayout.CENTER);
		left.add(foodpan, BorderLayout.SOUTH);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(left, BorderLayout.CENTER);
		getContentPane().add(info, BorderLayout.EAST);
		
		JOptionPane.showMessageDialog(null, sm);
		setSize(width, height);	
		//play.method();
	}
	
}
