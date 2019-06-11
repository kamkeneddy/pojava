package enginepackage;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import interfacepackage.SnakeTheme;

public class PlayerAvatar implements KeyListener {		//Autor: Mateusz Konopka

	
	List <Integer> Xpos;
	List <Integer> Ypos;
	int elementSize;
	boolean ifUp;
	boolean ifDown;
	boolean ifLeft;
	boolean ifRight;
	Rodent rodent;
	
	boolean playerOne;
	boolean playerTwo;
	
	public boolean gameOn;
	boolean isSecondPlayer;
	
	public PlayerAvatar(Rodent rrodent, boolean isPlayerTwo)
	{
		Xpos = new ArrayList<Integer>();
		Ypos = new ArrayList<Integer>();
		elementSize = 10;
	
		ifUp=true;
		ifDown=false;
		ifLeft=false;
		ifRight=false;
	
		gameOn=true;
		isSecondPlayer=isPlayerTwo;
		
		if(!isSecondPlayer)
		{
			Xpos.add(300);
			Ypos.add(200);	
		}
		else
		{
			Xpos.add(350);
			Ypos.add(220);
		}

		rodent = rrodent;
	}

	boolean addElement(Rodent rodent)
	{
		if(rodent.xPos == Xpos.get(0)&&
		   rodent.yPos == Ypos.get(0))
		{
			Xpos.add(0, rodent.xPos);
			Ypos.add(0, rodent.yPos);
			return true;
		}
		return false;
	}

	int nextX()
	{
		if(ifRight) return Xpos.get(0) + elementSize;
		if(ifLeft)  return Xpos.get(0) - elementSize;
		else
			return Xpos.get(0);
	
	}

	int nextY()
	{
		if(ifUp)   return Ypos.get(0) - elementSize;
		if(ifDown) return Ypos.get(0) + elementSize;
		else
			return Ypos.get(0);
	}

	public void move()
	{
 
		if(Xpos.size()>1)
			for(int i=Xpos.size()-1;i>0;i--)
			{
				Xpos.set(i, Xpos.get(i-1));	
				Ypos.set(i, Ypos.get(i-1));	
			}
		Xpos.set(0, nextX());
		Ypos.set(0, nextY());

	}
	
	public void paint(Graphics g, SnakeTheme theme)
	{
		for(int i=0;i<Xpos.size();i++)
		{
			if(ifUp    && i==0)  g.drawImage(theme.headUp, Xpos.get(i), Ypos.get(i), null);
				else
			if(ifDown  && i==0)  g.drawImage(theme.headDown, Xpos.get(i), Ypos.get(i), null);
				else
			if(ifLeft  && i==0)  g.drawImage(theme.headLeft, Xpos.get(i), Ypos.get(i), null);
				else
			if(ifRight && i==0)  g.drawImage(theme.headRight, Xpos.get(i), Ypos.get(i), null);
				else
								 g.drawImage(theme.body, Xpos.get(i), Ypos.get(i), null);
		}
	}

	public int getScore()
	{
		return Xpos.size();
	}

	boolean isGameOver()
	{
	
		for(int i=0;i<Xpos.size();i++)
			if(Xpos.get(i) == nextX() && 
			Ypos.get(i) == nextY())
				return true;
   
  
  		 if(Xpos.get(0)<0 || Xpos.get(0)>710 
  		 || Ypos.get(0)<0 || Ypos.get(0)>440)
  			 return true;
	
  		 
  	 return false; 
	}
	
	public void hasCollided(PlayerAvatar anotherPlayer)
	{
		for(int i=0;i<anotherPlayer.Xpos.size();i++)
			if(anotherPlayer.Xpos.get(i) == nextX() && 
			   anotherPlayer.Ypos.get(i) == nextY())
				 gameOn  = false;
	}

	public void preparefNewGame()
	{
		gameOn = true;
	
		ifUp=true;
		ifDown=false;
		ifLeft=false;
		ifRight=false;
	
		Xpos.clear();
		Ypos.clear();

		if(!isSecondPlayer)
		{
			Xpos.add(400);
			Ypos.add(240);	
		}
		else
		{
			Xpos.add(300);
			Ypos.add(240);
		}
	
		this.rodent.recalculate();
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
	   if(!isSecondPlayer)
		switch( keyCode ) 
		{ 
			case KeyEvent.VK_UP:
			{
        	  if(ifDown == true && Xpos.size()>1) { break; }
              ifUp=true;
              ifDown=false;
              ifLeft=false;
              ifRight=false;
              break;
			}
        	case KeyEvent.VK_DOWN:
        	{
        	  if(ifUp == true && Xpos.size()>1) { break; }
              ifDown=true;
              ifUp=false;
              ifLeft=false;
              ifRight=false;
              break;
        	}
        	case KeyEvent.VK_LEFT:
        	{
        	  if(ifRight == true && Xpos.size()>1) { break; }
        	  ifLeft=true;
        	  ifRight=false;
        	  ifUp=false;
        	  ifDown=false;
        	  break;
        	}
        	case KeyEvent.VK_RIGHT :
        	{
        	  if(ifLeft == true && Xpos.size()>1) { break; }
        	  ifRight=true;
        	  ifLeft=false;
        	  ifUp=false;
        	  ifDown=false;
              break;
        	}
        }
	  else
		switch( keyCode ) 
			{ 
			case KeyEvent.VK_W:
			{
	          if(ifDown == true && Xpos.size()>1) { break; }
	          ifUp=true;
	          ifDown=false;
	          ifLeft=false;
	          ifRight=false;
	          break;
			}
	        case KeyEvent.VK_S:
	        {
	          if(ifUp == true && Xpos.size()>1) { break; }
	          ifDown=true;
	          ifUp=false;
	          ifLeft=false;
	          ifRight=false;
	          break;
	        }
	        case KeyEvent.VK_A:
	        {
	          if(ifRight == true && Xpos.size()>1) { break; }
	          ifLeft=true;
	          ifRight=false;
	          ifUp=false;
	          ifDown=false;
	          break;
	        }
	        case KeyEvent.VK_D:
	        {
	          if(ifLeft == true && Xpos.size()>1) { break; }
	          ifRight=true;
	          ifLeft=false;
	          ifUp=false;
	          ifDown=false;
	          break;
	        }
	    }
		  
	} 



	@Override
	public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
	}

	
	public void makeMove() {
		if(!this.isGameOver())
		{
			if(this.addElement(rodent)) rodent.recalculate();
			
			this.move();
		}
		else
		{
		this.gameOn = false;
		}
	

	}



//
}