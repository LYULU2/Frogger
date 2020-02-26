package models;

import javafx.scene.image.Image;
/**
 * represents the crocdiles that moves in the water, can used to change song in controller
 * @author Luer Lyu
 *
 */
public class WaterCroc extends DynamicDefault{
	/**
	 * set the image for croc in water
	 * @param size int height and width
	 * @param xpos x position
	 * @param ypos y position
	 * @param s double representing speed
	 */
	public WaterCroc( int size, int xpos, int ypos, double s) {
		setImage(new Image("file:img/waterCroc.png", size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		xForwardBound = 600;
		xBackwardBound = -300;
		xForwardPos = -180;
		xBackwardPos = 700;
	}

}
