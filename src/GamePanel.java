import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	
	private static final Color LIGHT_BLUE = new Color(200,235,245);
	private static int gameSpeed;
	Player one;
	Food foods;
	Started st;
	public GamePanel(Player p, Started as)
	{
		st = as;
		gameSpeed =20;
		one = p;
		setBackground(LIGHT_BLUE);
		gameplay();
	}
	
	public void increaseSpeed()
	{
		gameSpeed+=10;
	}
	public void paint(Graphics graph)
	{
		super.paintComponent(graph);
		graph.setColor(Color.BLUE);
		graph.fillOval(one.getX(),one.getY(),30,30);
	}
	public void gameplay()
	{
		while (st.getStarted()==true)
		{
			one.setX(one.getX()+10);
			one.setY(one.getY()+10);
			repaint();
			if (one.getX()==100)
			{
				break;
			}
		}
	}
	class KeyboardListener implements KeyListener
	{
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	
	}
}


