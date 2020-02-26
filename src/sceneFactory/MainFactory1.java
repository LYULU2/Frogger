package sceneFactory;

import controller.MainSceneController1;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneView.MainSceneView1;

public class MainFactory1 extends SceneFactory {

	public MainFactory1(Stage primaryStage) {
		super(primaryStage);
		// TODO Auto-generated constructor stub
	}
	public void init() {
		MainSceneView1 mainView = new MainSceneView1();
		MainSceneController1 mainControl = new MainSceneController1(mainView);
		mainControl.createScoreFactory(primaryStage);
		mainControl.createMainFactory(primaryStage);
		scene  = new Scene(mainView.getStage(),600,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		/*
		 * starts the game
		 */
		mainControl.start();
	}
}
