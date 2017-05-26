package nl.kadaster.oca1.wk26.Yahtzee;

public class Player {
	private String naam = "";
	private ScoreCard sk = new ScoreCard();
	
	Player(String naam){
		//System.out.println(naam);
		this.naam = naam;
		//System.out.println(naam);
	}
	
	public String getNaam(){
		return naam;
	}
	
	public int getScore(){
		return sk.getScore();
	}
	public ScoreCard scoreKaart(){
		return sk;
	}
}
