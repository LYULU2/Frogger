package sceneFactory;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneFactory {
	public Stage primaryStage;
	Scene scene;
	public SceneFactory(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
