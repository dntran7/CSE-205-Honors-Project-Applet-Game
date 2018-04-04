import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class GamePanel extends JPanel
{
	FoodPanel foodpan;
	KeyboardListener kl;
	JProgressBar progressBar =new JProgressBar();
	boolean forward=false;
	boolean backward = false;
	boolean downward = false;
	boolean upward = false;
	private static final Color LIGHT_BLUE = new Color(200,235,245);
	Player one;
	Image doggo;
	Image iapple;
	Image icheese;
	Image ichoco;
	Image iicecream;
	Image icherry;
	Image iegg;
	Food apple;
	Food orange;
	Food shoe;
	Food shoe2;
	Food cherry;
	Food egg;
	static boolean gamestarted;
	Image pan;
	Image bg;
	Graphics buffer;
	JButton newa;
	InfoPanel info;
	Timer time =new Timer(50,new TimeListener());
	JLabel points;
	JLabel papple;
	
	int applenum=0;
	int cheesenum=0;
	int choconum=0;
	int icecreamnum=0;
	int eggnum =0;
	int cherrynum =0;
	public GamePanel(Player p,InfoPanel i)
	{
		foodpan = new FoodPanel();
		//doggo =(new ImageIcon(dir+"\\giphy.gif").getImage());
		doggo = (new ImageIcon(GamePanel.class.getResource("giphy.gif")).getImage());
		bg = (new ImageIcon(GamePanel.class.getResource("bg.gif")).getImage());
		iapple = (new ImageIcon(GamePanel.class.getResource("apple.gif")).getImage());
		icheese = (new ImageIcon(GamePanel.class.getResource("cheese.gif")).getImage());
		ichoco = (new ImageIcon(GamePanel.class.getResource("choco.gif")).getImage());
		iicecream = (new ImageIcon(GamePanel.class.getResource("icecream.gif")).getImage());
		icherry = (new ImageIcon(GamePanel.class.getResource("cherry.gif")).getImage());
		iegg = (new ImageIcon(GamePanel.class.getResource("egg.gif")).getImage());
		
		progressBar = i.progress;
		apple = new Food();
		orange = new Food();
		shoe = new Food(); 
		shoe2 = new Food();
		cherry = new Food();
		egg = new Food();
		
		orange.setX(850);
		orange.setY(120);
		apple.setX(850);
		apple.setY(50);
		shoe.setX(950);
		shoe.setY(200);
		shoe2.setX(1050);
		shoe2.setY(400);
		cherry.setX(1000);
		cherry.setY(4);
		egg.setX(900);
		egg.setY(300);
		
		info = i;
		setBackground(LIGHT_BLUE);
		this.setFocusable(true);
		gamestarted = false;
		one = p;
		//one.setX(200);
		//one.setY(200);
		newa = info.StartButton;
		newa.addActionListener(new ButtonListener());
		points = info.pointlabel;
		kl = new KeyboardListener();
		this.addKeyListener(kl);
		newa.setFocusable(false);
		this.setFocusable(true);
		
	}
	/*public Graphics getbuffers()
	{
		return buffer;
	}
	public void setGameStarted(boolean a)
	{
		gamestarted =a;
	}*/
	public void paintComponent(Graphics graph)
	{
		BufferedImage off_Image = new BufferedImage(1050,600,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = off_Image.createGraphics();
		graph.clearRect(20, 20, 500, 500);
		super.paintComponent(graph);
		g2.drawImage(bg,-40,-150,this);
		//g2.setColor(Color.GREEN);
		//g2.fillOval(shoe.getX(),shoe.getY(),30,30);
		g2.drawImage(iicecream,shoe.getX(),shoe.getY(),this);
		
		//g2.setColor(Color.GRAY);
		//g2.fillOval(shoe2.getX(),shoe2.getY(),30,30);
		g2.drawImage(ichoco,shoe2.getX(),shoe2.getY(),this);
		
		//g2.setColor(Color.RED);
		//g2.fillOval(apple.getX(),apple.getY(),30,30);
		g2.drawImage(iapple,apple.getX(),apple.getY(),this);
		
		/*g2.setColor(Color.ORANGE);
		g2.fillOval(orange.getX(),orange.getY(),30,30);*/
		g2.drawImage(icheese,orange.getX(),orange.getY(),this);
		
		g2.drawImage(icherry, cherry.getX(), cherry.getY(), this);
		
		g2.drawImage(iegg, egg.getX(), egg.getY(), this);

		//g2.setColor(Color.BLUE);
		g2.drawImage(doggo,one.getX(),one.getY(),this);
		//g2.fillOval(one.getX(),one.getY(),40,40);
		
		Toolkit.getDefaultToolkit().sync();
		graph.drawImage(off_Image,0,0,this);
		time.start();
	}
	public void start()
	{
		foodpan.setFocusable(true);
		if(gamestarted) {
			int ranY =(int)Math.ceil(Math.random()*400);
			int ranY2 =(int)Math.ceil(Math.random()*400);
			apple.setX(apple.getX()-12);
			shoe.setX(shoe.getX()-11);
			shoe2.setX(shoe2.getX()-11);
			orange.setX(orange.getX()-13);
			egg.setX(egg.getX()-10);
			cherry.setX(cherry.getX()-13);
			one.sethealth(one.gethealth()-1);
			info.updateProgressBar();
			if(one.gethealth()>200)
			{
				one.sethealth(200);
			}
			if((apple.getX()-one.getX()>=-30&&(apple.getX()-one.getX())<=125)&&((Math.abs(one.getY()-apple.getY())<=30||((apple.getY()-one.getY()<=70)&&(apple.getY()-one.getY()>=0)))))
			{
				
				one.sethealth(one.gethealth()+40);
				one.setpoints(one.getpoints()+1);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				applenum++;
				foodpan.applelabel.setText(Integer.toString(applenum));
				updateUI();
				apple.setX(800);
				apple.setY(ranY);
			}
			else if(apple.getX()<=0)
			{
				apple.setX(800);
				apple.setY(ranY);
			}
			
			if((orange.getX()-one.getX()>=-30&&(orange.getX()-one.getX())<=125)&&((Math.abs(one.getY()-orange.getY())<=30||((orange.getY()-one.getY()<=80)&&(orange.getY()-one.getY()>=0)))))
			{
				one.setpoints(one.getpoints()+1);
				one.sethealth(one.gethealth()+40);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				cheesenum++;
				foodpan.cheeselabel.setText(Integer.toString(cheesenum));
				orange.setX(800);
				orange.setY(ranY);
			}
			else if(orange.getX()<=0)
			{
				orange.setX(800);
				orange.setY(ranY2);
			}
			
			if((egg.getX()-one.getX()>=-30&&(egg.getX()-one.getX())<=125)&&((Math.abs(one.getY()-egg.getY())<=30||((egg.getY()-one.getY()<=80)&&(egg.getY()-one.getY()>=0)))))
			{
				one.setpoints(one.getpoints()+1);
				one.sethealth(one.gethealth()+40);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				eggnum++;
				foodpan.egglabel.setText(Integer.toString(eggnum));
				egg.setX(800);
				egg.setY(ranY);
			}
			else if(egg.getX()<=0)
			{
				egg.setX(800);
				egg.setY(ranY2);
			}
			
			if((shoe.getX()-one.getX()>=-30&&(shoe.getX()-one.getX())<=125)&&((Math.abs(one.getY()-shoe.getY())<=30||((shoe.getY()-one.getY()<=80)&&(shoe.getY()-one.getY()>=0)))))
			{
				one.setpoints(one.getpoints()-1);
				one.sethealth(one.gethealth()-30);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				icecreamnum++;
				foodpan.icecreamlabel.setText(Integer.toString(icecreamnum));
				shoe.setX(800);
				shoe.setY(ranY);
			}
			else if(shoe.getX()<=0)
			{
				shoe.setX(800);
				shoe.setY(ranY);
			}
			
			if((shoe2.getX()-one.getX()>=-30&&(shoe2.getX()-one.getX())<=125)&&((Math.abs(one.getY()-shoe2.getY())<=30||((shoe2.getY()-one.getY()<=80)&&(shoe2.getY()-one.getY()>=0)))))
			{
				one.setpoints(one.getpoints()-1);
				one.sethealth(one.gethealth()-60);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				choconum++;
				foodpan.chocolabel.setText(Integer.toString(choconum));
				//foodpan.updateChoco(choconum);
				shoe2.setX(800);
				shoe2.setY(ranY2);
			}
			else if(shoe2.getX()<=0)
			{
				shoe2.setX(800);
				shoe2.setY(ranY2);
			}
			
			if((cherry.getX()-one.getX()>=-30&&(cherry.getX()-one.getX())<=125)&&((Math.abs(one.getY()-cherry.getY())<=30||((cherry.getY()-one.getY()<=80)&&(cherry.getY()-one.getY()>=0)))))
			{
				one.setpoints(one.getpoints()-1);
				one.sethealth(one.gethealth()-30);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				cherrynum++;
				foodpan.cherrylabel.setText(Integer.toString(cherrynum));
				cherry.setX(800);
				cherry.setY(ranY);
			}
			else if(cherry.getX()<=0)
			{
				cherry.setX(800);
				cherry.setY(ranY);
			}
			
			
			if(upward&&one.getY()>0)
			{
				one.setY(one.getY() - 10 );
			}
			if(downward&&one.getY()<380)
			{
				one.setY(one.getY() + 10 );
			}
			if(forward&&one.getX()<650)
			{
				one.setX(one.getX() + 10 );
			}
			if(backward&&one.getX()>0)
			{
				one.setX(one.getX() - 10 );
			}
			if(one.gethealth()<=0)
			{
				info.updateProgressBar();
				repaint();
				gamestarted=false;
				apple.setX(820+(int)(Math.random()*30));
				shoe.setX(820+(int)(Math.random()*30));
				shoe2.setX(820+(int)(Math.random()*30));
				orange.setX(820+(int)(Math.random()*30));
				cherry.setX(820+(int)(Math.random()*30));
				egg.setX(820+(int)(Math.random()*30));
				newa.setText("Start Game");
				JOptionPane.showMessageDialog(null,"Game Over! Your points are: " + one.getpoints() +"\nYou ate: "+ applenum + " apples; " +
				cheesenum + " cheese blocks; " + choconum + " chocolate bars;\n "+ icecreamnum + " ice cream cones; "
						+cherrynum +" cherries and "+ eggnum+" eggs; Try again?");
				one.setpoints(0);
				applenum =0;
				cheesenum =0;
				choconum =0;
				icecreamnum =0;
				cherrynum = 0;
				eggnum =0;
				
				foodpan.applelabel.setText(Integer.toString(applenum));
				foodpan.cheeselabel.setText(Integer.toString(cheesenum));
				foodpan.chocolabel.setText(Integer.toString(choconum));
				foodpan.icecreamlabel.setText(Integer.toString(icecreamnum));
				foodpan.egglabel.setText(Integer.toString(eggnum));
				foodpan.cherrylabel.setText(Integer.toString(cherrynum));
				
				points.setText("Points: "+Integer.toString(one.getpoints()));
				updateUI();
				repaint();
			}
			
			try 
			{
				Thread.sleep(30);
			} 
			catch (Exception exc) 
			{
			}
			repaint();
		}
	}
	class KeyboardListener implements KeyListener
	{
		
		public void keyPressed(KeyEvent a) {
			Toolkit.getDefaultToolkit().sync();
			// TODO Auto-generated method stub
			if(a.getKeyCode()==KeyEvent.VK_DOWN&&gamestarted)
			{
				downward = true;
				//points.setText("down pressed");
				repaint();
			}
			else if(a.getKeyCode()==KeyEvent.VK_UP&&gamestarted)
			{
				upward=true;
				//points.setText("up pressed");
				repaint();
			}
			if(a.getKeyCode()==KeyEvent.VK_RIGHT&&gamestarted)
			{
				forward=true;
				//points.setText("right pressed");
				repaint();
			}
			else if(a.getKeyCode()==KeyEvent.VK_LEFT&&gamestarted)
			{
				backward = true;
				//points.setText("left pressed");
				repaint();
			}
			Toolkit.getDefaultToolkit().sync();
			repaint();
			updateUI();
		}

		@Override
		public void keyReleased(KeyEvent a) {
			// TODO Auto-generated method stub
			if(a.getKeyCode()==KeyEvent.VK_DOWN||!gamestarted)
			{
				downward = false;
				//points.setText("down pressed");
				repaint();
			}
			if(a.getKeyCode()==KeyEvent.VK_UP||!gamestarted)
			{
				upward=false;
				//points.setText("up pressed");
				repaint();
			}
			if(a.getKeyCode()==KeyEvent.VK_RIGHT||!gamestarted)
			{
				forward=false;
				//points.setText("right pressed");
				repaint();
			}
			if(a.getKeyCode()==KeyEvent.VK_LEFT||!gamestarted)
			{
				backward = false;
				//points.setText("left pressed");
				repaint();
			}
			Toolkit.getDefaultToolkit().sync();
			repaint();
			updateUI();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}	
	
	}
	class ButtonListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e) {
		if(!newa.getText().equals("Game Started"))
		{
			downward =false;
			upward=false;
			forward=false;
			backward=false;
			one.setpoints(0);
			one.sethealth(200);
			gamestarted=true;
			newa.setText("Game Started");
			one.setX(50);
			one.setY(180);
			repaint();
		}
	}
	}
	class TimeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent t) {
			start();
		}
		
	}
}



