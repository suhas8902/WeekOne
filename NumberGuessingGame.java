import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1; 
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;        
        System.out.println("Welcome to the Number Guessing Game !!!");
        System.out.println("I've selected a random number between " + lowerBound + " and " + upperBound + ". Try to guess it.");        
        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Your guess is out of range. Please guess between " + lowerBound + " and " + upperBound + ".");
            } else if (userGuess < numberToGuess) {
                System.out.println("Your guess is too low. Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number (" + numberToGuess + ") correctly in " + attempts + " attempts.");
                break;
            }
        }
        scanner.close();
        }
}