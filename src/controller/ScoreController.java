package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.MainFactory1;
import sceneFactory.StartFactory;
import sceneView.ScoreView;
/**
 * defines controls for score scene
 * @author Luer Lyu
 *
 */
public class ScoreController extends Controller{
	private TextButton start;
	private TextButton back;
	public boolean multi;
	/**
	 * constructor for the controller
	 * @param score sceneView class that sets the view
	 */
	public ScoreController(ScoreView score) {
		this.start = score.getStart();
		this.back = score.getBack();
	}
	/**
	 * bind the buttons to the functions that set different scenes
	 * @param primaryStage the stage used to display the scene
	 */
	public void bindButton(Stage primaryStage) {
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				MainFactory1 main = new MainFactory1(primaryStage);
				main.init(multi);
			}
		});
		SetButtonAnimationStart();
		back.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//TODO
				StartFactory start = new StartFactory(primaryStage);
				start.init();
			}
			
		});
		setButtonAnimationBack();
	}
	public void SetButtonAnimationStart() {
		start.setOnMouseEntered(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				start.changeImage("file:img/playAgain2.png",260,720,200);
			}
			
		});
		start.setOnMouseExited(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				start.changeImage("file:img/playAgain.png",260,720,180);
			}
			
		});
	}
	/**
	 * set the animation for the back button
	 */
	public void setButtonAnimationBack() {
		back.setOnMouseEntered(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				back.changeImage("file:img/goback1.png",140,720,80);
			}
			
		});
		back.setOnMouseExited(new EventHandler<MouseEvent>() {

			/**
			 * change the scene to another one
			 * @param event the mouse action
			 */
			@Override
			public void handle(MouseEvent event) {
				back.changeImage("file:img/goback2.png",140,720,80);
			}
			
		});
	}
}
