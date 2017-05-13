package week26_Yahtzee;

public class Beurt {
	Beurt(Player speler){
		DiceBucket bucket = new DiceBucket();
		System.out.println(speler.getNaam());
		bucket.throwDice();
		bucket.showTable();
	}
}
