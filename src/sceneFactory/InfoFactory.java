package sceneFactory;

import controller.InfoController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.InfoView;
/**
 * functions as the client to build the scene on stage
 * @author Luer Lyu
 *
 */
public class InfoFactory extends SceneFactory {
	/**
	 * @param primaryStage pass the stage
	 */
	public InfoFactory(Stage primaryStage) {
		super(primaryStage);
	}

	/**
	 * build info sence onto the stage
	 */
	public void init() {
		InfoView infoView = new InfoView();
		InfoController infoControl = new InfoController(infoView);
		infoControl.bindButton(primaryStage);
		
		scene  = new Scene(infoView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
