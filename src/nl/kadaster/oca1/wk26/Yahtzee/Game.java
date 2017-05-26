package nl.kadaster.oca1.wk26.Yahtzee;

import java.util.Scanner;

public class Game {
	private int aantalSpelers=0;
	private int maxAantalSpelers;
	private Player spelers[];
	
	Game(int maxAantalSpelers){
		this.maxAantalSpelers = maxAantalSpelers;

		spelers = new Player[maxAantalSpelers];
		
		this.printHeader(true);
		Utils.waitSeconds(3);
		this.getSpelerNamen();
		
		this.printHeader(true, 3);
		System.out.println("");
		System.out.println("Het spel kan beginnen. Succes aan alle spelers!");
		//System.out.println("");
		printSpelerNamen();
		System.out.println("");
		System.out.println("");
		
		for (int i=0; i<spelers.length; i++) {
			Turn b = new Turn(spelers[i]);
		}
		
		
	}

	private void getSpelerNamen(){
		String lastNameUsed = "";
		UserInput ui = new UserInput();
		
		do  {
			System.out.println();
			if (Yahtzee.blnAutoPlay){
				lastNameUsed = this.autoPlay();
			} else {
				lastNameUsed = ui.getUserInputString("Enter een spelernaam voor speler nummer " + ++aantalSpelers + ". Alleen ENTER voor het stoppen van spelernamen invoeren.");
			}
			if (!lastNameUsed.equals("")){
				spelers[aantalSpelers-1] = new Player(lastNameUsed);
				System.out.println("Welkom in het spel JavahtZee " + spelers[aantalSpelers-1].getNaam() + "!");
			}
			this.printIngevoerdeSpelerNamen();
			if (Yahtzee.blnAutoPlay) Utils.waitSeconds(2);
		} while (!lastNameUsed.equals("") && aantalSpelers<maxAantalSpelers);
		System.out.println("");
		System.out.println("Alle spelers zijn ingevoerd. Het spel kan beginnen.");
		Utils.waitSeconds(2);
	}
	
	private void printIngevoerdeSpelerNamen(){
		System.out.println();
		switch (aantalSpelers) {
		case 0:
			//System.out.println("");
			break;
		case 1:
			System.out.println("Onderstaande speler is ingevoerd;");
			break;
		default:
			System.out.println("Onderstaande spelers zijn ingevoerd;");
			break;
		}
		printSpelerNamen();
	}
	private void printSpelerNamen(){
		for (int i = 0; i<spelers.length; i++){
			if (spelers[i] != null) System.out.println("Speler " + (i+1) + ": " + spelers[i].getNaam());
		}
	}
	public void printSpelerScores(){
		for (int i = 0; i<spelers.length; i++){
			if (spelers[i] != null) {
				System.out.print("Speler " + (i+1) + ": ");
				System.out.print( spelers[i].getNaam() + " ");
				System.out.println("heeft " + spelers[i].scoreKaart().getScore() + " punten.");
			}
		}
	}
	private String autoPlay(){
		System.out.println("Enter een spelernaam voor speler nummer " + ++aantalSpelers + ". Alleen ENTER voor het stoppen van spelernamen invoeren.");
		
		switch (aantalSpelers-1){
		case 0: System.out.println("Marnix"); return "Marnix";
		case 1: System.out.println("Mama"); return "Mama";
		case 2: System.out.println("Oma"); return "Oma";
		case 3: System.out.println("Eugène"); return "Eugène";
		default: return "";
		}
	}
	private void printHeader(boolean clearScreen){
		Utils.clearConsole();
		this.printHeader();
	}
	private void printHeader(boolean clearScreen, int waitSecondsBeforeClearing){
		Utils.waitSeconds(waitSecondsBeforeClearing);
		Utils.clearConsole();
		this.printHeader();
	}
	private void printHeader(){
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("************                                                *************");
		System.out.println("************                                                *************");
		System.out.println("************                   JavahtZee                    *************");
		System.out.println("************                                                *************");
		System.out.println("************                                                *************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
		System.out.println("*************************************************************************");
	}
}
