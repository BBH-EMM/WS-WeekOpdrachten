package week26_Yahtzee;

public class Die {
	//ezelsbruggetje: the public must be protected by a default private
	private int topValueDie = 1;
	private boolean dieIsFrozen = false;

	public void rollMe() {
		final int max = 7;
		final int min = 1;
		//(int)(Math.random() * (max - min) + min)
		if(!getDieIsFrozen()){
			topValueDie = (int) (Math.random() * (max - min) + min);
		}
	}

	public int getTopValue() {
		return topValueDie;
	}

	public void setDieIsFrozen(boolean setValue){
		dieIsFrozen = setValue;
	}
	public boolean getDieIsFrozen(){
		return dieIsFrozen;
	}

	public String printMe(){
		return Integer.toString(getTopValue());
	}

	//Print characters
	char sp = ' ';
	char ul = '\u250F';
	char t  = '\u2501';
	char ur = '\u2513';
	char l  = '\u2503';
	char r  = '\u2503';
	char ll = '\u2517';
	char lr = '\u251B';

	public String printLine_1(){
		return "" + ul + t+t+t+t+t + ur + "";
	}
	public String printLine_2(){
		switch(getTopValue()){
		case 1: 
			return "" + l + sp + sp + sp + sp + sp + r + "";
		case 2: 
			return "" + l + "o" + sp + sp + sp + sp + r + "";
		case 3: 
			return "" + l + "o    " + r + "";
		case 4: 
			return "" + l + "o   o" + r + "";
		case 5: 
			return "" + l + "o   o" + r + "";
		case 6: 
			return "" + l + "o   o" + r + "";
		default:
			return "ERROR CANNOT HAPPEN!!";
		}
	}
	public String printLine_6(){
		return "" + ll + t+t+t+t+t + lr + "";
	}
}
