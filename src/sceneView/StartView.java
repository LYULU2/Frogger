package sceneView;

import application.MyStage;
import models.BackgroundImage;
import models.TextButton;
/**
 * set the view for the start scene
 * @author Luer Lyu
 *
 */
public class StartView extends SceneView{
	private TextButton start;
	private TextButton info;
	private TextButton numberOfPlayer;
	private TextButton frog;
	private TextButton action;
	private TextButton frogB;
	private TextButton actionB;
	/**
	 * set the view
	 */
	public StartView() {
		background = new MyStage();
		BackgroundImage bkdg = new BackgroundImage("file:img/iKogsKW.png");
		start = new TextButton("file:img/play.png",250,280,80);
		info = new TextButton("file:img/info.png",248,340,80);
		numberOfPlayer = new TextButton("file:img/player1.png",220,220,140);
		frog = new TextButton("file:img/FroggerUp.png",280,600,45);
		frogB = new TextButton("file:img/FroggerUpB.png",340,605,40);
		action = new TextButton("file:img/wasd.png",250,500,100);
		actionB = new TextButton("file:img/urld.png",340,500,100);
		background.add(bkdg);
		background.add(numberOfPlayer);
		background.add(start);
		background.add(info);
		background.add(frog);
		background.add(action);
		background.start();
	}
	
	public MyStage getStage() {
		return background;
	}
	
	public TextButton getStart() {
		return start;
	}
	
	public TextButton getInfo() {
		return info;
	}
	public TextButton getNumber() {
		return numberOfPlayer;
	}
	
	public MyStage getBackground() {
		return background;
	}
	public TextButton getfrogB() {
		return frogB;
	}
	public TextButton getActionB() {
		return actionB;
	}
	public TextButton getfrog() {
		return frog;
	}
	public TextButton getAction() {
		return action;
	}
}
