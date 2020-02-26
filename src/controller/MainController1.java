package controller;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;
import models.Animal;
import sceneFactory.MainFactory2;
import sceneView.MainView1;
/**
 * add extra controls for the level 1 game
 * @author Luer Lyu
 *
 */
public class MainController1 extends MainController {

	MainFactory2 main;
	boolean changeSong = false;
	public MainController1(MainView1 mainSceneView) {
		super(mainSceneView);
	}
	
	/**
	 * create the timer for the game
	 * track the status in every frame and make changes
	 */
	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if((frog1.playSound()||frog2.playSound())&&(!changeSong)) {
            		background.playMusic("music/FroggerThemeSong2.mp3",true);
            		changeSong = true;
            	}
            	//score changes
            	if (frog1.changeScore()||frog2.changeScore()) {
            		//update highest score
            		updateNumber(Animal.getPoints());
            		//update the 
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
	 * check if game have reached end
	 */
	public void checkEnd() {
		// wins
    	if (frog1.win()) {
    		background.stopMusic();
    		stop();
    		updateLives();
    		background.stop();
    		main.init(level, prevScores,changeSong,multi);
    	}
    	// loses
    	if(frog1.lose()) {
    		background.stopMusic();
    		stop();
    		background.stop();
    		NamePrompt();
    	}
	}
	/**
	 * instantiate the factory to build the level 2 scene
	 * @param primaryStage the stage used to display the scene
	 */
	public void createMainFactory(Stage primaryStage) {
		main = new MainFactory2(primaryStage);
	}
}
