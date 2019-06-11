package interfacepackage;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SnakeTheme {																					//Autor: Mateusz Konopka

	public Image headLeft;
	public Image headRight;
	public Image headUp;
	public Image headDown;
	public Image body;

	public SnakeTheme(String pathLeft, String pathRight, String pathUp, String pathDown, String pathBody)
	{
		this.headLeft = new ImageIcon(getClass().getClassLoader().getResource(pathLeft)).getImage();
		this.headRight = new ImageIcon(getClass().getClassLoader().getResource(pathRight)).getImage();
		this.headUp = new ImageIcon(getClass().getClassLoader().getResource(pathUp)).getImage();
		this.headDown = new ImageIcon(getClass().getClassLoader().getResource(pathDown)).getImage();
		this.body = new ImageIcon(getClass().getClassLoader().getResource(pathBody)).getImage();
	}

}
