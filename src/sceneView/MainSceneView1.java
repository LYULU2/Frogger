package sceneView;

import models.Digit;
import models.WaterCroc;

public class MainSceneView1 extends MainSceneView {

	public MainSceneView1() {
		background.add(new WaterCroc(100, -130, 166, 0.75));
		background.add(new Digit(0, 30, 150, yPosScore));
	}

}
