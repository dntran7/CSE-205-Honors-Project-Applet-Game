import java.awt.*;

import javax.swing.*;

import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	FoodPanel foodpan;
	JPanel left =new JPanel();
	JPanel gamePanel = new JPanel();
	InstructionPanel instructionPan;
	StartPanel startPan;
	CardLayout a = new CardLayout();
	public void init()
	{
		instructionPan = new InstructionPanel();
		startPan = new StartPanel();
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
		gamePanel.setLayout(new BorderLayout());
		gamePanel.add(left, BorderLayout.CENTER);
		gamePanel.add(info, BorderLayout.EAST);
		getContentPane().setLayout(a);
		getContentPane().add(startPan,"a");
		getContentPane().add(gamePanel,"b");
		getContentPane().add(instructionPan,"c");
		setSize(width, height);	
		//play.method();
		startPan.instructions.addActionListener(new ButtonListener());
		startPan.start.addActionListener(new ButtonListener());
		instructionPan.addMouseListener(new ClickListener());
		gamePanel.setFocusable(true);
		game.setFocusable(true);
	}
	class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(startPan.start))
			{
				a.next(getContentPane());
				startPan.setFocusable(false);
				instructionPan.setFocusable(false);
				game.newa.setFocusable(false);
				gamePanel.setFocusable(true);
				game.setFocusable(true);
				gamePanel.grabFocus();
				game.grabFocus();
				
			}
			else
			{
				a.last(getContentPane());
			}
			
		}
		
	}
	class ClickListener implements MouseListener

	{	@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			a.first(getContentPane());
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
