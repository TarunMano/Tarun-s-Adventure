package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_Hood extends SuperObject {
	gamePanel gp;
public OBJ_Hood(gamePanel gp) {
	this.gp = gp;
		name = "Night Hood";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/nightHood.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
