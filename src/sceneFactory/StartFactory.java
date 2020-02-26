package sceneFactory;

import controller.StartController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.StartView;
/**
 * functions as the client to build the scene on stage
 * @author Luer Lyu
 *
 */
public class StartFactory extends SceneFactory {
	/**
	 * @param primaryStage pass the stage
	 */
	public StartFactory(Stage primaryStage) {
		super(primaryStage);
	}

	/**
	 * build the start scene onto the stage
	 */
	public void init() {
		StartView startView = new StartView();

		StartController startControl = new StartController(startView);
		startControl.bindButton(primaryStage);
		
		scene  = new Scene(startView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
