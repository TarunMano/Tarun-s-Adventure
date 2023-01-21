package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.gamePanel;
import main.wordGenerator;

public class incorrectLetter extends SuperObject {
	
	gamePanel gp;
	wordGenerator wGen = new wordGenerator(gp);
	
 
  public incorrectLetter(gamePanel gp) {
	  
	this.gp = gp;
	
	name = "incorrect";
	  int random;
	  String notLetter;
	  random = (int)(Math.random()*25-1)+1;
		for(char c: gp.wordSet) {
			if( c == wGen.Alphabet[random]) {
				random = (int)(Math.random()*25-1)+1;
			}
		}
		notLetter = String.valueOf(wGen.Alphabet[random]);
		
		

	
	try {
		image = ImageIO.read(getClass().getResourceAsStream("/objects/ALPHABET png/" + notLetter +".png"));
		uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		
	}catch(IOException e) {
		e.printStackTrace();
		}
		collision = true;
	
	
  }

}
