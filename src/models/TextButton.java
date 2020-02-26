package models;

import javafx.scene.image.Image;

public class TextButton extends Actor{

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public TextButton(String img, int xpos, int ypos,int scale) {
		// TODO Auto-generated constructor stub
		Image button = new Image(img, scale, scale, true, true);
		setImage(button);
		setX(xpos);
		setY(ypos);
	}
}
