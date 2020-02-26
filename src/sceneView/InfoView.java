package sceneView;

import application.MyStage;
import models.BackgroundImage;
import models.TextButton;
/**
 * set the view for information class
 * @author Luer Lyu
 *
 */
public class InfoView extends SceneView{
	private TextButton back;
	/**
	 * set the view for information scene
	 */
	public InfoView() {
		background = new MyStage();
		
		BackgroundImage bkgd = new BackgroundImage("file:img/infobkgd.png");
		background.add(bkgd);
		back = new TextButton("file:img/goback2.png",140,700,80);
		background.add(back);
	}
	public MyStage getStage() {
		return background;
	}
	public TextButton getBack() {
		return back;
	}
}
