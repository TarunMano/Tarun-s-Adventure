package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class CorrectLetter2 extends SuperObject {
	
	gamePanel gp;
 
  public CorrectLetter2(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "cL2";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ALPHABET png/" + gp.cL2 +".png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		collision = true;
	
  }
}