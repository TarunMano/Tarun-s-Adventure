package main;

import entity.NPC_OldMan1;
import object.OBJ_2Door;
import object.OBJ_2Key;
import object.OBJ_3Door;
import object.OBJ_3Key;
import object.OBJ_5Door;
import object.OBJ_5Key;
import object.OBJ_Armor;
import object.OBJ_Boots;
import object.OBJ_FinDoor;
import object.OBJ_Hood;
import object.OBJ_MasKey;
import object.OBJ_areaChecker11;
import object.OBJ_areaChecker21;
import object.OBJ_areaChecker22;
import object.OBJ_areaChecker31;
import object.OBJ_areaChecker41;
import object.OBJ_areaChecker42;
import object.OBJ_areaChecker51;

public class AssetSetter {
	
	gamePanel gp;
	
	public AssetSetter(gamePanel gp) {
		this.gp = gp;
	}
	
	

	public void setObject() {
		
		gp.obj[0] = new OBJ_MasKey(gp);
		gp.obj[0].worldX = 2 * gp.tileSize;
		gp.obj[0].worldY = 26 * gp.tileSize;
		
		gp.obj[1] = new OBJ_FinDoor(gp);
		gp.obj[1].worldX = 56 * gp.tileSize;
		gp.obj[1].worldY = 13 * gp.tileSize;
		
		gp.obj[2] = new OBJ_2Key(gp);
		gp.obj[2].worldX = 2 * gp.tileSize;
		gp.obj[2].worldY = 16 * gp.tileSize;
		
		gp.obj[3] = new OBJ_2Door(gp);
		gp.obj[3].worldX = 32 * gp.tileSize;
		gp.obj[3].worldY = 10 * gp.tileSize;
		
		gp.obj[4] = new OBJ_3Door(gp);
		gp.obj[4].worldX = 23 * gp.tileSize;
		gp.obj[4].worldY = 24 * gp.tileSize;
		
		gp.obj[5] = new OBJ_3Key(gp);
		gp.obj[5].worldX = 45 * gp.tileSize;
		gp.obj[5].worldY = 2 * gp.tileSize;
		
		gp.obj[6] = new OBJ_5Door(gp);
		gp.obj[6].worldX = 6  * gp.tileSize;
		gp.obj[6].worldY = 23 * gp.tileSize;
		
		gp.obj[7] = new OBJ_5Key(gp);
		gp.obj[7].worldX = 62 * gp.tileSize;
		gp.obj[7].worldY = 30 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Boots(gp);
		gp.obj[11].worldX = 43 * gp.tileSize;
		gp.obj[11].worldY = 2 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Armor(gp);
		gp.obj[12].worldX = 62 * gp.tileSize;
		gp.obj[12].worldY = 28 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Hood(gp);
		gp.obj[13].worldX = 2 * gp.tileSize;
		gp.obj[13].worldY = 27 * gp.tileSize;
		
		gp.obj[13] = new OBJ_Hood(gp);
		gp.obj[13].worldX = 2 * gp.tileSize;
		gp.obj[13].worldY = 27 * gp.tileSize;
		
		gp.obj[14] = new OBJ_areaChecker31(gp);
		gp.obj[14].worldX = 23 * gp.tileSize;
		gp.obj[14].worldY = 25 * gp.tileSize;
		
		gp.obj[15] = new OBJ_areaChecker22(gp);
		gp.obj[15].worldX = 33 * gp.tileSize;
		gp.obj[15].worldY = 10 * gp.tileSize;
		
		gp.obj[8] = new OBJ_areaChecker42(gp);
		gp.obj[8].worldX = 6 * gp.tileSize;
		gp.obj[8].worldY = 24 * gp.tileSize;
		
		gp.obj[9] = new OBJ_areaChecker11(gp);
		gp.obj[9].worldX = 23 * gp.tileSize;
		gp.obj[9].worldY = 22 * gp.tileSize;
		
		gp.obj[10] = new OBJ_areaChecker11(gp);
		gp.obj[10].worldX = 31 * gp.tileSize;
		gp.obj[10].worldY = 18 * gp.tileSize;
		
		gp.obj[28] = new OBJ_areaChecker11(gp);
		gp.obj[28].worldX = 31 * gp.tileSize;
		gp.obj[28].worldY = 17 * gp.tileSize;
		
		gp.obj[16] = new OBJ_areaChecker51(gp);
		gp.obj[16].worldY = 17 * gp.tileSize;
		
		gp.obj[17] = new OBJ_areaChecker51(gp);
		gp.obj[17].worldX = 32 * gp.tileSize;
		gp.obj[17].worldY = 18 * gp.tileSize;
		
		gp.obj[18] = new OBJ_areaChecker11(gp);
		gp.obj[18].worldX = 17 * gp.tileSize;
		gp.obj[18].worldY = 17 * gp.tileSize;
		
		gp.obj[19] = new OBJ_areaChecker11(gp);
		gp.obj[19].worldX = 17 * gp.tileSize;
		gp.obj[19].worldY = 18 * gp.tileSize;
		
		gp.obj[20] = new OBJ_areaChecker41(gp);
		gp.obj[20].worldX = 16 * gp.tileSize;
		gp.obj[20].worldY = 18 * gp.tileSize;
		
		gp.obj[21] = new OBJ_areaChecker41(gp);
		gp.obj[21].worldX = 16 * gp.tileSize;
		gp.obj[21].worldY = 17 * gp.tileSize;
		
		gp.obj[22] = new OBJ_areaChecker21(gp);
		gp.obj[22].worldX = 24 * gp.tileSize;
		gp.obj[22].worldY = 12 * gp.tileSize;
		
		gp.obj[23] = new OBJ_areaChecker21(gp);
		gp.obj[23].worldX = 23 * gp.tileSize;
		gp.obj[23].worldY = 12 * gp.tileSize;
		
		gp.obj[24] = new OBJ_areaChecker11(gp);
		gp.obj[24].worldX = 23 * gp.tileSize;
		gp.obj[24].worldY = 13 * gp.tileSize;
		
		gp.obj[25] = new OBJ_areaChecker11(gp);
		gp.obj[25].worldX = 24 * gp.tileSize;
		gp.obj[25].worldY = 13 * gp.tileSize;
		
		gp.obj[26] = new OBJ_areaChecker41(gp);
		gp.obj[26].worldX = 6 * gp.tileSize;
		gp.obj[26].worldY = 21 * gp.tileSize;
		
		gp.obj[27] = new OBJ_areaChecker21(gp);
		gp.obj[27].worldX = 30 * gp.tileSize;
		gp.obj[27].worldY = 10 * gp.tileSize;
		
		
	}
	public void setNPC() {
		gp.npc[0] = new NPC_OldMan1(gp);
		gp.npc[0].worldX = gp.tileSize*46;
		gp.npc[0].worldY = gp.tileSize*5;
	}
	
}
