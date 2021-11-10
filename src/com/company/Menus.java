package com.company;

import javax.swing.*;
import java.awt.BorderLayout;

public class Menus {

    // Game Logo
    static ImageIcon icon = new ImageIcon("boardlogo.jpg");

    // This method displays a welcome message at the start of the program
    public static void welcomeMessage(){

        JLabel logo = new JLabel(icon);
        JLabel text1 = new JLabel("              Welcome to 6x7 Tic Tac Toe !");
        JLabel text2 = new JLabel("                  Press OK to continue");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(text1, BorderLayout.NORTH);
        panel.add(logo, BorderLayout.CENTER);
        panel.add(text2, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, panel, "6x7 Tic Tac Toe!", JOptionPane.PLAIN_MESSAGE);
    }

    // This method displays an input dialog to take the player's name and send to the setter in class Player.
    public static void nameInputDialog(Player player1, Player player2) {

        for (int i = 1; i <= 2; i++) {
            JLabel logo = new JLabel(icon);
            JLabel text1 = new JLabel("                 Enter player " + i + "'s name");

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(text1, BorderLayout.CENTER);
            panel.add(logo, BorderLayout.NORTH);

            if(i==1)player1.setName(JOptionPane.showInputDialog(null, panel, "Player 1 name", JOptionPane.PLAIN_MESSAGE));
            if(i==2)player2.setName(JOptionPane.showInputDialog(null, panel, "Player 2 name", JOptionPane.PLAIN_MESSAGE));
        }
    }
}
