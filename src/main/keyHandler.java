package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{ 
	
	gamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	//debug
	boolean checkDrawTime = false;
	
	public keyHandler(gamePanel gp ) {
		this.gp = gp;
	}

	  public void keyPressed(KeyEvent e){
	      int code = e.getKeyCode();
	      if(gp.gameState == gp.titleState) {
	    	  
	    	  if(gp.ui.titleState == 0) {
	    		  if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP){
	    			  gp.playSE(7);
			    	  gp.ui.numCommand--;
			    	 
		    		  if(gp.ui.numCommand < 0) {
		    			  gp.ui.numCommand = 3;
		    		  }
			    	  
		    	  }
			      if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN){
			    	  gp.playSE(7);
			    	  gp.ui.numCommand++;
			    
			    	  if(gp.ui.numCommand > 3) {
		    			  gp.ui.numCommand = 0;
		    		  }
			    	  
			      }
			      if(code == KeyEvent.VK_ENTER) {
			    	  gp.playSE(7);
			    	  if(gp.ui.numCommand == 0) {
			    		  gp.ui.titleState = 2;
			    	  }
			    	  if(gp.ui.numCommand == 1) {
			    		gp.ui.titleState = 1;
			    		  
			    	  }
			    	  if(gp.ui.numCommand == 2) {
				    		gp.ui.titleState = 3;
				    		  
				    	  }
			    	  if(gp.ui.numCommand == 3) {
			    		  System.exit(0);
			    		  
			    	  }
			    	  
			      }
	    	  }
	    	  else if(gp.ui.titleState == 2) {
	     		  if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP){
	     			 gp.playSE(7);
			    	  gp.ui.numCommand--;
			    
		    		  if(gp.ui.numCommand < 0) {
		    			  gp.ui.numCommand = 3;
		    		  }
			    	  
		    	  }
			      if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN){
			    	  gp.playSE(7);
			    	  gp.ui.numCommand++;
			    	 
			    	  if(gp.ui.numCommand > 3) {
		    			  gp.ui.numCommand = 0;
		    		  }
			    	  
			      }
			      if(code == KeyEvent.VK_ENTER) {
			    	  gp.playSE(7);
			    	  if(gp.ui.numCommand == 0) {
			    		  gp.playSE(7);
			    		  gp.stopMusic();
			    		  gp.playMusic(0);
			    		  gp.difficulty = 0;
			    		  gp.gameState = gp.playState;
			    		 
			    	  }
			    	  if(gp.ui.numCommand == 1) {
			    		  gp.playSE(7);
			    		  gp.stopMusic();
			    		  gp.playMusic(0);
			    		  gp.difficulty = 1;
			    		  gp.gameState = gp.playState;
			    		  
			    	  }
			    	  if(gp.ui.numCommand == 2) {
			    		  gp.stopMusic();
			    		  gp.playMusic(0);
			    		  gp.difficulty = 2;
			    		  gp.gameState = gp.playState;
			    		  
			    	  }
			    	  if(gp.ui.numCommand == 3) {
			    		  gp.playSE(7);
			    		  gp.ui.titleState = 0;
			    		  gp.ui.numCommand = 0;
			    	  }
			    	  gp.ui.showMessage(gp.word);
			    	  
			      }
	    	  }
	    	  else if(gp.ui.titleState == 1) {
	    		  if(code == KeyEvent.VK_ENTER) {
	    			  gp.playSE(7);
	    			  gp.ui.titleState = 0;
	    			  gp.ui.numCommand = 0;
	    		  }
	    	  }
	    	  else if(gp.ui.titleState == 3) {
	    		  if(code == KeyEvent.VK_ENTER) {
	    			  gp.playSE(7);
	    			  gp.ui.titleState = 0;
	    			  gp.ui.numCommand = 0;
	    		  }
	    	  }
	    	 
	      }
	      if(gp.gameState == gp.playState||gp.gameState == gp.pauseState) {
	    	   if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP){
	 	    	  upPressed = true;

	 	      }
	 	      if(code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT){
	 	    	  leftPressed = true;
	 	        
	 	      }
	 	      if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN){
	 	    	  downPressed = true;
	 	        
	 	      }
	 	      if(code == KeyEvent.VK_D|| code == KeyEvent.VK_RIGHT){
	 	    	  rightPressed = true;
	 	        
	 	      }
	 	      if(code == KeyEvent.VK_ESCAPE){
	 	    	  gp.pauseCount += 1;
	 	    	  if(gp.gameState == gp.playState) {
	 	    		  gp.gameState = gp.pauseState;
	 	    	  }
	 	    	  else if(gp.gameState == gp.pauseState) {
	 	    		  gp.gameState = gp.playState;
	 	    		  gp.resumeCount -= 1;
	 	    	
	 	    		  
	 	    	  }
	 	        
	 	      }
	      }
	   
	      //debug
	      if(code == KeyEvent.VK_T) {
	    	   if(checkDrawTime == false) {
	    		   checkDrawTime = true;
	    	   }
	    	   else if(checkDrawTime == true) {
	    		   checkDrawTime = false;
	    	   }
	      }
	  } 
	  public void keyReleased(KeyEvent e){
		  
		  int code = e.getKeyCode();
		  
		  if(code == KeyEvent.VK_W||code == KeyEvent.VK_UP){
	    	  upPressed = false;

	      }
	      if(code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT){
	    	  leftPressed = false;
	        
	      }
	      if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN){
	    	  downPressed = false;
	        
	      }
	      if(code == KeyEvent.VK_D||code == KeyEvent.VK_RIGHT){
	    	  rightPressed = false;
	        
	      }

	  }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		}

	}