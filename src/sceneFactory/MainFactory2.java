package sceneFactory;

import controller.MainController2;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.MainView2;
/**
 * functions as the client to build the scene on stage
 * @author Luer Lyu
 *
 */
public class MainFactory2 extends SceneFactory {

	/**
	 * @param primaryStage pass the stage
	 */
	public MainFactory2(Stage primaryStage) {
		super(primaryStage);
	}
	/**
	 * build the level 2 scene onto the stage
	 * @param level int representing number of rounds in level 1
	 * @param prevScores int array of containing scores in level1
	 * @param changeSong boolean if true change the song, false not
	 * @param multi true if there are multiple players
	 */
	public void init(int level, int[]prevScores,boolean changeSong,boolean multi) {
		MainView2 mainView = new MainView2();
		MainController2 mainControl = new MainController2(mainView,changeSong);
		mainControl.createScoreFactory(primaryStage);
		mainControl.addFrog(multi);
		// pass the parameter to the second level
		mainControl.level = level;
		mainControl.prevScores = prevScores;
		scene  = new Scene(mainView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		mainControl.start();
	}

}
