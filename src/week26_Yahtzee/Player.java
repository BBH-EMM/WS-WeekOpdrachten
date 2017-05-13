package week26_Yahtzee;

public class Player {
	private String naam = "";
	private ScoreKaart sk = new ScoreKaart();
	
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
	public ScoreKaart scoreKaart(){
		return sk;
	}
}
