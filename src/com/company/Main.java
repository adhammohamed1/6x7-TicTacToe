package com.company;


import java.util.Scanner;

public class Main {

    /*
     *
     *  Participants:
     *  1. Adham Mohamed Aly     -      6744
     *  2. Abdelrahman el Attar  -      6841
     *
     */

    public static void main(String[] args) {

        // Construct players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // GUI welcome menu
        Menus.welcomeMessage();
        Menus.nameInputDialog(player1, player2);

        while(true) {
            Game game = new Game(); // Create new game
            Game.randomisePlayerSymbols(player1, player2); // Assign a symbol to every player randomly
            gameSession(game, player1, player2); // Launch a game session

            // Show the score of every player (Games won for each)
            System.out.print("\033[0m"); // Reset text colors
            System.out.println("----------------------------------");
            System.out.println(player1.getName() + ": " + player1.gamesWon);
            System.out.println(player2.getName() + ": " + player2.gamesWon);
            System.out.println("----------------------------------");

            while(true){
                System.out.println("Press Enter to start a new game or enter \"exit\" to quit");

                Scanner scanner = new Scanner(System.in);
                String strInput = scanner.nextLine();

                if(strInput.equals("exit")) { // User entered the word exit
                    System.out.println("\nBye Now :)");
                    System.exit(0);
                }
                else if(strInput.equals("")) break; // User pressed enter
            }
        }
    }


    // This method checks whether the player input is valid or not
    // coordinate represents row or column
    public static boolean invalidCharInput(char input, String coordinate) {

        if(Character.isDigit(input)){
            int digit = input - '0';
            if(coordinate.equals("column")) return digit < 0 || digit > 7;
            else if(coordinate.equals("row")) return digit < 0 || digit > 6;
        }
        return true;
    }


    // This method  launches a whole game session
    public static void gameSession(Game game, Player player1, Player player2){

        int turn = 1;

        while(true){

            Scanner scanner = new Scanner(System.in);
            game.newTurn();

            int verdict = game.checkForWinner(player1, player2);
            if(verdict == 1){ // Player 1 is victorious
                System.out.println("\033[32m" + player1.getName() + " has won!");
                player1.gamesWon++;
                break;
            }
            else if(verdict == 2){ // Player 2 is victorious
                System.out.println("\033[32m" + player2.getName() + " has won!");
                player2.gamesWon++;
                break;
            }
            else if(turn > 42){ // Game ended with no winners
                System.out.println("\033[33m The game is a draw! \033[0m");
                break;
            }

            // PLayer 1 plays in odd turns while player 2 plays in even ones.
            System.out.print("\033[35;1m"); // Change text color to bold magenta then \033[0m resets to default colors
            if(turn % 2 != 0) System.out.println(player1.getName() + "\033[0m's turn.");
            else System.out.println(player2.getName() + "\033[0m's turn.");

            System.out.print("Enter the  row and column for the cell you wish to choose.\n");
            int row, column;

            System.out.print("Row: ");
            String strInput = scanner.next();
            char charInput = strInput.charAt(0);

            if(strInput.length() > 1 || invalidCharInput(charInput, "row")) {
                System.out.println("\n\033[31m <!> Invalid Entry \033[0m");
                continue;
            }
            else row = charInput - '0'; // Convert from character to integer

            System.out.print("Column: ");
            strInput = scanner.next();
            charInput = strInput.charAt(0);

            if(strInput.length() > 1 || invalidCharInput(charInput, "column")) {
                System.out.println("\n\033[31m <!> Invalid Entry \033[0m");
                continue;
            }
            else column = charInput - '0'; // Convert from character to integer

            // PLayer 1 plays in odd turns while player 2 plays in even ones.
            if(turn % 2 != 0) {
                if (!player1.insertSymbol(game, row, column, player1.getPlayerSymbol())) continue;
            }
            else {
                if (!player2.insertSymbol(game, row, column, player2.getPlayerSymbol())) continue;
            }

            turn++; // Move to the next turn
        }
    }
}
