package entity;


import java.awt.Rectangle;
import java.util.Random;

import main.gamePanel;

public class NPC_OldMan1 extends Entity{

	public NPC_OldMan1(gamePanel gp) {
		super(gp);
		
		direction = "left";
		speed = 1;
		getImage();
		solidArea = new Rectangle();
		solidArea.x = 12;
		solidArea.y = 21;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 30;
		
	}
	public void getImage() {
		
		up1 = setup("/npc/oldManBack1");
		up2 = setup("/npc/oldManBack2");
		down1 = setup("/npc/oldManFront1");
		down2 = setup("/npc/oldManFront2");
		right1 = setup("/npc/oldManRight1");
		right2 = setup("/npc/oldManRight2");
		left1 = setup("/npc/oldManLeft1");
		left2 = setup("/npc/oldManLeft2");
		
	}
	public void setAction() {
		
		actionLookCounter++;
		System.out.println(actionLookCounter);
		
		if(actionLookCounter == 90) {
			direction = "down";
			}
		if(actionLookCounter == 180) {
			direction = "right";
			}
		if(actionLookCounter == 270) {
			direction = "up";
			}
		if(actionLookCounter == 360) {
			direction = "left";
			actionLookCounter = 0;
			}
				
					
		
	
	
  }
}
