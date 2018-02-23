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
	Started st = new Started();
	public void init()
	{
		one= new Player();
		apple= new Food();
		game= new GamePanel(one,st);
		info= new InfoPanel(one,game,st);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(game, BorderLayout.CENTER);
		getContentPane().add(info, BorderLayout.EAST);
		setSize(width, height);	
	}
	
}
