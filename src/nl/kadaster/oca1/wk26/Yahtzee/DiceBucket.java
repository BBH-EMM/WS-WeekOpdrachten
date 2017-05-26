package nl.kadaster.oca1.wk26.Yahtzee;

public class DiceBucket {
	private Die[] dice = new Die[Yahtzee.cntDice];
	
	DiceBucket(){
		for (int i = 0; i < dice.length; i++){
			dice[i] = new Die();
			dice[i].rollMe();
		}
	}

	public void throwDice(){
		this.rollDice();
		
		if (Yahtzee.blnAutoPlay) {
			dice = this.sortDice(dice);
			// for more difficulty for human players do not sort.
		}
		
		this.showThrow();
		
	}
	
	void showThrow() {
		System.out.println("Uw worp:");
		for (int i = 0; i < dice.length; i++){
			if (dice[i].getDieIsFrozen()){
				System.out.print("- ");
			} else {
				System.out.print(dice[i].printMe() + " ");
			}
		}
		System.out.println();
	}

	void showOnTable(){
		System.out.println("Uw vastgehouden dobbelstenen:");
		for (int i = 0; i < dice.length; i++){
			if (!dice[i].getDieIsFrozen()){
				System.out.print("- ");
			} else {
				System.out.print(dice[i].printMe() + " ");
			}
		}
		System.out.println();
	}
	
	void rollDice() {
		for (int i = 0; i < dice.length; i++){
			dice[i].rollMe();
		}		
	}

	void freezeDie(int dobbelsteen) {
		dice[dobbelsteen].setDieIsFrozen(true);
	}
	
	void freezeDieValue(int topValue) {
		for (int i=0; i<dice.length; i++) {
			if (dice[i].getTopValue()==topValue) {
				dice[i].setDieIsFrozen(true);
			}
		}
	}
	
	private Die[] sortDice(Die[] dobbelstenen) {
		boolean debugPrint = false;//set to true for extra debug info
		
		Die[] dice = new Die[Yahtzee.cntDice];
		
		for (int i=0; i<dice.length; i++) {
			if (debugPrint) System.out.println("new dob nr: " + i);
			for (int j=1; j<=6; j++) {
				if (debugPrint) System.out.println("     check for value: " + j);
				for (int k=0; k<dobbelstenen.length; k++) {
					if (dobbelstenen[k]!=null) {
						if (debugPrint) System.out.println("          dob has topvalue: " + dobbelstenen[k].getTopValue());
					}
					if (dobbelstenen[k]!=null && dobbelstenen[k].getTopValue()==j) {
						if (debugPrint) System.out.println("                copying: " + dice[i] + " <= " + dobbelstenen[k]);
						dice[i] = dobbelstenen[k];
						dobbelstenen[k] = null;
						if (debugPrint) System.out.println("                check deleted: " + dobbelstenen[k]);
						i++;
						if (debugPrint) System.out.println("new dob nr: " + i);
					}
				}
			}
		}
		
		return dice;
	}
}