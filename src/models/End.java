package models;

import javafx.scene.image.Image;
/**
 * representing the objects of destinations in the scene
 * @author Luer Lyu
 *
 */
public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
	}
	/**
	 * set the image for end
	 * @param x x position
	 * @param y y position
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:img/EndEmpty.png", 45, 45, true, true));
	}
	/**
	 * change the member of activated to true
	 */
	public void setEnd() {
		setImage(new Image("file:img/FrogEnd2.png", 45, 45, true, true));
		activated = true;
	}
	/**
	 * check whether the end is occupied
	 * @return true if the end is occupied, false otherwise
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
