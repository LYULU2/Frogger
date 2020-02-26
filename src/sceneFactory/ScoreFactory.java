package sceneFactory;

import controller.ScoreSceneController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.ScoreSceneView;

public class ScoreFactory extends SceneFactory {

	public ScoreFactory(Stage primaryStage) {
		super(primaryStage);
	}

	public void init(int score, boolean win) {
		ScoreSceneView scoreView = new ScoreSceneView(win);
		ScoreSceneController scoreControl = new ScoreSceneController(scoreView);
		scoreControl.bindButton(primaryStage);
		scoreView.printCurrentScore(score);
		scene  = new Scene(scoreView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
