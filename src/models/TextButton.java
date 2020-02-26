package models;

import javafx.scene.image.Image;
/**
 * representing the objects that are texts but used as buttons in the scene
 * @author Luer Lyu
 *
 */
public class TextButton extends Actor{

	@Override
	public void act(long now) {
		
	}
	/**
	 * set the image for the TextButton
	 * @param img String contains path of the image
	 * @param xpos x position
	 * @param ypos y position
	 * @param scale int representing height and width
	 */
	public TextButton(String img, int xpos, int ypos,int scale) {
		Image button = new Image(img, scale, scale, true, true);
		setImage(button);
		setX(xpos);
		setY(ypos);
	}
	/**
	 * change the image when mouse enters
	 * @param img String contains path of the image
	 * @param xpos x position
	 * @param ypos y position
	 * @param scale int representing height and width
	 */
	public void changeImage(String img, int xpos, int ypos, int scale) {
		setImage(new Image(img, scale, scale, true, true));
		setX(xpos);
		setY(ypos);
	}
	/**
	 * set the position for the TextButton
	 * @param xpos x position
	 * @param ypos y position
	 */
	public void changePos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);
	}
}
