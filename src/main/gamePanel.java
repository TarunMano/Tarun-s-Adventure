package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class gamePanel extends JPanel implements Runnable{
    //Settings
    final int originalTileSize = 16; //32x32
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 64x64 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenLength = tileSize * maxScreenRow; //576 pixels
    
    
    //world settings
    
    public final int maxWorldCol = 64;
    public final int maxWorldRow = 36;
  
    //FPS
    int FPS = 60;
    
    
    TileManager tileM = new TileManager(this);
    keyHandler keyH = new keyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public collisionChecker cChecker = new collisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public wordGenerator wGen = new wordGenerator(this);
    Thread gameThread;
    
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[30];
    public Entity npc[] = new Entity[10];
    
    
    //gamesTATE
    public int gameState;
    public final int playState = 1;
    public final int titleState = 0;
    public final int pauseState = 2;
    public int pauseCount = 0;
    public int resumeCount = 1;
    
    // Word 
    public String word;
    public char[] wordSet = new char[5];
    public String cL1, cL2, cL3, cL4, cL5;
    
    
    //set player default position.

    public gamePanel() {

      this.setPreferredSize(new Dimension(screenWidth, screenLength));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
    }
    
    public void setupGame() throws FileNotFoundException {
    	
    	word = getWord();
    	wGen.wordSetter(word.toCharArray());
    	wGen.wordToImage();
    	aSetter.setObject();
    	playMusic(6);
    	gameState = titleState;
    	
    	
    }

    public void startGameThread(){
      gameThread = new Thread(this);
      gameThread.start();
    }

    public void run(){
    	
    	double drawInterval = 1000000000/FPS;
    	double delta = 0;
    	long lastTime = System.nanoTime();
    	long currentTime;
    	long timer = 0;
    	int drawCount = 0;
    	
    	while(gameThread != null) { 
    		currentTime = System.nanoTime();
    		delta += (currentTime - lastTime) / drawInterval;
    		timer += (currentTime - lastTime);
    		lastTime = currentTime;
    		
    		if(delta >= 1 ) {
    			update();
    			repaint();
    			delta--;
    			drawCount++;
    		}
    		
    		if(timer >= 1000000000) { 
    			System.out.println("FPS:"+drawCount);
    			drawCount = 0;
    			timer = 0;
    		}
    	}
    }
    
    public void update() {
    	
    	if(gameState == playState) {
    		//player
    		player.update();
    		//npc
    		for(int i = 0; i < npc.length; i++) {
    			if(npc[i] != null) {
    				npc[i].update();
    			}
    		}
    		if(resumeCount % 2 == 0) {
	    		if(pauseCount > 0 && pauseCount % 2 == 0) {
	    			music.resume();
	    			resumeCount += 1;
	    		}
    		}
    		
    	}
    	if(gameState == pauseState) {
    		//pause state stuff
    		pauseMusic();
    	}
    		
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      
      //debug
      long drawStart = 0;
      if(keyH.checkDrawTime == true) {
      drawStart = System.nanoTime();
      }
      
      //title Screen
      if(gameState == titleState) {
    	  ui.draw(g2);
      }
      else {
    	  tileM.draw(g2);
          //object
          for(int i = 0; i < obj.length; i++) {
        	  if(obj[i] != null) {
        		  obj[i].draw(g2, this);
        	  }
          }
          //npc
          for(int i = 0;i < npc.length;i++) {
        	  if(npc[i] != null) {
        		  npc[i].draw(g2);
        	  }
          }
          //player
          player.draw(g2);
          
          ui.draw(g2);
          if(keyH.checkDrawTime == true) {
          long drawEnd = System.nanoTime();
          long passed = drawEnd - drawStart;
          g2.setColor(Color.white);
          g2.drawString("Draw time: " + passed, 10, 400);
          System.out.println("Draw Time: " + passed);
          }
          g2.dispose();
      }
      
    }
    public void playMusic(int i) {
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    public void stopMusic() {
    	 music.stop();
    }
    public void playSE(int i) {
    	se.setFile(i);
    	se.play();
    }
    public void pauseMusic() {
    	if(pauseCount % 2 == 0) {
    		music.resume();
    		
    	}
    	else {
    		music.pause();
    	}
    }
    public String getWord() throws FileNotFoundException {
    	Scanner scan = new Scanner(new File("dictionary.txt"));
    	int lines = scan.nextInt();
    	int chosenLine = (int)(Math.random()*lines)+1;
    	System.out.println(chosenLine);
    	for(int i = 0; i< chosenLine; i++) {
    		scan.nextLine();
    	}
    	
    	return scan.nextLine();
    }
    
}





















