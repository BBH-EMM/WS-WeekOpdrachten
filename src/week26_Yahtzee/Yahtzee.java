package week26_Yahtzee;

public class Yahtzee {
	static boolean blnAutoPlay = true;
	
	public static void main(String[] args){
		int maxAantalSpelers = 4;
		
		Game spel = new Game(maxAantalSpelers);
		
		for (int i=0; i<99; i++){
			if (!blnAutoPlay) System.out.println();
		}
		System.out.println();
		System.out.println("Het spel is beïndigd...");
		spel.printSpelerScores();
		
		
		System.out.println("Speler xxx heeft gewonnen.");	
	}
	
}
