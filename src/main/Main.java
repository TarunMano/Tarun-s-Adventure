//Tarun Manoharan
package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

class Main {


	  public static void main(String[]args) throws FileNotFoundException {
	    

	    JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setResizable(false);
	    window.setTitle("2D Game");

	    gamePanel GamePanel = new gamePanel();
	    window.add(GamePanel);

	    window.pack();

	    window.setLocationRelativeTo(null);
	    window.setVisible(true);

	    
	    GamePanel.setupGame();
	    GamePanel.startGameThread();
	  }
	}