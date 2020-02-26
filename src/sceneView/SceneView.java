package sceneView;

import application.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
/**
 * abstract class that defines the basic members share by all views
 * @author Luer Lyu
 *
 */
public abstract class SceneView {
	public AnimationTimer timer;
	public Scene scene;
	public MyStage background;
	
}
