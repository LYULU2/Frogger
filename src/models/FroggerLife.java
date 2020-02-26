package models;

import javafx.scene.image.Image;

public class FroggerLife extends Actor {
	Image life;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public FroggerLife(int xpos, int ypos) {
		life = new Image("file:img/froggerUp.png", 30, 30, true, true);
		setImage(life);
		setX(xpos);
		setY(ypos);
	}

}
