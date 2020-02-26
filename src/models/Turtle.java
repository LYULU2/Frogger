package models;

import javafx.scene.image.Image;
/**
 * represent the turtle objects that won't turn their bodies in the water
 * @author Luer Lyu
 *
 */
public class Turtle extends DynamicDefault{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	boolean bool = true;
	/**
	 * set the position of the actor in every frame
	 * @param now long number representing current time in milli seconds
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
				super.act(now);
	}
	/**
	 * set the image for Turtle
	 * @param xpos x position
	 * @param ypos y position
	 * @param s double representing moving speed
	 * @param w int representing width
	 * @param h int representing height
	 */
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:img/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:img/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
		xForwardBound = 600;
		xBackwardBound = -75;
		xForwardPos = -200;
		xBackwardPos = 600;
	}
}
