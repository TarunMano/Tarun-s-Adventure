package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_areaChecker22 extends SuperObject {
	gamePanel gp;
public OBJ_areaChecker22(gamePanel gp) {
	this.gp = gp;
		name = "areaChecker22";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = false;
	}
	

}
