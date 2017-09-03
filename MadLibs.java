// Kirsten Schumy
// Sept. 2, 2017
// Program is based on an assignment for Ada Developers Academy Jump Start, although it's Java 
// instead of Ruby, these is more than one possible output, and the user can play again.
//
// This program produces text, partly completed by user input.

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MadLibs {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Random rand = new Random();
		Map<String, String> words = new HashMap<String, String>();
		
		do {
			System.out.println("Welcome to MadLibs! Please enter in some information below:");
			words = getWords(console, words);
			System.out.println("Here's your MadLib...");
			
			if (rand.nextInt(2) == 0) {
				outputOne(words);	// "Welcome to the University of ___ ..."
			} else {
				outputTwo(words);	// "Welcome to ___ State University..."
			}
			
			words.clear();
			System.out.print("Play again (y/n)?" );
		} while (console.next().toLowerCase().startsWith("y"));
	
	}

	// Uses the provided console to store user's responses to the provided words.
	// Returns words.
	public static Map<String, String> getWords(Scanner console, Map<String, String> words) {
		System.out.println();
		
		System.out.print("noun: ");
		words.put("noun", console.next());

		System.out.print("adjective: ");
		words.put("adjOne", console.next());

		System.out.print("adjective: ");
		words.put("adjTwo", console.next());

		System.out.print("verb ending in \"-ing\": ");
		words.put("verbWithIng", console.next());

		System.out.print("number: ");
		words.put("number", console.next());

		System.out.print("subject in school: ");
		words.put("department", console.next());

		System.out.print("sport: ");
		words.put("sportsTeam", console.next());

		System.out.print("superlative: ");
		words.put("superlative", console.next());

		System.out.print("animal (plural): ");
		words.put("animalsOne", console.next());

		System.out.print("animal (plural): ");
		words.put("animalsTwo", console.next());

		System.out.println();
		return words;
	}
	
	// Produces text using the provided words.
	public static void outputOne(Map <String, String> words) {
		System.out.println();
		System.out.println("Welcome to the University of " + firstUpper(words.get("noun")) +"!");
		System.out.println("As you know, we have many " + words.get("adjTwo") + " programs, "
				+ "especially our Department of " + firstUpper(words.get("department")) +".");
		System.out.println(firstUpper(words.get("department")) + " professor Dr. " + 
				firstUpper(words.get("adjOne")) + " just published a groundbreaking study on " + 
				words.get("number") + " " + words.get("verbWithIng") + " " + 
				words.get("animalsOne") + ".");
		System.out.println("And our " + words.get("sportsTeam") + " team recently won the "
				+ "championship for being the " + words.get("superlative") + " in the country!");
		System.out.println("Go " + firstUpper(words.get("animalsTwo")) + "!");
		System.out.println();
	}

	// Produces text using the provided words.
	public static void outputTwo(Map <String, String> words) {
		System.out.println();
		System.out.println("Welcome to " + firstUpper(words.get("adjOne")) + " State University!");
		System.out.println("As you may have heard, we've had some bad press recently.");
		System.out.println(words.get("number") + " students on our " + words.get("sportsTeam") + 
				" team were recently found guilty of " + words.get("verbWithIng") + " in " + 
				words.get("department") + " class.");
		System.out.println("And there were " + words.get("adjTwo") + " " + words.get("animalsTwo")+
				" loose in the dorms.");
		System.out.println("And students said we have the " + words.get("superlative") + " " +
				words.get("noun") + " they've ever seen.");
		System.out.println("But we're sure to bounce back. Go " + 
				firstUpper(words.get("animalsOne")) + "!");
		System.out.println();
	}

	// Returns the provided word with the first letter capitalized.
	public static String firstUpper(String word){
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
}
