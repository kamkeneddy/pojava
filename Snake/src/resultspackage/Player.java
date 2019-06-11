package resultspackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Player {															//Autor: Kamil Pasik

	public String playerName;

	public Player(String name)
	{
		playerName = name;
	}

	public void savePlayer() throws IOException
	{
		 BufferedWriter out = new BufferedWriter(new FileWriter(getClass().getClassLoader().getResource("player_names.txt").getPath(),true));
         out.write(playerName + "\n");
         out.close();
	}

}