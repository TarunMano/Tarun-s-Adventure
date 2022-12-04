package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_Armor extends SuperObject {
	gamePanel gp;
public OBJ_Armor(gamePanel gp) {
	this.gp = gp;
		name = "Night Armor";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/nightArmor.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
