// Kirsten Schumy
// Sept. 14, 2017
// Program is based on an assignment for Ada Developers Academy Jump Start, although it's Java 
// instead of Ruby, prints an "I VOTED" sticker, and allows the user to decide how many candidates, 
// who the candidates are, and how many voters there are.
//
// This program produces election results based on information provided by the user.

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Election {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		introMessage();
		String[] candidatesList = getCandidates(console);
		Map<String, Integer> electionResults = getVotes(console, candidatesList);
		printResults(electionResults);
		printSticker();
	}

	// Employs the user's responses to the provided console to compile the list of candidates.
	// Returns the list of candidates.
	public static String[] getCandidates(Scanner console) {
		System.out.print("How many candidates (minimum of 2)? ");
		String[] candidatesList = new String[console.nextInt()];
		System.out.println();
		System.out.println("Please provide the first name of each candidate (with no duplicates).");
		// User provides the list of candidates. Case of letters will not matter later for voting.
		for(int i = 0; i < candidatesList.length; i++) {
			System.out.print("Candidate #" + (i + 1) + ": ");
			candidatesList[i] = console.next();
		}
		System.out.println();
		return candidatesList;
	}
	
	// Employs the user's responses to the provided console to collect votes for the provided list
	// of candidates. Case for letters does not matter for the user's responses, so long as the
	// name is a valid name for a candidate.
	// Returns the total number of votes for each candidate.
	public static Map<String, Integer> getVotes(Scanner console, String[] candidatesList) {
		Map<String, Integer> electionTally = createTally(candidatesList);
		System.out.print("How many voters? ");
		int numOfVoters = console.nextInt();	// Number of people who vote.
		
		for (int voterNum = 1; voterNum <= numOfVoters; voterNum++) {
			String votedFor = "";
			
			do { 	// Repeats until user provides a valid candidante's name.
				System.out.print("Vote #" + voterNum + " voted for: ");
				votedFor = console.next();
			} while(!electionTally.containsKey(votedFor));
			
			int votes = electionTally.get(votedFor) + 1;
			electionTally.put(votedFor,votes);
		}
		System.out.println();
		return electionTally;	// Count of all votes for each candidate.
	}

	// Uses the provided candidatesList to created and returns a map, with the candidates as the 
	// keys and the number of votes they've received (currently 0) as the values. 
	public static Map<String, Integer> createTally(String[] candidatesList) {
		Map<String, Integer> cadidates = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		for(String name : candidatesList) {
			cadidates.put(name,0);
		}
		return cadidates;
	}

	// Prints the election results from the provided electionResults.
	public static void printResults(Map<String, Integer> electionResults) {
		int highest = 0;
		String winner = "";
		System.out.println("ELECTION RESULTS....");
		System.out.println();
		System.out.println("Vote Summary:");
		for (String name : electionResults.keySet()) {
			// Print the results for each person
			System.out.println(name + " - " + electionResults.get(name) + " vote(s)");
			if (electionResults.get(name) > highest) {	// Selects winner
				winner = name;
				highest = electionResults.get(name);
			} else if (electionResults.get(name) == highest) {	// If there is a tie
				winner += (" and " + name);
			}
		}
		System.out.println();
		System.out.println("WINNER: " + winner + "!");
	}

	// Prints the welcome message.
	public static void introMessage() {
		System.out.println("Welcome to my election voting program.");
		System.out.println("Don't forget to take a sticker on the way out!");
		System.out.println();
	}

	// Prints the "I VOTED" sticker.
	public static void printSticker() {
		System.out.println("	   ________________");
		System.out.println("	  /                \\");
		System.out.println("	 /******************\\");
		System.out.println("	/          I         \\");
		System.out.println("	\\        VOTED	     /");
		System.out.println("	 \\******************/");
		System.out.println("	  \\________________/");
		System.out.println();
	}
	
}
