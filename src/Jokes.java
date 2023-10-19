import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jokes {
	public static ArrayList<String> loadJokes(){

		FileReader file;
		BufferedReader buffer;
		String line;
		ArrayList<String> jokesList = new ArrayList<>();
		
		try {
			file = new FileReader("src/myFiles/jokes.txt");
			buffer = new BufferedReader(file);
			line = buffer.readLine();
			while(line != null) {
				jokesList.add(line);
				line = buffer.readLine();
			}
			buffer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return jokesList;
	}
}
