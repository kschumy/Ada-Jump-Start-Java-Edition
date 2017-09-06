// Kirsten Schumy
// Sept. 4, 2017
// Program is based on an assignment for Ada Developers Academy Jump Start, although it's Java 
// instead of Ruby, involves creating a CandyMachineUnit object, allows for more than one purchase,
// and some of the text has changed.
//
// This program allows the user to purchase virtual candy from Ada's Computer Candy Machine.

import java.util.Scanner;

public class CandyMachine {

	public static void main(String [] arg) {
		Scanner console = new Scanner(System.in);
		printWelcomeMessage(); 
		
		System.out.print("How much money do ya got? > $");
		CandyMachineUnit vending = new CandyMachineUnit(console.nextDouble());
		
		vending.moneyResponse();
		vending.printOptions();
		
		purchase(console, vending);
		
		vending.printFinalMessage();
	}

	// Uses the user's responses to the provided console to purchases candy from the provided 
	// vending. User can choose to make purchases until the user does not have enough money left.
	public static void purchase(Scanner console, CandyMachineUnit vending) {
		System.out.println();
		do {
			System.out.print("So, what'll ya have? > ");
			vending.selection(console.next());	// User's selection of candy to buy
			if (vending.isTooPoor()) {	//  if left money < least expensive thing ($0.50)
				break;
			}
			System.out.print("Want something else? (y/n) > ");
		} while(console.next().toLowerCase().startsWith("y"));
		System.out.println();
	}
	
	
	// Print welcome message for Ada's Computer Candy Machine.
	public static void printWelcomeMessage() {
		System.out.println("Welcome to Ada's Computer Candy Machine!");
		System.out.println("(All candy provided is virtual.)");
	}

}