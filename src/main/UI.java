package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {
	
	gamePanel gp;
	Graphics2D g2;
	Font pressStart_30, pressStart_60B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
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
		
		if(gp.gameState == gp.playState && gameFinished == false) {
			
			playTime +=(double)1/60;
			g2.drawString(dFormat.format(playTime),gp.tileSize*12,50); 
			
			
		}
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
		else {
			g2.setFont(pressStart_30);
			g2.setColor(Color.white);
			
			g2.drawString(gp.player.area + "-" + gp.player.level, 50, 50);
			
			//time
		
			
			if(messageOn == true) {
				
				g2.setFont(g2.getFont().deriveFont(20F));
				g2.drawString(message, gp.tileSize/2, gp.tileSize * 5);
				
				messageCounter++;
				
				if(messageCounter > 100) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}
		
	}
	public void drawPauseScreen() {
		
		String text = "PAUSED";
		int x = getCenterX(text);
		
		int y = gp.screenLength/2;
		
		g2.drawString(text, x, y);
		g2.drawString(dFormat.format(playTime),gp.tileSize*12,50); 
		
		
		
		
	}
	public int getCenterX(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;

	}

}
