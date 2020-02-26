package controller;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import models.Animal;
import models.CrocEnd;
import sceneView.MainView2;
/**
 * deinfes extra controls for level 2 game
 * @author Luer Lyu
 *
 */
public class MainController2 extends MainController {

	ArrayList<CrocEnd> crocs;
	
	int[] check = new int [5];
	boolean changeSong;
	/**
	 * constructor
	 * @param mainSceneView pass the SceneView to get the models from the scene
	 * @param changeSong true if the song has been changed in level 1, false otherwise
	 */
	public MainController2(MainView2 mainSceneView,boolean changeSong) {
		super(mainSceneView);
		this.crocs = mainSceneView.getCrocs();
		this.changeSong = changeSong;
		// records the points from before
		this.scorePrev = Animal.getPoints();
		updateNumber(scorePrev);
	}
	/**
	 * set the music, create and start the timer
	 */
	@Override
	public void start() {
		if(changeSong) {
			background.playMusic("music/FroggerThemeSong2.mp3",true);
		}
		else {
			background.playMusic("music/FroggerMainSong.mp3",true);
		}
    	createTimer();
        timer.start();
	}
	/**
	 * create a timer and check for update of the game status
	 */
	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	//score changes
            	if (frog1.changeScore()||frog2.changeScore()) {
            		//update highest score
            		updateNumber(Animal.getPoints());
            		digit_s = printNumber(150,yPosScore,Animal.getPoints(),digit_s);
            	}
            	//# of lives changes
            	if (frog1.changeLives()||frog2.changeLives()) {
            		updateLives();
            	}
            	checkEnd();
            }
        };
    }
	/**
	 * check if it's the end of the game
	 */
	public void checkEnd() {
    	if (frog1.win()||frog1.lose()) {
    		background.stopMusic();
    		stop();
    		background.stop();
    		NamePrompt();
    	}
	}
}
