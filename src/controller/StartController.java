package controller;

import application.MyStage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.TextButton;
import sceneFactory.InfoFactory;
import sceneFactory.MainFactory1;
import sceneView.StartView;
/**
 * defines controls for the start scene
 * @author Luer Lyu
 *
 */
public class StartController extends Controller{
	private TextButton start;
	private TextButton info;
	private TextButton numberOfPlayer;
	private MyStage background;
	private TextButton frog;
	private TextButton action;
	private TextButton frogB;
	private TextButton actionB;
	boolean multi;
	/**
	 * constructor for the controller
	 * @param startView which set the view
	 */
	public StartController(StartView startView) {
		start = startView.getStart();
		info = startView.getInfo();
		numberOfPlayer = startView.getNumber();
		this.background = startView.getBackground();
		this.frog = startView.getfrog();
		this.action = startView.getAction();
		this.frogB = startView.getfrogB();
		this.actionB = startView.getActionB();
		multi = false;
	}
	/**
	 * bind the buttons to the functions that set different scenes
	 * for three buttons: start, info, numberOfPlayer
	 * also change the pattern when mouse enters and exits
	 * also enable user to click to change the number of users
	 * @param primaryStage the stage used to display the scene
	 */
	public void bindButton(Stage primaryStage) {
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				MainFactory1 main = new MainFactory1(primaryStage);
				main.init(multi);// pass true if there will be 2 players
			}
		});
		setAnimationStart();
		info.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//TODO
				InfoFactory info = new InfoFactory(primaryStage);
				info.init();
			}
			
		});
		setAnimationInfo();
		setAnimationMulti();
	}
	/**
	 * set button animation for start button
	 */
	public void setAnimationStart() {
		start.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				start.changeImage("file:img/play2.png",250,285,80);
			}
			
		});
		start.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				start.changeImage("file:img/play.png",250,280,80);
			}
			
		});
	}
	/**
	 * set the button animation for the info button
	 */
	public void setAnimationInfo() {
		info.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				info.changeImage("file:img/info2.png",248,340,80);
			}
			
		});
		info.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				info.changeImage("file:img/info.png",248,340,80);
			}
			
		});
	}
	/**
	 * set the actions for the multiplayer button
	 */
	public void setAnimationMulti() {
		numberOfPlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setMultiImage();
			}
		});
		numberOfPlayer.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(multi) {
					numberOfPlayer.changeImage("file:img/player2.png",220,220,145);
				}else {
					numberOfPlayer.changeImage("file:img/player1.png",220,220,145);
				}
				
			}
		});
		numberOfPlayer.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(multi) {
					numberOfPlayer.changeImage("file:img/player2.png",220,220,140);
				}else {
					numberOfPlayer.changeImage("file:img/player1.png",220,220,140);
				}
				
			}
		});
	}
	/**
	 * check for the current state of mutiplayer
	 */
	public void setMultiImage() {
		if(multi) {
			numberOfPlayer.changeImage("file:img/player1.png",220,220,140);
			multi = false;
			background.remove(frogB);
			background.remove(actionB);
			frog.changePos(280, 600);
			action.changePos(250, 500);
		}else {
			numberOfPlayer.changeImage("file:img/player2.png",220,220,140);
			multi = true;
			background.add(frogB);
			background.add(actionB);
			frog.changePos(200, 600);
			action.changePos(150,500);
		}
	}
}
