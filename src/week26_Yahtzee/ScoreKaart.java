package week26_Yahtzee;

public class ScoreKaart {
	private int score;
	
	void telOpBijScore(int aantal){
		score += aantal;
	}
	int getScore(){
		return score;
	}
}
