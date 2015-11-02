import java.io.Serializable;

import javax.swing.JOptionPane;


//to store high scores in files
public class Score implements Serializable{
	int score=0;
	String name="Player";
	
	public Score(int gamescore){
		//getting name of player
		String player=JOptionPane.showInputDialog("Please Enter your name");
		this.name=player;
		this.score=gamescore;
		
	}
	public Score(){
		
	}
	
	//geMethods
	public String getName(){
		return this.name;
	}
	public int getScore(){
		return this.score;
	}
	

}
