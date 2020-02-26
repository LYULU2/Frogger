package controller;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import sceneFactory.MainFactory2;
import sceneView.MainSceneView1;

public class MainSceneController1 extends MainSceneController {

	MainFactory2 main;
	boolean changeSong = false;
	public MainSceneController1(MainSceneView1 mainSceneView) {
		super(mainSceneView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(animal.playSound()&&(!changeSong)) {
            		background.playMusic("music/FroggerThemeSong2.mp3",true);
            		changeSong = true;
            	}
            	/*
            	 * score changes
            	 */
            	if (animal.changeScore()) {
            		//update highest score
            		updateNumber(animal.getPoints());
            		//update the 
            		digit_s = printNumber(150,yPosScore,animal.getPoints(),digit_s);
            	}
            	/*
            	 * # of lives changes
            	 */
            	if (animal.changeLives()) {
            		updateLives();
            	}
            	/*
            	 * wins
            	 */
            	if (animal.win()) {
            		background.stopMusic();
            		stop();
            		updateLives();
            		background.stop();
            		main.init(level, prevScores,animal.getPoints(),changeSong);
            	}
            	if(animal.lose()) {
            		background.stopMusic();
            		stop();
            		background.stop();
            		insertScore();
            		/*
            		 * write score to the file
            		 */
            		try {
						writeScore();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		scoreFactory.init(animal.getPoints(),false);
            	}
            }
        };
    }
	public void createMainFactory(Stage primaryStage) {
		main = new MainFactory2(primaryStage);
	}
}
