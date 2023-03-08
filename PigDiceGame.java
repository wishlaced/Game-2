import java.util.Scanner;
import java.util.Random;

public class PigDiceGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char userChoice;

        System.out.print("Enter your name: ");
        String name = scan.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        System.out.println("Hello, " + name + "! " + "Welcome to the Pig Game!");

        boolean selection = true;

        do {
            System.out.println("Do you want to start a new game? (Y/N): ");
            userChoice = scan.next().charAt(0);

            switch (userChoice) {
                case 'Y':
                    selection = true;
                    break;

                case 'N':
                    System.out.println("Bye for now :(");
                    System.exit(0);
                    break;

                default:
                    System.out.println("That is not a valid entry.");
            }

        } while (!(userChoice == 'Y' || userChoice == 'N'));
        System.out.println("Great!");

        new PigDiceGame();

    }
    Scanner playerName;
    private Scanner scanner;
    private Scanner scan;
    Boolean playerTurn = true;
    Boolean computerTurn = true;
    int dice;
    int playerScore, computerScore;
    int playerTotal = 0;
    int computerTotal = 0;

  

    public void roll() {
        dice = (int)(Math.random() * 6) + 1;
    }

    public int playerTurnScore() {
        {
            playerScore = dice + playerScore;
            System.out.println("you threw " + dice + "!");
            System.out.println("you have scored " + playerScore + "!");
        }
        return playerScore;
    }
    public void playerTurnZero() {
        playerScore = 0;
    }

    public int computerTurnScore() {
        {
            computerScore = dice + playerScore;
            System.out.println("computer has scored " + computerScore + ".");
        }
        return computerScore;
    }
    public void computerTurnZero() {
        computerScore = 0;
    }

    public PigDiceGame() {
        playerGame();
        if (!playerTurn) {
            computerTurn();
        }
    }
    public int playerGame() {

        System.out.println("to start the game, press [r].");
        scan = new Scanner(System.in);
        String start = scan.nextLine();
        if (!start.equalsIgnoreCase("R")) {
            System.out.println("please make sure you pressed [r].");
            playerGame();
        }

        if (start.equalsIgnoreCase("R")) {
            System.out.println("you pressed [r].");
            System.out.println("you may now roll. best of luck!");


            do {
                roll();


                if (dice == 1) {
                    System.out.println("you got 1 and you lost your turn.");
                    System.out.println("computer's total score is " + computerScore);
                    playerTurnZero();
                    computerTurn();

                } else if (dice != 1) {

                    playerScore += dice;
                    if ( playerScore >= 100) {
                        System.out.println("you threw " + dice);
                        System.out.println("your total score is " + playerScore);
                        System.out.println("congratulations, you win!");
                        System.exit(0);
                    }
                    playerTurnScore();
                    System.out.println("your total score is " + playerScore);
                    System.out.println("computer's total score is " + computerScore);
                    System.out.println("you can hold or roll again.");
                    System.out.println("to roll again press [r] or [h] to hold.");
                    scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("R")) {
                        System.out.println("You pressed 'r'.");
                        System.out.println("let's roll again!");
                        roll();

                        if (!choice.equalsIgnoreCase("R")) {
                            System.out.println("you didn't press [r]. in order to play the game smoothly, please press [r] to roll or [h] to hold.");
                            playerGame();
                        }
                    }

                    if (choice.equalsIgnoreCase("h")) {
                        System.out.println("you pressed [h] and lose your turn.");
                        System.out.println("your total is " + playerScore);
                        computerTurn();
                    }

                }

            } while (playerTurn);

        }
        return dice;
    }
    public int computerTurn() {
        System.out.println("now, it's the computer's turn.");

        do {
            roll();

            if (dice != 1) {
                computerScore += dice;
                if (computerScore >= 100) {
                    System.out.println("computer threw " + dice);
                    System.out.println("computer's total score is " + computerScore);
                    System.out.println("game over! computer wins");
                    System.exit(0);
                }
                System.out.println("computer threw: " + dice);
                System.out.println("computer's total score is " + computerScore);
                System.out.println("your total score is " + playerScore);
                computerTurnScore();
                roll();
            }

            if (dice == 1) {
                System.out.println("computer thrown 1! therefore, it's your turn now.");
                computerTurnZero();
                playerGame();
            }

            if (computerScore >= 100) {
                System.out.println("the computer scored already " + computerScore + "!");
                System.out.println("Game Over!");
                System.exit(0);
               
            }

        } while (computerTurn);
        return dice;
    }

}