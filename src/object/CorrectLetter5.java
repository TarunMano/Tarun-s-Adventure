package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class CorrectLetter5 extends SuperObject {
	
	gamePanel gp;
 
  public CorrectLetter5(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "cL5";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ALPHABET png/" + gp.cL5 +".png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		collision = true;
	
  }
}