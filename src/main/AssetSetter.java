package main;

import object.CorrectLetter1;
import object.CorrectLetter2;
import object.CorrectLetter3;
import object.CorrectLetter4;
import object.CorrectLetter5;
import object.OBJ_2Door;

import object.OBJ_3Door;
import object.OBJ_3Key;
import object.OBJ_5Door;
import object.OBJ_5Key;
import object.OBJ_Armor;
import object.OBJ_Boots;

import object.OBJ_Hood;
import object.OBJ_MasKey;


public class AssetSetter {
	
	gamePanel gp;
	
	public AssetSetter(gamePanel gp) {
		this.gp = gp;
	}
	
	

	public void setObject() {
		
		gp.obj[0] = new CorrectLetter4(gp);
		gp.obj[0].worldX = 2 * gp.tileSize;
		gp.obj[0].worldY = 26 * gp.tileSize;
		
		
		
		gp.obj[1] = new CorrectLetter1(gp);
		gp.obj[1].worldX = 2 * gp.tileSize;
		gp.obj[1].worldY = 16 * gp.tileSize;
		
//		gp.obj[2] = new OBJ_2Door(gp);
//		gp.obj[2].worldX = 32 * gp.tileSize;
//		gp.obj[2].worldY = 10 * gp.tileSize;
//		
//		gp.obj[3] = new OBJ_3Door(gp);
//		gp.obj[3].worldX = 23 * gp.tileSize;
//		gp.obj[3].worldY = 24 * gp.tileSize;
		
		gp.obj[4] = new CorrectLetter2(gp);
		gp.obj[4].worldX = 45 * gp.tileSize;
		gp.obj[4].worldY = 2 * gp.tileSize;
		
//		gp.obj[5] = new OBJ_5Door(gp);
//		gp.obj[5].worldX = 6  * gp.tileSize;
//		gp.obj[5].worldY = 23 * gp.tileSize;
		
		gp.obj[6] = new CorrectLetter5(gp);
		gp.obj[6].worldX = 62 * gp.tileSize;
		gp.obj[6].worldY = 30 * gp.tileSize;
		
		gp.obj[7] = new CorrectLetter3(gp);
		gp.obj[7].worldX = 43 * gp.tileSize;
		gp.obj[7].worldY = 2 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Armor(gp);
		gp.obj[8].worldX = 62 * gp.tileSize;
		gp.obj[8].worldY = 28 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Hood(gp);
		gp.obj[9].worldX = 2 * gp.tileSize;
		gp.obj[9].worldY = 27 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Hood(gp);
		gp.obj[10].worldX = 2 * gp.tileSize;
		gp.obj[10].worldY = 27 * gp.tileSize;
		
		
		
	}
	
	
}
