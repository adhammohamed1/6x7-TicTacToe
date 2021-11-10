package com.company;

import java.util.Random;

public class Game {

    public int numberOfTurns;


    // Template for the 6*7 game board
    public char[][] gameBoard = new char[6][7];


    // Constructor for game object
    public Game() {
        initGameBoard();
        numberOfTurns = 0;
    }


    // Initializer for the game board elements
    public void initGameBoard(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.gameBoard[i][j] = ' ';
            }
        }
    }


    // This method prints the game board and its elements
    public void printGameBoard(){

        int rowNumber=1;
        System.out.println("   1   2   3   4   5   6   7"); // Column numbers

        for (char [] row: this.gameBoard) {
            System.out.print(rowNumber++ + " ");
            int i=1;
            for (char elm: row) {
                if(elm=='X') System.out.print("\033[33;1m"); //Sets the color of the X to bold yellow
                if(elm=='O') System.out.print("\033[36;1m"); //Sets the color of the O to bold cyan
                System.out.print(" " + elm + " ");
                System.out.print("\033[0m"); // Resets to normal  colors
                if((i++)!=7) System.out.print("|");
            }
            if(rowNumber<7)System.out.println("\n  ---+---+---+---+---+---+---");
        }
        System.out.println("\n\n");
    }


    // This method determines players' symbols randomly
    public static void randomisePlayerSymbols(Player player1, Player player2){
        Random rand = new Random();
        int randNum = rand.nextInt(11); // Generate a random number between 0 - 10
        if(randNum % 2 != 0) { // if randNum is odd, Player 1 gets 'X'
            player1.setPlayerSymbol('X');
            player2.setPlayerSymbol('O');
        }
        else { // if radNum is even, Player 2 gets 'X'
            player1.setPlayerSymbol('O');
            player2.setPlayerSymbol('X');
        }
    }


    // This method checks if there is a winner
    public int checkForWinner(Player player1, Player player2){
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                // Victory by vertical alignment
                if(row <= 3){
                    if (this.gameBoard[row][column] == this.gameBoard[row + 1][column] && this.gameBoard[row + 1][column] == this.gameBoard[row + 2][column]) {
                        if (this.gameBoard[row][column] == player1.getPlayerSymbol()) return 1; // PLayer 1 is victorious
                        else if (this.gameBoard[row][column] == player2.getPlayerSymbol()) return 2; // Player 2 is victorious
                    }
                }

                // Victory by horizontal alignment
                if(column <= 4){
                    if (this.gameBoard[row][column] == this.gameBoard[row][column + 1] && this.gameBoard[row][column + 1] == this.gameBoard[row][column + 2]) {
                        if (this.gameBoard[row][column] == player1.getPlayerSymbol()) return 1; // Player 1 is victorious
                        else if (this.gameBoard[row][column] == player2.getPlayerSymbol()) return 2; // Player 2 is victorious
                    }
                }

                // Victory by left diagonal alignment
                if(column <= 4 && row <= 3){
                    if(this.gameBoard[row][column] == this.gameBoard[row + 1][column + 1] && this.gameBoard[row + 1][column + 1] == this.gameBoard[row + 2][column + 2]){
                        if(this.gameBoard[row][column] == player1.getPlayerSymbol()) return 1; // Player 1 is victorious
                        else if(this.gameBoard[row][column] == player2.getPlayerSymbol()) return 2; // Player 2 is victorious
                    }
                }

                // Victory by right diagonal alignment
                if(column >= 2 && row <= 3){
                    if(this.gameBoard[row][column] == this.gameBoard[row + 1][column - 1] && this.gameBoard[row+1][column-1] == this.gameBoard[row + 2][column - 2]) {
                        if (this.gameBoard[row][column] == player1.getPlayerSymbol()) return 1; // Player 1 is victorious
                        else if (this.gameBoard[row][column] == player2.getPlayerSymbol()) return 2; // Player 2 is victorious
                    }
                }
            }
        }
        return 0; // No winners
    }


    // This method refreshes the board for a new turn
    public void newTurn(){
        System.out.println("\n");
        this.printGameBoard();
    }
}
