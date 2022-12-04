package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_areaChecker21 extends SuperObject {
	gamePanel gp;
public OBJ_areaChecker21(gamePanel gp) {
	this.gp = gp;
		name = "areaChecker21";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = false;
	}
	

}
