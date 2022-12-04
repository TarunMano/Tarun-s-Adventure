package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_5Door extends SuperObject {
	gamePanel gp;
	public OBJ_5Door(gamePanel gp) {
		this.gp = gp;
		name = "5th Door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Door5.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
		collision = true;
	  }
}
