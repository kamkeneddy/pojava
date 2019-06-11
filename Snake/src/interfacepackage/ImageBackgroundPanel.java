package interfacepackage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
																			

public class ImageBackgroundPanel extends JPanel{										//Autor: Mateusz Konopka

	protected Image backgroundImage;
	
	public ImageBackgroundPanel(Image image)
	{
		this.backgroundImage = image;
	}
	
	public void changeBackgroud(Image image)
	{
		this.backgroundImage = image;
		this.repaint();
	}
	
	public void paintComponent(Graphics g) 
	{
	    g.drawImage(backgroundImage, 0, 0, null);
	}
}