package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.UtilityTool;
import main.gamePanel;
import main.keyHandler;

public class Player extends Entity{


	keyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	
	
	public Player(gamePanel gp, keyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2;
		screenY = gp.screenLength/2;
		
		solidArea = new Rectangle();
		solidArea.x = 12;
		solidArea.y = 21;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 30;
		
		
		
		setDefaultValues();
		getPlayerImage();
		
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 24 - (gp.tileSize/2);
		worldY = gp.tileSize * 18 - (gp.tileSize/2);
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
	
		up1 = setup("/player/PlayerBack1");
		up2 = setup("/player/PlayerBack2");
		down1 = setup("/player/PlayerFront1");
		down2 = setup("/player/PlayerFront2");
		right1 = setup("/player/PlayerRight1");
		right2 = setup("/player/PlayerRight2");
		left1 = setup("/player/PlayerLeft1");
		left2 = setup("/player/PlayerLeft2");
		
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed || 
					keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = "up";
	    		
	    	}
	    	else if(keyH.downPressed == true ) {
	    		direction = "down";
	    		
	    	}
	    	else if(keyH.leftPressed == true ) {
	    		direction = "left";	
	    	}
	    	else if(keyH.rightPressed == true ) {
	    		direction = "right";
	    		
	    	}	
			
			//checkTile collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//npc collision
		
		
			
			//if collision is false player doesn't move
			if(collisionOn == false) {
				
				
				switch(direction ) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
					
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum =2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
				
			}
		}
		
		
		
	}
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "cL1":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.showWord[0] = gp.cL1;
				gp.gameEnd++;
				
				break;
		
			case "cL2":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.showWord[1] = gp.cL2;
				gp.gameEnd++;
				
				break;
			
			case "cL3":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.showWord[2] = gp.cL3;
				gp.gameEnd++;
				
				break;
			case "cL4":
				gp.playSE(1);
				
					gp.obj[i] = null;
					gp.showWord[3] = gp.cL4;
					gp.gameEnd++;
				
				
				break;
			case "cL5":
				gp.playSE(1);
				gp.obj[i] = null;
				gp.gameEnd++;
				gp.showWord[4] = gp.cL5;
				
				break;
			
			
			}
			
		}
		
	}
	
	
	
	
	

	
	
	
	
	public void draw(Graphics2D g2) {
	   
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1 ) {
				image = up1;
			}
			if(spriteNum == 2 ) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1 ) {
				image = down1;
			}
			if(spriteNum == 2 ) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1 ) {
				image = left1;
			}
			if(spriteNum == 2 ) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1 ) {
				image = right1;
			}
			if(spriteNum == 2 ) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY,  null);
		
		
	}
}
