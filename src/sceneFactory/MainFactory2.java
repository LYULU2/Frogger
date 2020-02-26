package sceneFactory;

import controller.MainSceneController2;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.MainSceneView2;

public class MainFactory2 extends SceneFactory {

	public MainFactory2(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}
	public void init(int level, int[]prevScores,int scorePrev,boolean changeSong) {
		MainSceneView2 mainView = new MainSceneView2();
		mainView.passScore(scorePrev);
		MainSceneController2 mainControl = new MainSceneController2(mainView,changeSong);
		mainControl.createScoreFactory(primaryStage);
		// pass the parameter to the second level
		mainControl.level = level;
		mainControl.prevScores = prevScores;
		mainControl.scorePrev = scorePrev;
		scene  = new Scene(mainView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		/*
		 * starts the game
		 */
		mainControl.start();
	}

}
