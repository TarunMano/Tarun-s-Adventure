package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.Arrays;

public class UI {
	
	gamePanel gp;
	Graphics2D g2;
	Font pressStart_30, pressStart_60B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public boolean gameFinishedFail = false;
	public int numCommand = 0;
	public int titleState = 0; //0 = title, 1 = instructions, 2 = level difficulty
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(gamePanel gp) {
		this.gp = gp;
		
		pressStart_30 = new Font("Press Start 2P", Font.PLAIN, 30);
		pressStart_60B = new Font("Press Start 2P", Font.BOLD, 60);
	}
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(pressStart_30);
		g2.setColor(Color.white);
		//Title
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		//play
		if(gp.gameState == gp.playState && gameFinished == false) {
			
			playTime +=(double)1/60;
			g2.drawString(dFormat.format(playTime),gp.tileSize*12,50);
			
				
			
			
			
		}
		//Paused
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
			
		}
		
		if(gameFinished == true) { 
			
			
			g2.setFont(pressStart_30);
			g2.setColor(Color.yellow);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Congratulations";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 - (gp.tileSize*3);
			g2.drawString(text, x, y);
			
			g2.setFont(pressStart_30);
			g2.setColor(Color.white);
			text = "Time: "+dFormat.format(playTime);
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 + (gp.tileSize*3);
			g2.drawString(text, x, y);
			 
			g2.setFont(pressStart_60B);
			g2.setColor(Color.red);
			text = "YOU SURVIVED";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 - (gp.tileSize);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}
		else if(gameFinishedFail == true) {
			g2.setFont(pressStart_30);
			g2.setColor(Color.yellow);
			
			String text;
			int textLength;
			int x;
			int y;
			
			text = "Dissapointing...";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 - (gp.tileSize*3);
			g2.drawString(text, x, y);
			
			g2.setFont(pressStart_30);
			g2.setColor(Color.white);
			text = "Time: "+dFormat.format(playTime);
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 + (gp.tileSize*3);
			g2.drawString(text, x, y);
			 
			g2.setFont(pressStart_60B);
			g2.setColor(Color.red);
			text = "YOU FAILED";
			textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth/2 - textLength/2;
		    y = gp.screenLength/2 - (gp.tileSize);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}
		else {
			if(gp.gameState == gp.playState) {
				g2.setFont(pressStart_30);
				g2.setColor(Color.white);
				String wrd = gp.showWord[0] + gp.showWord[1] + gp.showWord[2] + gp.showWord[3] + gp.showWord[4] ;
				g2.drawString(wrd, 50, 50);	
			}
				
		
			
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(60F));
				g2.drawString(message, getCenterX(gp.word),gp.screenLength/2);
				
				messageCounter++;
				
				if(messageCounter > 75) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
		
	}
	public void drawTitleScreen() {
		
		if(titleState == 0) {
			g2.setColor(new Color(65,85,150));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenLength);
			//name
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
			String text = "Word Adventure";
			int x = getCenterX(text);
			int y = gp.tileSize*3;
			g2.setColor(Color.black);
			g2.drawString(text, x+4, y+4);
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//menu
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,25F));

			text = "START GAME";
			 x = getCenterX(text);
			 y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(numCommand == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Instructions";
			 x = getCenterX(text);
			 y += gp.tileSize;
			g2.drawString(text, x, y);
			if(numCommand == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			text = "Leaderboard";
			 x = getCenterX(text);
			 y += gp.tileSize;
			g2.drawString(text, x, y);
			if(numCommand == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Exit";
			 x = getCenterX(text);
			 y += gp.tileSize;
			g2.drawString(text, x, y);
			if(numCommand == 3) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "Tarun Manoharan & Aditya Naidu";
			 x = getCenterX(text);
			 y += gp.tileSize*2;
			g2.drawString(text, x, y);

		}
		else if(titleState == 2) {
			g2.setColor(new Color(65,85,150));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenLength);
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
			String text = "Choose your difficulty!";
			int x = getCenterX(text);
			int y = gp.tileSize*3;
			g2.setColor(Color.black);
			g2.drawString(text, x+4, y+4);
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//levels
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,25F));
			
			g2.setColor(Color.green);
			text = "Easy";
			 x = getCenterX(text);
			 y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(numCommand == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			g2.setColor(Color.yellow);
			text = "Medium";
			 x = getCenterX(text);
			 y += gp.tileSize;
			g2.drawString(text, x, y);
			if(numCommand == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			g2.setColor(Color.red);
			text = "Hard";
			 x = getCenterX(text);
			 y += gp.tileSize;
			g2.drawString(text, x, y);
			if(numCommand == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			g2.setColor(Color.white);
			text = "Back";
			 x = getCenterX(text);
			 y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(numCommand == 3) {
				g2.drawString(">", x-gp.tileSize, y);
			}
		
			
			
		}
		else if(titleState == 1) {
			g2.setColor(new Color(65,85,150));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenLength);
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
			String text = "Instructions";
			int x = getCenterX(text);
			int y = gp.tileSize;
			g2.setColor(Color.black);
			g2.drawString(text, x+4, y+4);
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			g2.setFont(g2.getFont().deriveFont(10F));
			text = "Use W,A,S,D to move around the map and find the letters ";
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			text = "to build the given word!";
			x = getCenterX(text);
			y+= gp.tileSize;
			g2.drawString(text, x, y);
			text = "The word is flashed in the beginning, so be sure to remember its spelling.";
			x = getCenterX(text);
			y+= gp.tileSize;
			g2.drawString(text, x, y);
			text = "If you pick up the wrong letter, the game is over.";
			x = getCenterX(text);
			y+= gp.tileSize;
			g2.drawString(text, x, y);
			text = "Explore the expansive map, but be quick—the timer is counting down!";
			x = getCenterX(text);
			y+= gp.tileSize;
			g2.drawString(text, x, y);
			
			g2.setColor(Color.yellow);
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "Click Enter to go Back!";
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			
			
		}
		else if(titleState == 3) {
			g2.setColor(new Color(65,85,150));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenLength);
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
			String text = "Leaderboard";
			int x = getCenterX(text);
			int y = gp.tileSize;
			g2.setColor(Color.black);
			g2.drawString(text, x+4, y+4);
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "1. " + gp.leader1;
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "2. " + gp.leader2;
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "3. " + gp.leader3;
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			
			g2.setColor(Color.yellow);
			g2.setFont(g2.getFont().deriveFont(15F));
			text = "Click Enter to go Back!";
			x = getCenterX(text);
			y+= gp.tileSize*2;
			g2.drawString(text, x, y);
			
			
		}
		
		
	}
	public void drawPauseScreen() {
		
		String text = "PAUSED";
		int x = getCenterX(text);
		
		int y = gp.screenLength/2;
		
		g2.drawString(text, x, y);
		g2.drawString(dFormat.format(playTime),gp.tileSize*12,50); 
		
		g2.setFont(g2.getFont().deriveFont(15F));
		 text = "ESC to quit|Enter to Resume";
		 x = getCenterX(text);
		 y += gp.tileSize*5;
		
		g2.drawString(text, x, y);
		
		
		
	}
	public int getCenterX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;

	}

}
