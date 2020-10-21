package com.company;

import javax.swing.*;

public class Main {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static void main(String[] args) {

        // Create window for game , set name ;
        JFrame window = new JFrame("MAMMA") ;
        window.setSize(WIDTH , HEIGHT);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new GamePanel());

        window.setVisible(true);
        window.setLocationRelativeTo(null);

	// write your code here
    }
}
