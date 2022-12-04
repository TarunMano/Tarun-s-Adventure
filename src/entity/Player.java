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
	public int hasKey2 = 1;
	int hasKey3 = 1;
	int hasKey5 = 1;
	int hasKeyF = 1;
	int hasBoot = 0;
	int hasArmor = 0;
	int hasHood = 0;
	int dunDoor = 1;
	public int area = 1;
	public int level = 1;
	
	
	
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
		speed = 6;
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
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
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
			case "2nd Key":
				gp.playSE(1);
				hasKey2++;
				gp.obj[i] = null;
				gp.ui.showMessage("You found a key!");
				break;
			case "2nd Door":
				gp.playSE(2);
				if(hasKey2 > 0) { 
					gp.obj[i] = null;
					hasKey2--;
					gp.ui.showMessage("The door has been opened!");
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				break;
			case "3rd Key":
				gp.playSE(1);
				hasKey3++;
				gp.obj[i] = null;
				gp.ui.showMessage("You found a key!");
				break;
			case "3rd Door":
				gp.playSE(2);
				if(hasKey3 > 0) { 
					gp.obj[i] = null;
					hasKey3--;gp.ui.showMessage("The door has been opened!");
				}
				else if(hasKey3 < 1 && (hasKey2 > 0)) {
					gp.ui.showMessage("The key doesn't fit!");
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				break;
			case "5th Key":
				gp.playSE(1);
				hasKey5++;
				gp.obj[i] = null;
				gp.ui.showMessage("You found a key!");
				break;
			case "5th Door":
				gp.playSE(2);
				if(hasKey5 > 0) { 
					gp.obj[i] = null;
					hasKey5--;gp.ui.showMessage("The door has been opened!");
				}
				else if(hasKey5 < 1 && (hasKey2 > 0||hasKey3 > 0)) {
					gp.ui.showMessage("The key doesn't fit!");
				}
				else {
					gp.ui.showMessage("You need a key!");
				}
				break;
			case "Master Key":
				gp.playSE(3);
				hasKeyF++;
				gp.obj[i] = null;
				gp.ui.showMessage("A chill crawls down your spine.");
				break;
			case "Dungeon Door":
				if(hasKeyF > 0) { 
					gp.ui.gameFinished = true;
					gp.stopMusic();
					gp.playSE(1);
//					gp.playSE(4);
//					gp.obj[i] = null;
//					hasKeyF--;
//					dunDoor--;
//					speed = 0;
//					gp.ui.showMessage("Welcome to your doom.");
				}
				else if(hasKeyF < 1 && (hasKey2 > 0||hasKey3 > 0||hasKey5 > 0)) {
					gp.playSE(2);
					gp.ui.showMessage("The key doesn't fit!");
				}
				else {
					gp.playSE(2);
					gp.ui.showMessage("You need a key!");
				}
				
				break;
			case "Night Boots":
				gp.playSE(5);
				gp.obj[i] = null;
				hasBoot = 1;
				if(hasBoot > 0) {	
				
					up1 = setup("/player/playerBootsBack1");
					up2 = setup("/player/playerBootsBack2");
					down1 = setup("/player/playerBootsFront1");
					down2 = setup("/player/playerBootsFront2");
					right1 = setup("/player/playerBootsRight1");
					right2 = setup("/player/playerBootsRight2");
					left1 = setup("/player/playerBootsLeft1");
					left2 = setup("/player/playerBootsLeft2");
			}
				ArmorCheck();
				break;
			
			case "Night Armor":
				gp.playSE(5);
				gp.obj[i] = null;
				hasArmor = 1;
				if(hasArmor > 0) {
					up1 = setup("/player/playerArmorBack1");
					up2 = setup("/player/playerArmorBack2");
					down1 = setup("/player/playerArmorFront1");
					down2 = setup("/player/playerArmorFront2");
					right1 = setup("/player/playerArmorRight1");
					right2 = setup("/player/playerArmorRight2");
					left1 = setup("/player/playerArmorLeft1");
					left2 = setup("/player/playerArmorLeft2");
				}
				
				ArmorCheck();
				break;
			case "Night Hood":
				gp.playSE(5);
				gp.obj[i] = null;
				hasHood = 1;
				if(hasHood > 0) {
				
					up1 = setup("/player/playerHoodBack1");
					up2 = setup("/player/playerHoodBack2");
					down1 = setup("/player/playerHoodFront1");
					down2 = setup("/player/playerHoodFront2");
					right1 = setup("/player/playerHoodRight1");
					right2 = setup("/player/playerHoodRight2");
					left1 = setup("/player/playerHoodLeft1");
					left2 = setup("/player/playerHoodLeft2");
				}
				ArmorCheck();
				break;
			case "areaChecker31":
				area = 3;
				level = 1;
				break;
			case "areaChecker22":
				area = 2;
				level = 2;
				break;
			case "areaChecker42":
				area = 4;
				level = 2;
				break;
			case "areaChecker11":
				area = 1;
				level = 1;
				break;
			case "areaChecker51":
				area = 5;
				level = 1;
				break;
			case "areaChecker41":
				area = 4;
				level = 1;
				break;
			case "areaChecker21":
				area = 2;
				level = 1;
				break;
			}
			
		}
		
	}
	
	public void ArmorCheck() {
		if(hasArmor > 0 && hasBoot > 0 && hasHood < 1) {
			up1 = setup("/player/playerAbBack1");
			up2 = setup("/player/playerAbBack2");
			down1 = setup("/player/playerAbFront1png");
			down2 = setup("/player/playerAbFront2");
			right1 = setup("/player/playerAbRight1");
			right2 = setup("/player/playerAbRight2");
			left1 = setup("/player/playerAbLeft1");
			left2 = setup("/player/playerAbLeft2");
			System.out.println("armor check");
			
		}
		else if(hasArmor > 0 && hasBoot > 0 && hasHood > 0) {
			speed += 3;
			up1 = setup("/player/playerFullBack1");
			up2 = setup("/player/playerFullBack2");
			down1 = setup("/player/playerFullFront1");
			down2 = setup("/player/playerFullFront2");
			right1 = setup("/player/playerFullRight1");
			right2 = setup("/player/playerFullRight2");
			left1 = setup("/player/playerFullLeft1");
			left2 = setup("/player/playerFullLeft2");
			System.out.println("armor check");
			
		}
	}
	public void interactNPC(int i) {
		
		if(i != 999) {
			System.out.println("you are hitting npc");
		}
	}
	
//	public void areaChange(int i) {
//		if(i != 999) {
//			int index   = gp.obj[i];
//			
//			switch(index) {
//			case 1:
//			
//				break;
//			}
//		}
//	}
	
	
	
	
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
