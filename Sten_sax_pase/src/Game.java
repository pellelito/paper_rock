import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	static int playerScore = 0;
	static int cpuScore = 0;

	public static void startGame() {
		boolean gameOn = true;

		System.out.println("Welcome let's play"); // Startar spelet med välkomst hälsning
		while (gameOn) {
			System.out.println("\nType Rock(1), Paper(2) or Scissors(3)(q) for quit");
			Scanner scanner = new Scanner(System.in);
			String playerChoice = scanner.nextLine().toUpperCase().replace(" ", ""); // Plockar bort ev mellanslag och
																						// omvandlar till uppercase på
																						// inmatning

			if (playerChoice.equals("Q")) { // Kollar om man valt att sluta
				System.out.println("\nGame exited");
				break;
			}
			if (playerChoice.equals("1")) {
				playerChoice = "ROCK";
			} // kollar omman valt att spela med siffror istället för text
			if (playerChoice.equals("2")) {
				playerChoice = "PAPER";
			}
			if (playerChoice.equals("3")) {
				playerChoice = "SCISSORS";
			}
			System.out.println("\nYou've chosen: " + playerChoice);
			if (playerChoice.equals("ROCK") || playerChoice.equals("PAPER") || playerChoice.equals("SCISSORS")) {
				generateOutcome(generateCPUChoice(), playerChoice); // genererar först datorns val testar sedan denna
																	// mot spelarens val
			} else {
				System.out.println("\nYour input was not valid."); // meddelar att man gjort felaktig inmatning
			}
		}
	}

	public static String generateCPUChoice() {
		int randomInt = ThreadLocalRandom.current().nextInt(1, 4); // slumpar ett tal mellan 1 & 3
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

	public static void generateOutcome(String cpuChoice, String playerChoice) { // kollar vem som vann eller om det
																				// blev oavgjort

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
