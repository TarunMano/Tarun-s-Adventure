package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class CorrectLetter1 extends SuperObject {
	
	gamePanel gp;
 
  public CorrectLetter1(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "cL1";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ALPHABET png/" + gp.cL1 +".png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		collision = true;
	
  }
}
