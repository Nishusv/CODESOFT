import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    private static final int MAX_ATTTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do{
            playGame(scanner);
            System.out.print("Do you want to play? (YES/NO):");
            String response = scanner.next(); 
            playAgain = response.equalsIgnoreCase("yes");
        }while(playAgain);

        System.out.println("Thank you for playing! Your final score is: ");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game ");
        System.out.println("I have selected a number between "+ RANGE_MIN + " and " + RANGE_MAX + " . ");
        System.out.println("You have " + MAX_ATTTEMPTS + " attemps to guess the Number. ");

        while (attempts < MAX_ATTTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < RANGE_MIN || userGuess > RANGE_MAX){
                System.out.println("please guess a number within the range of " + RANGE_MIN + " to " + RANGE_MAX + ".");
            }else if (userGuess < numberToGuess) {
                System.out.println("Too Low! Try again.");
            }else if (userGuess> numberToGuess){
                System.out.println("Too high! Try again.");
            }else {
                hasGuessedCorrectly = true;
                System.out.println("CONGRATS! You've guessed the number correctly " + numberToGuess + " in " + attempts + " attemps. ");
                score += (MAX_ATTTEMPTS - attempts + 1);
            }
        }

        if (!hasGuessedCorrectly){
            System.out.println("Sorry, you've used all your attempts. the number was " + numberToGuess + ".");
        }
    }
}