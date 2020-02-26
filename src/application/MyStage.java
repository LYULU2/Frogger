package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
	}
	
	public void playMusic(String musicFile,boolean multi) {
		if(mediaPlayer!=null) {
			mediaPlayer.stop();
		}
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		if(multi) {
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		}else {
			mediaPlayer.setCycleCount(1);
		}
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
