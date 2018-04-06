import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class InstructionPanel extends JPanel
{
	Image wholepanel;
	public InstructionPanel()
	{
		wholepanel = (new ImageIcon(InstructionPanel.class.getResource("instructions.jpg"))).getImage();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(wholepanel,0,0,this);
	}
}
