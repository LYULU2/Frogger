package models;

import javafx.scene.image.Image;
/**
 * refers to the object that represents how many lives frog has left in the scene
 * @author Luer Lyu
 *
 */
public class FroggerLife extends Actor {
	Image life;
	@Override
	public void act(long now) {
		
	}
	/**
	 * set the image for the frogger life 
	 * @param xpos x position
	 * @param ypos y position
	 */
	public FroggerLife(int xpos, int ypos) {
		life = new Image("file:img/froggerUp.png", 30, 30, true, true);
		setImage(life);
		setX(xpos);
		setY(ypos);
	}

}
