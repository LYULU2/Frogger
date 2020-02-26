package models;

import javafx.scene.image.Image;
/**
 * this is the class represents the turtle that
 * will turn around body and make frog sink
 * @author Luer Lyu
 *
 */
public class WetTurtle extends DynamicDefault{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	boolean bool = true;
	boolean sunk = false;
	/**
	 * override the method to change the picture
	 * for every frame
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			super.act(now);
	}
	/**
	 * set the image for wet turtle
	 * @param xpos x position
	 * @param ypos y position
	 * @param s double representing speed
	 * @param w int width
	 * @param h int hright
	 */
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:img/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:img/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:img/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:img/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
		xForwardBound = 600;
		xBackwardBound = -75;
		xForwardPos = -200;
		xBackwardPos = 600;
	}
	/**
	 * get the status of the WetTurtle
	 * @return true if the frog on turtle will sink, false otherwise
	 */
	public boolean isSunk() {
		return sunk;
	}
}
