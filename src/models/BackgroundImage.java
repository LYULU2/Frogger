package models;

import javafx.scene.image.Image;
/**
 * represents the image that is set for the scene
 * @author Luer Lyu
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	/**
	 * set the image for the background
	 * @param imageLink string contains the path to the image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, false, false));
		
	}

}
