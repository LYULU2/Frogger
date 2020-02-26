package models;

import javafx.scene.image.Image;

public class WaterCroc extends Actor {
	private double speed;
	public WaterCroc( int size, int xpos, int ypos, double s) {
		setImage(new Image("file:img/waterCroc.png", size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);

	}

}
