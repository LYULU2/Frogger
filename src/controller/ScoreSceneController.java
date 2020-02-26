package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.MainFactory1;
import sceneFactory.StartFactory;
import sceneView.ScoreSceneView;

public class ScoreSceneController {
	private TextButton start;
	private TextButton back;
	public ScoreSceneController(ScoreSceneView score) {
		this.start = score.getStart();
		this.back = score.getBack();
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
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//TODO
				StartFactory start = new StartFactory(primaryStage);
				start.init();
			}
			
		});
		
	}
}
