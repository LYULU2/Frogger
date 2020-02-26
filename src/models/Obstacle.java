package models;

import javafx.scene.image.Image;
/**
 * represent car objects on the highway
 * @author Luer Lyu
 *
 */
public class Obstacle extends DynamicDefault {
	/**
	 * set the image for obstacle
	 * @param imageLink string contains the path to the image
	 * @param xpos x position
	 * @param ypos y position
	 * @param s double representing the moving speed
	 * @param w int representing width
	 * @param h int representing height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		xForwardBound = 600;
		xBackwardBound = -50;
		xForwardPos = -200;
		xBackwardPos = 600;
	}

}
