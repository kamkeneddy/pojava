package resultspackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResultsfFile {												//Autor: Kamil Pasik

	String path;
	File file;
	Scanner scanner;
	List <Result> resultsList;
	
	public ResultsfFile(String filePath) throws FileNotFoundException
	{

		file = new File(getClass().getClassLoader().getResource(filePath).getPath());
		scanner = new Scanner(file);
		resultsList = new ArrayList<Result>();
		
		int scoreOne;
		int scoreTwo;
		int difLevel;
		String playerOneName;
		String playerTwoName;
		Result result;
		boolean isMulti;
		
		while(scanner.hasNext())
		{
		  isMulti = scanner.nextBoolean();
			if(!isMulti)
			{
		 	 playerOneName = scanner.next();
		 	 scoreOne = scanner.nextInt();
		 	 difLevel = scanner.nextInt();
		 	 result = new Result(false);
		 	 result.setDifLevel(difLevel);
		 	 result.setfPlayerOne(scoreOne);
		 	 result.setPlayerOneName(playerOneName);
		 	 resultsList.add(result);
			}
			else
			{
			 playerOneName = scanner.next();
			 playerTwoName = scanner.next();
			 scoreOne = scanner.nextInt();
			 scoreTwo = scanner.nextInt();
			 difLevel = scanner.nextInt();
			 result = new Result(true);
			 result.setDifLevel(difLevel);
			 result.setPlayerOneName(playerOneName);
			 result.setPlayerTwoName(playerTwoName);
			 result.setfPlayerOne(scoreOne);
			 result.setfPlayerTwo(scoreTwo);
			 resultsList.add(result);
			}
		}
	}
	
	
	public String getResultsString()
	{
		String resultsString = "";
		
		for(int i=0;i<resultsList.size();i++)
		{
		  if(!resultsList.get(i).isMulti)
		  {
			resultsString+=resultsList.get(i).playerOneName 	 + 
						   "  Poziom trudności: "          		 + 
					       resultsList.get(i).getDifLevelName()	 +
					       "  Wynik: "						     +
					       resultsList.get(i).resOne             +
					       "\n";
		  }
		  else
		  {
			  resultsString+=resultsList.get(i).playerOneName 	 +
					  		" vs "								 +
					  		resultsList.get(i).playerTwoName	 +
					  		"  Poziom trudności: "          	 + 
					  		resultsList.get(i).getDifLevelName() +
					  		"  Wynik: "						     +
					  		resultsList.get(i).resOne            +
					  		":"									 +
					  		resultsList.get(i).resTwo			 +
					  		"\n";
		  }
		}
	 return resultsString;
	}
}