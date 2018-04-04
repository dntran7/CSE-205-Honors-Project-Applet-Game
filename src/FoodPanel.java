import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FoodPanel extends JPanel
{
	int applenum;
	int cheesenum;
	int icecreamnum;
	int choconum;
	int eggnum;
	int cherrynum;
	ImageIcon apple = (new ImageIcon(FoodPanel.class.getResource("appleicon.gif")));
	ImageIcon cheese = (new ImageIcon(FoodPanel.class.getResource("cheeseicon.gif")));
	ImageIcon icecream = (new ImageIcon(FoodPanel.class.getResource("icecreamicon.gif")));
	ImageIcon choco = (new ImageIcon(FoodPanel.class.getResource("chocoicon.gif")));
	ImageIcon egg = (new ImageIcon(FoodPanel.class.getResource("eggicon.gif")));
	ImageIcon cherry = (new ImageIcon(FoodPanel.class.getResource("cherryicon.gif")));
	Image background = (new ImageIcon(FoodPanel.class.getResource("background.jpg"))).getImage();
	JLabel iapple = new JLabel (apple);
	JLabel icheese = new JLabel (cheese);
	JLabel iicecream = new JLabel (icecream);
	JLabel ichoco = new JLabel (choco);
	JLabel iegg = new JLabel (egg);
	JLabel icherry = new JLabel (cherry);
	JLabel applelabel;
	JLabel cheeselabel;
	JLabel icecreamlabel;
	JLabel chocolabel;
	JLabel egglabel;
	JLabel cherrylabel;
	public FoodPanel()
	{
		applenum = 0;
		cheesenum =0;
		icecreamnum =0;
		choconum =0;
		eggnum =0;
		cherrynum =0;
		applelabel = new JLabel(Integer.toString(applenum));
		cheeselabel = new JLabel(Integer.toString(cheesenum));
		icecreamlabel = new JLabel(Integer.toString(icecreamnum));
		chocolabel = new JLabel(Integer.toString(choconum));
		cherrylabel = new JLabel(Integer.toString(cherrynum));
		egglabel =new JLabel(Integer.toString(eggnum));
		setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.white));
		setLayout(new GridLayout(2,6));
		add(iapple);
		add(applelabel);
		add(icheese);
		add(cheeselabel);
		add(ichoco);
		add(chocolabel);
		add(iicecream);
		add(icecreamlabel);
		add(icherry);
		add(cherrylabel);
		add(iegg);
		add(egglabel);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, -50, -500, this);
	}
}
