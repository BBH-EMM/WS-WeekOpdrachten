package nl.kadaster.oca1.wk26.Yahtzee;

public class Yahtzee {
	static boolean blnAutoPlay = true;
	
	static int maxAantalSpelers = 4;
	static int cntDice = 5;
	
	public static void main(String[] args){
	
		Game spel = new Game(maxAantalSpelers);
		
		if (!blnAutoPlay) Utils.clearConsole();
		
		System.out.println();
		System.out.println("Het spel is beïndigd...");
		spel.printSpelerScores();
		
		
		System.out.println("Speler xxx heeft gewonnen.");	
	}
	
}
