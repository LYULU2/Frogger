package models;

import javafx.scene.image.Image;
/**
 * class represents snake object
 * @author Luer Lyu
 *
 */
public class Snake extends DynamicDefault {

	Image snake1;
	Image snake2;
	/**
	 * override the method to change the picture
	 * for every frame
	 */
	@Override
	public void act(long now) {

		if (now/900000000  % 2 ==0) {
			setImage(snake2);
		}
		else if (now/900000000 % 2 == 1) {
			setImage(snake1);
		}
		super.act(now);
	}
	/**
	 * constructor for snakes 
	 * @param xpos int x position
	 * @param ypos int y position
	 * @param s double speed
	 * @param w width for the snake object
	 * @param h height for snake object
	 */
	public Snake(int xpos, int ypos, double s, int w, int h) {
		snake1 = new Image("file:img/snake1.png", w, h, true, true);
		snake2 = new Image("file:img/snake2.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(snake1);
		xForwardBound = 600;
		xBackwardBound = -50;
		xForwardPos = -180;
		xBackwardPos = 700;
	}

}
