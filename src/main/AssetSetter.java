package main;

import object.CorrectLetter1;
import object.CorrectLetter2;
import object.CorrectLetter3;
import object.CorrectLetter4;
import object.CorrectLetter5;
import object.incorrectLetter;



public class AssetSetter {
	
	gamePanel gp;
	
	public AssetSetter(gamePanel gp) {
		this.gp = gp;
	}
	
	

	public void setObject() {
		
		
		
		gp.obj[0] = new CorrectLetter1(gp);
		gp.obj[0].worldX = 2 * gp.tileSize;
		gp.obj[0].worldY = 16 * gp.tileSize;
		
		gp.obj[1] = new CorrectLetter2(gp);
		gp.obj[1].worldX = 45 * gp.tileSize;
		gp.obj[1].worldY = 2 * gp.tileSize;
		
		gp.obj[2] = new CorrectLetter3(gp);
		gp.obj[2].worldX = 58 * gp.tileSize;
		gp.obj[2].worldY = 3 * gp.tileSize;
		
		gp.obj[3] = new CorrectLetter4(gp);
		gp.obj[3].worldX = 2 * gp.tileSize;
		gp.obj[3].worldY = 27 * gp.tileSize;
		
		gp.obj[4] = new CorrectLetter5(gp);
		gp.obj[4].worldX = 62 * gp.tileSize;
		gp.obj[4].worldY = 28 * gp.tileSize;
		
		gp.obj[5] = new incorrectLetter(gp);
		gp.obj[5].worldX = 2 * gp.tileSize;
		gp.obj[5].worldY = 14 * gp.tileSize;
		
		gp.obj[6] = new incorrectLetter(gp);
		gp.obj[6].worldX = 54 * gp.tileSize;
		gp.obj[6].worldY = 3 * gp.tileSize;
		
		gp.obj[7] = new incorrectLetter(gp);
		gp.obj[7].worldX = 2 * gp.tileSize;
		gp.obj[7].worldY = 25 * gp.tileSize;
		
		gp.obj[8] = new incorrectLetter(gp);
		gp.obj[8].worldX = 62 * gp.tileSize;
		gp.obj[8].worldY = 30 * gp.tileSize;
		
		gp.obj[9] = new incorrectLetter(gp);
		gp.obj[9].worldX = 2 * gp.tileSize;
		gp.obj[9].worldY = 18 * gp.tileSize;
		
		gp.obj[10] = new incorrectLetter(gp);
		gp.obj[10].worldX = 56 * gp.tileSize;
		gp.obj[10].worldY = 3 * gp.tileSize;
		
		gp.obj[11] = new incorrectLetter(gp);
		gp.obj[11].worldX = 42 * gp.tileSize;
		gp.obj[11].worldY = 1 * gp.tileSize;
		
		
		
	
		
		
		
	}
	
	
}
