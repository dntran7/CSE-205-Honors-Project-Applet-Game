import java.awt.*;

import javax.swing.*;

import java.awt.color.*;
import java.awt.image.*;

public class MainProject extends JApplet
{
	GamePanel game;
	InfoPanel info;
	Graphics an;
	private final static int width = 900, height = 600;
	Player one;
	Food apple;
	//Gameplay play;
	public void init()
	{
		one= new Player();
		apple= new Food();
		info= new InfoPanel(one);
		game= new GamePanel(one, info);
		//play = new Gameplay(game,info,one,apple);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(game, BorderLayout.CENTER);
		getContentPane().add(info, BorderLayout.EAST);
		JOptionPane.showMessageDialog(null, "Welcome to the game! Objective - eat as many oranges and red balls as you can, \nand avoid green or gray balls! Click OK to continue");
		setSize(width, height);	
		//play.method();
	}
	
}
