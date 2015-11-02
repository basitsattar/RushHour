import java.util.Comparator;


//Comparator class to save scores and sort them
public class ScoreCompare implements Comparator<Score> {

	@Override
	public int compare(Score player1, Score player2) {

	//returning -1 if score1>score2 ,1 if score1<score2  and 0 if equal
		int score1 = player1.getScore();
		int score2 = player2.getScore();

		if (score1 > score2)
			return -1;
		if (score1 < score2)
			return 1;
		else
			return 0;

	}

}
