import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3; // Number of rounds
        int maxAttempts = 5; // Attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + " of " + maxRounds);
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess;

                // Validate user input
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Your guess must be between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int pointsEarned = attemptsLeft + 1; // More attempts left means higher score
                    totalScore += pointsEarned;
                    System.out.println("Congratulations! You've guessed the number.");
                    System.out.println("You earned " + pointsEarned + " points this round.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (!hasGuessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame over! Your total score is " + totalScore + " points.");
        scanner.close();
    }
}
