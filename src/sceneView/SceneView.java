package sceneView;

import application.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneView {
	public AnimationTimer timer;
	public Scene scene;
	public MyStage background;
	
	public void build(Stage primaryStage) {};
}
