//Tarun Manoharan
package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

class Main {


	  public static void main(String[]args) throws IOException {
	    

	    JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setResizable(false);
	    window.setTitle("Word Adventure - FBLA 2023");

	    gamePanel GamePanel = new gamePanel();
	    window.add(GamePanel);

	    window.pack();

	    window.setLocationRelativeTo(null);
	    window.setVisible(true);

	    
	    GamePanel.setupGame();
	    GamePanel.startGameThread();
	  }
	}