package sceneFactory;

import controller.MainController1;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.MainView1;
/**
 * functions as the client to build the scene on stage
 * @author Luer Lyu
 *
 */
public class MainFactory1 extends SceneFactory {

	/**
	 * @param primaryStage pass the stage
	 */
	public MainFactory1(Stage primaryStage) {
		super(primaryStage);
	}
	/**
	 * build main scene onto the stage
	 * @param multi true if there are multiple players
	 */
	public void init(boolean multi) {
		MainView1 mainView = new MainView1();
		MainController1 mainControl = new MainController1(mainView);
		mainControl.createScoreFactory(primaryStage);
		mainControl.createMainFactory(primaryStage);
		mainControl.addFrog(multi);
		scene  = new Scene(mainView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		mainControl.start();
	}
}
