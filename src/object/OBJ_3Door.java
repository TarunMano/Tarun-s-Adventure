package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_3Door extends SuperObject {
	gamePanel gp;
	public OBJ_3Door(gamePanel gp) {
		this.gp = gp;
		name = "3rd Door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Door3.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
		collision = true;
	  }

}
