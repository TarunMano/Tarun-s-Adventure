package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;

public class CorrectLetter3 extends SuperObject {
	
	gamePanel gp;
 
  public CorrectLetter3(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "cL3";
	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ALPHABET png/" + gp.cL3 +".png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		
	
  }
}