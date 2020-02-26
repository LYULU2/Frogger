package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.StartFactory;
import sceneView.InfoView;
/**
 * class that controls the information scene
 * @author Luer Lyu
 *
 */
public class InfoController extends Controller {
	private TextButton back;
	InfoView infoView;
	/**
	 * gets the models from the view
	 * @param infoView the view class which decides the look of the scene
	 */
	public InfoController(InfoView infoView) {
		this.infoView = infoView;
		this.back = infoView.getBack();
	}
	/**
	 * bound the buttons with certain functions
	 * @param primaryStage the stage used to create scene
	 */
	public void bindButton(Stage primaryStage) {
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				StartFactory start = new StartFactory(primaryStage);
				start.init();
			}
		});
		buttonAnimation();
		
	}
	/**
	 * set actions for button
	 */
	public void buttonAnimation() {
		back.setOnMouseEntered(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				back.changeImage("file:img/goback1.png",140,700,80);
			}
			
		});
		back.setOnMouseExited(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				back.changeImage("file:img/goback2.png",140,700,80);
			}
			
		});
	}
}
