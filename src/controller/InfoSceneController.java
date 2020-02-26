package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.StartFactory;
import sceneView.InfoSceneView;

public class InfoSceneController {
	private TextButton back;
	InfoSceneView infoView;
	
	public InfoSceneController(InfoSceneView infoView) {
		this.infoView = infoView;
		this.back = infoView.getBack();
	}
	
	public void bindButton(Stage primaryStage) {
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				StartFactory start = new StartFactory(primaryStage);
				start.init();
			}
			
		});
	}
}
