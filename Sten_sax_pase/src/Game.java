import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	static int playerScore = 0;
	static int cpuScore = 0;

	public static void startGame() {
		boolean gameOn = true;

		// Startar spelet med välkomst hälsning
		System.out.println("Welcome let's play");
		while (gameOn) {
			System.out.println("\nType Rock(1), Paper(2) or Scissors(3)(q) for quit");
			Scanner scanner = new Scanner(System.in);
			// Plockar bort ev mellanslag och omvandlar till uppercase inmatning
			String playerChoice = scanner.nextLine().toUpperCase().replace(" ", "");

			// Kollar om man valt att sluta
			if (playerChoice.equals("Q")) {
				System.out.println("\nGame exited");
				break;
			} // kollar omman valt att spela med siffror istället för text
			if (playerChoice.equals("1")) {
				playerChoice = "ROCK";
			}
			if (playerChoice.equals("2")) {
				playerChoice = "PAPER";
			}
			if (playerChoice.equals("3")) {
				playerChoice = "SCISSORS";
			}
			// genererar först datorns val testar sedan denna mot spelarens val
			System.out.println("\nYou've chosen: " + playerChoice);
			if (playerChoice.equals("ROCK") || playerChoice.equals("PAPER") || playerChoice.equals("SCISSORS")) {
				generateOutcome(generateCPUChoice(), playerChoice);

				// meddelar att man gjort felaktig inmatning
			} else {
				System.out.println("\nYour input was not valid.");
			}
		}
	}

	// slumpar ett tal mellan 1 & 3
	public static String generateCPUChoice() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 4);
		String cpuChoice = null;

		switch (randomInt) {
		case 1:
			cpuChoice = "ROCK";
			break;
		case 2:
			cpuChoice = "PAPER";
			break;
		case 3:
			cpuChoice = "SCISSORS";
			break;
		}
		return cpuChoice;
	}

	// kollar vem som vann eller om det blev oavgjort
	public static void generateOutcome(String cpuChoice, String playerChoice) {

		System.out.println("CPU chose: " + cpuChoice);
		if (cpuChoice.equals(playerChoice)) {
			System.out.println("It's a draw");
			System.out.println("Your score: " + playerScore + "		CPU score: " + cpuScore);
		} else {
			boolean playerWon = false;
			if (cpuChoice.equals("ROCK")) {
				if (playerChoice.equals("PAPER"))
					playerWon = true;
				else
					playerWon = false;
			} else if (cpuChoice.equals("PAPER")) {
				if (playerChoice.equals("SCISSORS"))
					playerWon = true;
				else
					playerWon = false;
			} else if (cpuChoice.equals("SCISSORS")) {
				if (playerChoice.equals("ROCK"))
					playerWon = true;
				else
					playerWon = false;
			}
			if (playerWon) {
				System.out.println("\nYOU WIN!");
				playerScore++;
				System.out.println("Your score: " + playerScore + "		CPU score: " + cpuScore);
			} else {
				System.out.println("\nYOU LOSE!");
				cpuScore++;
				System.out.println("Your score: " + playerScore + "		CPU score: " + cpuScore);
			}
		}
	}
}
