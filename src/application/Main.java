package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import sceneFactory.StartFactory;
/**
 * Main class thats starts the whole program
 * @author Luer Lyu
 *
 */
public class Main extends Application {
	/**
	 * starts building the first scene of the application
	 * @param primaryStage the stage used
	 * @throws Exception if the scene cannot be built on the stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			StartFactory start = new StartFactory(primaryStage);
			start.init();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}