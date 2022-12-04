package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_3Key extends SuperObject {
	gamePanel gp;
	public OBJ_3Key(gamePanel gp) {
		this.gp = gp;
		name = "3rd Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Key3.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
	  }
}
