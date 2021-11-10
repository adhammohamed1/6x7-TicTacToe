package com.company;

public class Player {

    private String playerName;
    private char playerSymbol;
    public short gamesWon;


    // Constructor
    public Player(String name){
        setName(name);
        this.gamesWon = 0;
    }


    // Setter for the player's name.
    // If no name is entered, player names are set to Player 1 and/or Player 2 by default
    public void setName(String name) {
        if(name != null && !name.equals(""))
            this.playerName = name;
    }


    // Getter for the player's name
    public String getName() {
        return this.playerName;
    }


    // Setter for the player's symbol
    public void setPlayerSymbol(char symbol){
        this.playerSymbol = symbol;
    }


    // Getter for the player's symbol
    public char getPlayerSymbol(){
        return this.playerSymbol;
    }


    // Method that inserts the player's entry into the game board.
    // It returns true upon successful insertion and false if the cell is occupied.
    public boolean insertSymbol(Game game,int i, int j, char playerSymbol){
        if(game.gameBoard[i-1][j-1] == ' ') { // This condition checks if the player is inserting a symbol into an empty cell
            game.gameBoard[i-1][j-1] = playerSymbol;
            return true;
        }
        return false;
    }
}
