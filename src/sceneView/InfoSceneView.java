package sceneView;

import application.MyStage;
import models.BackgroundImage;
import models.TextButton;

public class InfoSceneView extends SceneView{
	private TextButton back;
	
	public InfoSceneView() {
		background = new MyStage();
		
		BackgroundImage bkgd = new BackgroundImage("file:img/infobkgd.png");
		background.add(bkgd);
		back = new TextButton("file:img/goback.png",140,700,80);
		background.add(back);
	}
	public MyStage getStage() {
		return background;
	}
	public TextButton getBack() {
		return back;
	}
}
