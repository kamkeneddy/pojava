package resultspackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Result {														//Autor: Kamil Pasik
	String playerOneName;
	String playerTwoName;
	boolean isMulti;
	int resOne;
	int resTwo;
	int difLevel;



public Result(boolean isMultiPlayer)
{
	isMulti = isMultiPlayer;
	resOne=0;
	resTwo=0;
	playerOneName="";
	playerTwoName="";
	difLevel =0;
}

public void setPlayerOneName(String name)
{
	playerOneName = name;
}

public void setPlayerTwoName(String name)
{
	playerTwoName = name;
}

public void setfPlayerOne(int result)
{
	this.resOne = result;
}

public void setfPlayerTwo(int result)
{
	this.resTwo = result;
}

public void setDifLevel(int level)
{
	this.difLevel = level;
}

public String getDifLevelName()
{
  String difLevelName="";
	
  switch(difLevel)
  {
   case 1:
	  difLevelName = "Łatwy";
	  break;
   case 2:
	  difLevelName = "Sredni";
	  break;
   case 3:
 	  difLevelName = "Trudny";
	  break;
  }
  return difLevelName;
}

public void saveResult() throws IOException
{	
   if(!isMulti)
   {
	 BufferedWriter out = new BufferedWriter(new FileWriter(getClass().getClassLoader().getResource("results.txt").getFile(),true));
	 if(playerOneName != "")
		 out.write(isMulti + " " + playerOneName + " " + resOne + " " + difLevel + " \n");
	 else
		 out.write(isMulti + " " + "NameNotStated " + resOne + " " + difLevel + " \n");
     out.close();
   } 
   else
   {
	 BufferedWriter out = new BufferedWriter(new FileWriter(getClass().getClassLoader().getResource("results.txt").getFile(),true)); 
	 if(playerOneName != "" && playerTwoName!= "")
		 	 out.write(isMulti + " " + playerOneName + " " + playerTwoName + " " + resOne + " " + resTwo + " " + difLevel + " \n");
	 else
		 if(playerOneName == "" && playerTwoName!= "")
			 out.write(isMulti + " " + "NameNotStated" + " " + playerTwoName + " " + resOne + " " + resTwo + " " + difLevel + " \n");
	 else
		 if(playerOneName != "" && playerTwoName == "")
			 out.write(isMulti + " " + playerOneName + " " + "NameNotStated" + " " + resOne + " " + resTwo + " " + difLevel + " \n");
	 else
		 	 out.write(isMulti + " " + "NameNotStated" + " " + "NameNotStated" + " " + resOne + " " + resTwo + " " + difLevel + " \n");
     out.close();
   }
}

}