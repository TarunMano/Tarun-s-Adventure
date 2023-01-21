package main;

public class wordGenerator {

	gamePanel gp;
	public final char[] Alphabet;
	
	public wordGenerator(gamePanel gp) {
		this.gp = gp;
		Alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
	}
	
	public void wordSetter(char[] wordArray) {
		for(int i = 0; i < wordArray.length;i++) {
			char c = wordArray[i];
			for(int j = 0; j < Alphabet.length; j++) {
				if(c == Alphabet[j]) {
					gp.wordSet[i] = c;
				}
			}
		}
	
	}
	public void wordToImage() {
		gp.cL1 = String.valueOf(gp.wordSet[0]);
		System.out.println("letter" + gp.cL1);
		gp.cL2 = String.valueOf(gp.wordSet[1]);
		gp.cL3 = String.valueOf(gp.wordSet[2]);
		gp.cL4 = String.valueOf(gp.wordSet[3]);
		gp.cL5 = String.valueOf(gp.wordSet[4]);
	}
}
