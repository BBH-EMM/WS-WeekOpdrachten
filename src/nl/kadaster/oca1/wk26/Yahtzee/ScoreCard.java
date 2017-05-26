package nl.kadaster.oca1.wk26.Yahtzee;

public class ScoreCard {
	private int score;
	
	private int[] enen   = new int[Yahtzee.cntDice];
	private int[] tweeen = new int[Yahtzee.cntDice];
	private int[] drieen = new int[Yahtzee.cntDice];
	private int[] vieren = new int[Yahtzee.cntDice];
	private int[] vijven = new int[Yahtzee.cntDice];
	private int[] zessen = new int[Yahtzee.cntDice];
	
	private int   totalRegularThrow       =  0;
	final   int   bonusIfRegularIsAbove63 = 35;
	private int   totalScoreCardUpperHalf =  0;
	
	private int[] threeOfAKind = new int[Yahtzee.cntDice];
	private int[] carre = new int[Yahtzee.cntDice];
	private int[] fullHouse = new int[Yahtzee.cntDice];
	private int[] kleineStraat = new int[Yahtzee.cntDice];
	private int[] groteStraat = new int[Yahtzee.cntDice];
	private int[] yahtzee = new int[Yahtzee.cntDice];
	private int[] chance = new int[Yahtzee.cntDice];

	private int   totalScoreCardLowerHalf = 0;
	private int   grandTotal              = 0; //is calculatie, score bevat het puntentotaal inclusief eventuele extra bonussen.
	
	void telOpBijScore(int aantal){
		score += aantal;
	}
	int getScore(){
		return score;
	}
	
	public boolean saveEnen(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, enen, 1);
	}
	
	public boolean saveTweeen(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, tweeen, 2);
	}
	
	public boolean saveDrieen(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, drieen, 3);
	}
	
	public boolean saveVieren(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, vieren, 4);
	}
	
	public boolean saveVijven(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, vijven, 5);
	}
	
	public boolean saveZessen(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, zessen, 6);
	}
	
	public boolean saveThreeOfAKind(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, threeOfAKind, 0);
	}
	
	public boolean saveCarre(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, carre, 0);
	}
	
	public boolean saveFullHouse(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, fullHouse, 0);
	}
	
	public boolean saveKleineStraat(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, kleineStraat, 0);
	}
	
	public boolean saveGroteStraat(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, groteStraat, 0);
	}
	
	public boolean saveYahtzee(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, yahtzee, 0);
	}
	
	public boolean saveChance(Die[] dobbelstenen) {
		return saveDobbelstenen(dobbelstenen, chance, 0);
	}
	
	private boolean saveDobbelstenen(Die[] dobbelstenen, int[] arrayToSaveTo, int saveTopValue) {
		for (int i = 0; i < dobbelstenen.length; i++){
			if (arrayToSaveTo[i]!=0) return false; //already saved
			
			if (saveTopValue == 0) { //save all
				arrayToSaveTo[i]=dobbelstenen[i].getTopValue();
			} else if (dobbelstenen[i].getTopValue()==saveTopValue){
				arrayToSaveTo[i]=dobbelstenen[i].getTopValue();
			} else {
				arrayToSaveTo[i] = 0;
			}
		}
		return true;
	}
	
	public void calculateScore() {
		for (int i: enen)   totalRegularThrow += i;
		for (int i: tweeen) totalRegularThrow += i;
		for (int i: drieen) totalRegularThrow += i;
		for (int i: vieren) totalRegularThrow += i;
		for (int i: vijven) totalRegularThrow += i;
		for (int i: zessen) totalRegularThrow += i;

		if (grandTotal>=63) {
			totalScoreCardUpperHalf = totalRegularThrow + bonusIfRegularIsAbove63;
		} else {
			totalScoreCardUpperHalf = totalRegularThrow;
		}
		
		for (int i: threeOfAKind) totalScoreCardLowerHalf += i;
		for (int i: carre) totalScoreCardLowerHalf += i;
		for (int i: fullHouse) totalScoreCardLowerHalf += i;
		for (int i: kleineStraat) totalScoreCardLowerHalf += i;
		for (int i: groteStraat) totalScoreCardLowerHalf += i;
		for (int i: yahtzee) totalScoreCardLowerHalf += i;
		for (int i: chance) totalScoreCardLowerHalf += i;
		
		grandTotal = totalScoreCardUpperHalf + totalScoreCardLowerHalf;
		score = grandTotal;
	}
}
