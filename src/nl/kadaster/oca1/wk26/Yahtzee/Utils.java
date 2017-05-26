package nl.kadaster.oca1.wk26.Yahtzee;

public class Utils {
	static void clearConsole(){
		clearConsole(99);
	}
	static void clearConsole(int aantalRegels){
		for (int i=0; i<aantalRegels; i++){
			System.out.println();
		}
	}
	static void waitSeconds(int aantalSeconden){
		try {
			Thread.sleep(aantalSeconden*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * Demonstrating console colring
 * @author SANTHOSH REDDY MANDADI
 * @version 1.0
 * @since 06-June-2013
 * http://www.santhoshreddymandadi.com/java/coloring-java-output-on-console.html
 */
class Coloring {
  static String colorMessage(String message, int color) {
    //System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
    //System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
	//return ("\033[" + color + "m" + message + "\033[0m");
	  return "\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m";
  }
}
