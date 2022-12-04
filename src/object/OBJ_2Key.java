package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_2Key extends SuperObject{
	gamePanel gp;
	public OBJ_2Key(gamePanel gp) {
		this.gp = gp;
		name = "2nd Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Key2.png.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
			}
	  }
	}

