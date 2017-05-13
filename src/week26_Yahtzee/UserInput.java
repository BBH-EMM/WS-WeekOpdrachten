package week26_Yahtzee;

import java.util.Scanner;

public class UserInput {
	private Scanner sc = new Scanner(System.in);
	
	UserInput(){
		//Constructor: for now nothing to do
	}
	String getUserInputString(String message){
		System.out.println(message);
		return sc.nextLine();
	}
	int getUserInputInt(String message){
		System.out.println(message);
		return sc.nextInt();
	}
}
