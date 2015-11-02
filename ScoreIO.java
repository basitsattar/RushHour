import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreIO {

	//Object output stream to write score to file
	ObjectOutputStream player;
	//object to save current game score
	Score data;
	//list of all scores
	ArrayList<Score> Scores = new ArrayList<Score>();

	public ScoreIO(int gameScore) {
		//method to load score from file
		loadScore();
		//adding current score to list
		data = new Score(gameScore * 10);
		Scores.add(data);
		//comparator object
		ScoreCompare Comparator = new ScoreCompare();
		//sorting
		Collections.sort(Scores, Comparator);
		//keeping only first 10 high scores and removig remaining
		
		if (Scores.size() >= 10) {
			for (int i = 10; i < Scores.size(); i++) {
				Scores.remove(i);
			}

		}

			FileOutputStream output;
			try {
				//Writing object list array to file
				output = new FileOutputStream("score.txt");
				player = new ObjectOutputStream(output);
				player.writeObject(Scores);
			} catch (FileNotFoundException e) {
				System.out.println("Creating new File");
			} catch (IOException e) {
				System.out.println("There is a litle error . Please report so that we can fix it");
			}
			
		

	}

	//loadscore method
	public void loadScore() {
		FileInputStream input;
		try {
			//reading all scores from file and putting in list array
			input = new FileInputStream("score.txt");
			ObjectInputStream playerInput = new ObjectInputStream(input);
			Scores = (ArrayList<Score>) playerInput.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
