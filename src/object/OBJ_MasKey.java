package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_MasKey extends SuperObject {
	gamePanel gp;
	public OBJ_MasKey(gamePanel gp) {
		this.gp = gp;
		name = "Master Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/masterKey.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
