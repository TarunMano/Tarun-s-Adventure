package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class OBJ_2Door extends SuperObject {
	
	gamePanel gp;
 
  public OBJ_2Door(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "2nd Door";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/Door2.png.png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		collision = true;
	
  }
}


