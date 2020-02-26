package sceneFactory;

import controller.StartSceneController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.StartSceneView;

public class StartFactory extends SceneFactory {
	
	public StartFactory(Stage primaryStage) {
		super(primaryStage);
	}

	public void init() {
		StartSceneView startView = new StartSceneView();

		StartSceneController startControl = new StartSceneController(startView);
		startControl.bindButton(primaryStage);
		
		scene  = new Scene(startView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
