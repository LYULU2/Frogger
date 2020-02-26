package sceneFactory;

import controller.ScoreController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.ScoreView;
/**
 * functions as the client to build the scene on stage
 * @author Luer Lyu
 *
 */
public class ScoreFactory extends SceneFactory {

	/**
	 * @param primaryStage pass the stage
	 */
	public ScoreFactory(Stage primaryStage) {
		super(primaryStage);
	}

	/**
	 * build the score scene onto the stage
	 * @param score int pass the current score
	 * @param multi true if there are multiple players
	 */
	public void init(int score,boolean multi) {
		ScoreView view = new ScoreView();
		ScoreController scoreControl = new ScoreController(view);
		scoreControl.bindButton(primaryStage);
		scoreControl.multi = multi;
		view.printCurrentScore(score);
		scene  = new Scene(view.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
