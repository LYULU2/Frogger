package sceneView;

import application.MyStage;
import models.BackgroundImage;
import models.TextButton;

public class StartSceneView extends SceneView{
	private TextButton start;
	private TextButton info;
	public StartSceneView() {
		background = new MyStage();
		BackgroundImage bkdg = new BackgroundImage("file:img/startbkgd.png");
		start = new TextButton("file:img/play.png",140,450,80);
		info = new TextButton("file:img/info.png",140,520,80);
		background.add(bkdg);
		background.add(start);
		background.add(info);
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
}
