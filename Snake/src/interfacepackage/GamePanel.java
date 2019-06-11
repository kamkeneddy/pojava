package interfacepackage;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import enginepackage.PlayerAvatar;
import enginepackage.Rodent;
import resultspackage.Result;

public class GamePanel extends ImageBackgroundPanel implements Runnable{  					//Autor: Mateusz Konopka

	Rodent rodent;
	public PlayerAvatar playerAvatarOne,playerAvatarTwo;
	SnakeTheme playerOneSnakeTheme, playerTwoSnakeTheme;
	Result result;
	int pause;
	boolean isMulti;
	
	public GamePanel(Image image) {
		super(image);
		
	rodent = new Rodent();
	playerAvatarOne = new PlayerAvatar(rodent,false);
	playerAvatarTwo = new PlayerAvatar(rodent,true);
	playerOneSnakeTheme = new SnakeTheme("BlueHead_left.png","BlueHead_right.png","BlueHead_up.png","BlueHead_down.png","BlueBody.png");
	playerTwoSnakeTheme = new SnakeTheme("BlueHead_left.png","BlueHead_right.png","BlueHead_up.png","BlueHead_down.png","BlueBody.png");
	this.addKeyListener(playerAvatarOne);
	this.addKeyListener(playerAvatarTwo);
	this.setFocusable(true);
    this.requestFocus();
    isMulti = false;
    pause = 80;

	}
	
	public void setMulti(boolean areTwoPlayers)
	{
		isMulti = areTwoPlayers;
	}
	
	public void setDifLevel(int difLevel)								
	{
		switch(difLevel)
		{
		case 1:
			pause = 80;
			break;
		case 2:
			pause = 50;
			break;
		case 3:
			pause = 30;
			break;
		}
		result = new Result(false);
		result.setDifLevel(difLevel);
	}

	public void setPlayerOneSnakeTheme(SnakeTheme theme)
	{
		playerOneSnakeTheme = theme;
	}
	
	public void setPlayerTwoSnakeTheme(SnakeTheme theme)
	{
		playerTwoSnakeTheme = theme;
	}
	
	public void paintComponent(Graphics g)								
	{
		super.paintComponent(g);
		rodent.paint(g);
		playerAvatarOne.paint(g, playerOneSnakeTheme);
		if(isMulti)
			playerAvatarTwo.paint(g, playerTwoSnakeTheme);
	}

	@Override
	public void run() {												

		if(!isMulti)
			while(playerAvatarOne.gameOn)
			{  
				playerAvatarOne.makeMove();
				
				this.repaint();
				Toolkit.getDefaultToolkit().sync();
				
				  try {
				    	Thread.sleep(pause);
				  } catch (InterruptedException e) {
			    		e.printStackTrace();
			      }
			}
		
		else
		while(playerAvatarOne.gameOn && playerAvatarTwo.gameOn)
		{
		 playerAvatarOne.makeMove();
		 if(isMulti) playerAvatarTwo.makeMove();
		 playerAvatarOne.hasCollided(playerAvatarTwo);
		 playerAvatarTwo.hasCollided(playerAvatarOne);
		 
		 this.repaint();
		 Toolkit.getDefaultToolkit().sync();
		
		 
		  try {
		    	Thread.sleep(pause);
		  } catch (InterruptedException e) {
	    		e.printStackTrace();
	      }
		 }
		
		}
	} 

	
	
	
