package sceneFactory;

import controller.InfoSceneController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.InfoSceneView;

public class InfoFactory extends SceneFactory {
	public InfoFactory(Stage primaryStage) {
		super(primaryStage);
	}

	public void init() {
		InfoSceneView infoView = new InfoSceneView();
		InfoSceneController infoControl = new InfoSceneController(infoView);
		infoControl.bindButton(primaryStage);
		
		scene  = new Scene(infoView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
