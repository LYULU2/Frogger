package models;

import javafx.scene.image.Image;
/**
 * represents the logs moving in the water
 * @author Luer Lyu
 *
 */
public class Log extends DynamicDefault {

	/**
	 * set the image of log
	 * @param imageLink string contains the path for the image
	 * @param size the width and the height
	 * @param xpos x position
	 * @param ypos y position
	 * @param s double represents the speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		xForwardBound = 600;
		xBackwardBound = -300;
		xForwardPos = -180;
		xBackwardPos = 700;
	}
	/**
	 * get the direction of the movement of log
	 * @return true if the log moves to the left, false otherwise
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
