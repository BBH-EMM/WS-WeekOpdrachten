package week26_Yahtzee;

public class DiceBucket {
	private Die[] Dice = new Die[5];
	
	DiceBucket(){
		for (int i = 0; i < Dice.length; i++){
			Dice[i] = new Die();
			Dice[i].rollMe();
		}		
	}

	public void throwDice(){
		for (int i = 0; i < Dice.length; i++){
			Dice[i].rollMe();
		}		

		System.out.println("Uw worp:");
		for (int i = 0; i < Dice.length; i++){
			if (!Dice[i].getDieIsFrozen()){
				System.out.print(Dice[i].printMe() + " ");
			}
		}
		System.out.println();

		//alle 6-en vastzetten
		for (int i = 0; i < Dice.length; i++){
			if (Dice[i].getTopValue()==6){
				Dice[i].setDieIsFrozen(true);
			}
		}

	}
	
	void showTable(){
		System.out.println("Uw vastgehouden dobbelstenen:");
		for (int i = 0; i < Dice.length; i++){
			if (Dice[i].getDieIsFrozen()){
				System.out.print(Dice[i].printMe() + " ");
			}
		}
		System.out.println();
	}
}