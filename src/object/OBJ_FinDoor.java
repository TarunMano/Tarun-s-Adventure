package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_FinDoor extends SuperObject {
	gamePanel gp;
public OBJ_FinDoor(gamePanel gp) {
	this.gp = gp;
		name = "Dungeon Door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/dungeonDoor.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
