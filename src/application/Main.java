package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import sceneFactory.StartFactory;

public class Main extends Application {
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