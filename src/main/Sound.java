package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	long clipTime;
	gamePanel gp;
	URL soundUrl[] = new URL[30];
	
	
	public Sound() {
		soundUrl[0] = getClass().getResource("/sound/tarun'sAdventure.wav");
		soundUrl[1] = getClass().getResource("/sound/Key.wav");
		soundUrl[2] = getClass().getResource("/sound/door.wav");
		soundUrl[3] = getClass().getResource("/sound/mastKey.wav");
		soundUrl[4] = getClass().getResource("/sound/finaldoor.wav");
		soundUrl[5] = getClass().getResource("/sound/armor.wav");
		soundUrl[6] = getClass().getResource("/sound/Title.wav");
		soundUrl[7] = getClass().getResource("/sound/menuTick.wav");
	}
	
	
	
	public void setFile(int i) {
		
		try { 
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
		
	}
	public void play() {
		
		clip.start();
	}
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
	public void pause() {
		
		clipTime = clip.getMicrosecondPosition();
		clip.stop();
		
	}
	public void resume() {
		clip.setMicrosecondPosition(clipTime);
		clip.start();
	}
}
