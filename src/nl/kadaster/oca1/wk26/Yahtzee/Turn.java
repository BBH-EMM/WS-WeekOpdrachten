package nl.kadaster.oca1.wk26.Yahtzee;

public class Turn {
	private DiceBucket bucket;
	Turn(Player speler){
		bucket = new DiceBucket();
		System.out.println("Speler " + speler.getNaam() + " is aan de beurt.");
		bucket.throwDice();

		//alle 6-en vastzetten
//		for (int i = 0; i < dice.length; i++){
//			if (dice[i].getTopValue()==6){
//				dice[i].setDieIsFrozen(true);
//			}
//		}

		char c;
		do {
			c = new UserInput().getUserInputChar("Wilt u een dobbelsteen (V)asthouden of (T)eruggeven.");
			switch (c) {
			case 'V': c='X'; vastHouden(); break;
			case 'T': c='X'; terugGeven(); break;
			default: System.out.println("U heeft character '" + c + "' ingevoerd. Dit is geen geldige invoer. probeer het svp opnieuw.");
			}
		} while (c!='V' && c!='T');
		
		System.exit(0);
	}
	
	void vastHouden(){
		System.out.println("vasthouden:");
		char c;
		do {
			c = new UserInput().getUserInputChar("Wilt u één van de (D)obbelstenen vasthouden of een (W)aarde uit uw worp vasthouden. (M) voor terug naar menu.");
			switch (c) {
			case 'D': DobbelSteenVasthouden(); break;
			case 'W': WaardeVasthouden(); break;
			case 'M': break;
			default: System.out.println("U heeft character '" + c + "' ingevoerd. Dit is geen geldige invoer. probeer het svp opnieuw.");
			}
		} while (c!='D' && c!='W' && c!='M');
	}

	void terugGeven(){
		System.out.println("terug geven");
	}
	
	void DobbelSteenVasthouden() {
		System.out.println("Dobbelsteen vasthouden:");
		int i = 0;
		do {
			i = new UserInput().getUserInputInt("Enter de dobbelsteen die u wilt vasthouden. Enter een 0 (nul) wanneer u niets MEER wilt vasthouden.");
			if (i!=0) {
				bucket.freezeDie(i-1);
				bucket.showThrow();
				bucket.showOnTable();
			}
		} while (i != 0);
	}
	
	void WaardeVasthouden() {
		System.out.println("Een waarde van de dobbelstenen vasthouden:");
		int i = 0;
		do {
			i = new UserInput().getUserInputInt("Enter de dobbelsteen waarde die u wilt vasthouden. Enter een 0 (nul) wanneer u niets MEER wilt vasthouden.");
			if (i!=0) {
				bucket.freezeDieValue(i);
				bucket.showThrow();
				bucket.showOnTable();
			}
		} while (i != 0 || (i>=1 && i<=6));
	}
}
