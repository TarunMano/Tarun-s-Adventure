package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_5Key extends SuperObject {
	gamePanel gp;
	public OBJ_5Key(gamePanel gp) {
		this.gp = gp;
		name = "5th Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Key5.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
	  }
}
