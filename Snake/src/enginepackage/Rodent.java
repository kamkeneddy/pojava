package enginepackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rodent {						//Autor: Kamil Pasik

	int xPos;
	int yPos;

	public Rodent()								
	{
		Random r = new Random();
		xPos = r.nextInt(71)*10;
		yPos = r.nextInt(44)*10;
	}

	public void paint(Graphics g)				
	{
	g.setColor(Color.BLACK);
	g.fillOval(xPos, yPos, 10, 10);
	
	}

	public void recalculate() {					
		Random r = new Random();
	
		xPos = r.nextInt(71)*10;
		yPos = r.nextInt(44)*10;		
	}


}

