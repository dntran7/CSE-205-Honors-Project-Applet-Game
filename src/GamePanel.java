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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class GamePanel extends JPanel
{
	KeyboardListener kl;
	JProgressBar progressBar =new JProgressBar();
	boolean forward=false;
	boolean backward = false;
	boolean downward = false;
	boolean upward = false;
	private static final Color LIGHT_BLUE = new Color(200,235,245);
	Player one;
	Food apple;
	Food orange;
	Food shoe;
	Food shoe2;
	static boolean gamestarted;
	Image pan;
	Graphics buffer;
	JButton newa;
	InfoPanel info;
	Timer time =new Timer(50,new TimeListener());
	JLabel points;
	public GamePanel(Player p,InfoPanel i)
	{
		progressBar = i.progress;
		apple = new Food();
		orange = new Food();
		shoe = new Food();
		shoe2 = new Food();
		orange.setX(820);
		orange.setY(120);
		apple.setX(820);
		apple.setY(500);
		shoe.setX(820);
		shoe.setY(200);
		shoe2.setX(820);
		shoe2.setY(300);
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
	public Graphics getbuffer()
	{
		return buffer;
	}
	public void setGameStarted(boolean a)
	{
		gamestarted =a;
	}
	public void paintComponent(Graphics graph)
	{
		BufferedImage off_Image = new BufferedImage(850,600,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = off_Image.createGraphics();
		graph.clearRect(20, 20, 500, 500);
		super.paintComponent(graph);
		g2.setColor(Color.GREEN);
		g2.fillOval(shoe.getX(),shoe.getY(),30,30);
		
		g2.setColor(Color.GRAY);
		g2.fillOval(shoe2.getX(),shoe2.getY(),30,30);
		
		g2.setColor(Color.RED);
		g2.fillOval(apple.getX(),apple.getY(),30,30);
		
		g2.setColor(Color.ORANGE);
		g2.fillOval(orange.getX(),orange.getY(),30,30);
		
		g2.setColor(Color.BLUE);
		g2.fillOval(one.getX(),one.getY(),40,40);
		
		Toolkit.getDefaultToolkit().sync();
		graph.drawImage(off_Image,0,0,this);
		time.start();
	}
	public void start()
	{
		if(gamestarted) {
			int ranY =(int)Math.ceil(Math.random()*550);
			int ranY2 =(int)Math.ceil(Math.random()*550);
			apple.setX(apple.getX()-12);
			shoe.setX(shoe.getX()-11);
			shoe2.setX(shoe2.getX()-11);
			orange.setX(orange.getX()-13);
			one.sethealth(one.gethealth()-1);
			info.updateProgressBar();
			if(one.gethealth()>200)
			{
				one.sethealth(200);
			}
			if(Math.abs(one.getX()-apple.getX())<=25&&(Math.abs(one.getY()-apple.getY())<=25))
			{
				one.sethealth(one.gethealth()+40);
				one.setpoints(one.getpoints()+1);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				apple.setX(800);
				apple.setY(ranY);
			}
			else if(apple.getX()<=0)
			{
				apple.setX(800);
				apple.setY(ranY);
			}
			
			if(Math.abs(one.getX()-orange.getX())<=25&&(Math.abs(one.getY()-orange.getY())<=25))
			{
				one.setpoints(one.getpoints()+1);
				one.sethealth(one.gethealth()+40);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				orange.setX(800);
				orange.setY(ranY);
			}
			else if(orange.getX()<=0)
			{
				orange.setX(800);
				orange.setY(ranY);
			}
			
			if(Math.abs(one.getX()-shoe.getX())<=25&&(Math.abs(one.getY()-shoe.getY())<=25))
			{
				one.setpoints(one.getpoints()-1);
				one.sethealth(one.gethealth()-30);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				shoe.setX(800);
				shoe.setY(ranY);
			}
			else if(shoe.getX()<=0)
			{
				shoe.setX(800);
				shoe.setY(ranY);
			}
			
			if(Math.abs(one.getX()-shoe2.getX())<=25&&(Math.abs(one.getY()-shoe2.getY())<=25))
			{
				one.setpoints(one.getpoints()-1);
				one.sethealth(one.gethealth()-30);
				points.setText("Points: "+Integer.toString(one.getpoints()));
				shoe2.setX(800);
				shoe2.setY(ranY2);
			}
			else if(shoe2.getX()<=0)
			{
				shoe2.setX(800);
				shoe2.setY(ranY2);
			}
			if(upward&&one.getY()>0)
			{
				one.setY(one.getY() - 10 );
			}
			if(downward&&one.getY()<560)
			{
				one.setY(one.getY() + 10 );
			}
			if(forward&&one.getX()<750)
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
				apple.setX(820);
				shoe.setX(820);
				shoe2.setX(820);
				orange.setX(820);
				newa.setText("Start Game");
				JOptionPane.showMessageDialog(null,"Game Over! Your points are: " + one.getpoints() +"\nTry again?");
				one.setpoints(0);
				points.setText("Points: "+Integer.toString(one.getpoints()));
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
			if(a.getKeyCode()==KeyEvent.VK_DOWN)
			{
				downward = true;
				//points.setText("down pressed");
				repaint();
			}
			else if(a.getKeyCode()==KeyEvent.VK_UP)
			{
				upward=true;
				//points.setText("up pressed");
				repaint();
			}
			if(a.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				forward=true;
				//points.setText("right pressed");
				repaint();
			}
			else if(a.getKeyCode()==KeyEvent.VK_LEFT)
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
			one.setpoints(0);
			
			one.sethealth(200);
			gamestarted=true;
			newa.setText("Game Started");
			one.setX(50);
			one.setY(250);
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



