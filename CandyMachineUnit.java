// Kirsten Schumy
// Sept. 4, 2017
// Program is based on an assignment for Ada Developers Academy Jump Start, although it's Java 
// instead of Ruby, involves creating a CandyMachineUnit object, allows for more than one purchase,
// and some of the text has changed.
//
// This program creates a new CandyMachineUnit object. It can respond to the user's money, print
// candy options, allow user to "buy" virtual candy, see if the user can afford to buy more candy,
// and print a final message.

import java.util.HashMap;
import java.util.Map;

public class CandyMachineUnit {
	private double money;		// money available to buy candy
	private Map <Character, Double> vendingOptions; 	// vending machine options and cost
	private int candyCount;		// count of candy user has purchased


	// Creates new CandyMachineUnit from the provided startMoney.
	public CandyMachineUnit(double startMoney) {
		money = startMoney;
		vendingOptions = createVendingOptions();
		candyCount = 0;
	}

	// Prints response to money, which varies according to the amount of money.
	public void moneyResponse() {
		System.out.println();
		System.out.print(moneyToString() + "! ");
		if (money < 0.50) {
			System.out.println("Dang. You're just wasting my time.");
		} else if (money < 2.00) {
			System.out.println("Alright I think we can work something out.");
		} else {
			System.out.println("Look at you, Mr./Ms. Moneybags!");
		}
		System.out.println();
	}

	// Prints options and cost.
	public void printOptions() {
		System.out.println("Well, lemme tell ya what we got here.");
		System.out.println();
		String[] candy = {"Twix","Chips","Nutter Butter","Peanut Butter Cup","Juicy Fruit Gum"};
		int i = 0;
		for (char option : vendingOptions.keySet()) {
			System.out.println(option + " " + moneyToString(vendingOptions.get(option)) + " " + 
					candy[i]);
			i++;
		}
	}

	// Pre: userChoice must be or start with 'A','B','C','D','E' (case does not matter), otherwise 
	// throws IllegalArgumentException.
	//
	// If the user can afford to buy the provided userChoice candy, completes the virtual 
	// transaction and prints text indicating if the transaction was successful or not.
	public void selection(String userChoice) {
		char choice = checkChoice(userChoice);
		if(vendingOptions.get(choice) <= money) {	// Has enough money to make that purchase.
			money -= vendingOptions.get(choice);
			candyCount++;	// Updates candyCount with successful purchase.
			System.out.print("Great!");
			if(!isTooPoor()) {	// User has enough money to buy again so is informed of money left. 
				System.out.println("You have " + moneyToString() + " left.");
			}
		} else {	// Does not have enough money to make that purchase.
			System.out.println("You don't have enough money!");
		}
		System.out.println();
	}

	// Returns true if money is lower than the least expense item and false otherwise.
	public boolean isTooPoor() {
		return money < 0.50;
	}

	// Prints one of two possible final messages, depending on if the user has purchases any candy.
	public void printFinalMessage() {
		if (candyCount == 0) {
			System.out.println("You're broke. Take your " + moneyToString() + " and go elsewhere.");
		} else {
			System.out.println("Thanks for purchasing candy through us.");
			System.out.print("Remember to take your " + candyCount + " piece");
			if (candyCount > 1) {
				System.out.print("s");	// makes "piece" plural
			}
			System.out.print(" of candy and your " + moneyToString() + " change!");
		}
		money = 0.0;	// user has been returned money, so there is no money in CandyMachineUnit.
	}

	// Throws IllegalArgumentException if the 1st letter of provided userChoise (case does not 
	// matter) is not a key of vendingOptions, else returns the upper case of the first letter of 
	// userChoise.
	private char checkChoice(String userChoice) {
		if (!vendingOptions.containsKey(userChoice.toUpperCase().charAt(0))) {
			throw new IllegalArgumentException();
		}
		return userChoice.toUpperCase().charAt(0);
	}

	// Returns money as a String, to two decimal places, and with a dollar sign.
	private String moneyToString() {
		return moneyToString(money);
	}

	// Returns provided intputMoney as a String, to two decimal places, and with a dollar sign.
	private String moneyToString(double intputMoney) {
		return "$" + String.format("%.2f", intputMoney);
	}

	// Creates a HashMap with the vending character options as the keys and the cost as the values.
	// Returns HashMap.
	private Map<Character, Double> createVendingOptions() {		
		Map<Character, Double> toSell = new HashMap<Character, Double>();
		char[] options = {'A','B','C','D','E'};
		double[] cost = {0.65,0.50,0.75,0.65,0.55};
		for(int i = 0; i < options.length; i++) {
			toSell.put(options[i], cost[i]);
		}
		return toSell;
	}

}
