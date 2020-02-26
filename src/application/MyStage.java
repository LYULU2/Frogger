package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * user-defined pane used for this game
 * @author Luer Lyu
 *
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	/**
	 * change the status of the game
	 * @param now current time in milli-seconds
	 */
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
	}
	/**
	 * plays the music
	 * @param musicFile the string of the path to the music file
	 * @param multi true for playing multiple times, false for one time play
	 */
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
	/**
	 * stops the music that is currently playing
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
