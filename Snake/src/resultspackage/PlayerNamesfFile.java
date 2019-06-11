package resultspackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamesfFile {												//Autor: Kamil Pasik

	public List <String> namesList;
	
	public PlayerNamesfFile(String filepath)
	{
		namesList = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(filepath).getPath()))) {
			
		    String line;
		    while ((line = br.readLine()) != null) {
		       namesList.add(line);
		    }
		} catch (FileNotFoundException e) {
				System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
