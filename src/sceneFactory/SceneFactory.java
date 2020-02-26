package sceneFactory;

import controller.Controller;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.SceneView;
/**
 * abstract class
 * set the common members for concrete classes
 * save the primary stage as its member
 * @author Luer Lyu
 *
 */
public abstract class SceneFactory {
	public Stage primaryStage;
	Scene scene;
	SceneView view;
	Controller control;
	/**
	 * @param primaryStage pass the stage
	 */
	public SceneFactory(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
