package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.InfoFactory;
import sceneFactory.MainFactory1;
import sceneView.StartSceneView;

public class StartSceneController {
	private TextButton start;
	private TextButton info;
	
	public StartSceneController(StartSceneView startView) {
		start = startView.getStart();
		info = startView.getInfo();
	}
	
	public void bindButton(Stage primaryStage) {
		/*
		 * set control for play
		 */
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				MainFactory1 main = new MainFactory1(primaryStage);
				main.init();
			}
		});
		/*
		 * set control for info
		 */
		info.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//TODO
				InfoFactory info = new InfoFactory(primaryStage);
				info.init();
			}
			
		});
	}
	
}
