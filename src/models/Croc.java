package models;

import javafx.scene.image.Image;

public class Croc extends Actor {

	Image croc1;
	Image croc2;
	public Croc(int xpos, int ypos) {
		croc1 = new Image("file:img/croc1.png", 50, 50, true, true);
		croc2 = new Image("file:img/croc2.png", 50, 50, true, true);
		setX(xpos);
		setY(ypos);
	}

	@Override
	public void act(long now) {
		if ((now/900000000)  % 3 ==0) {
			setImage(croc1);
		}
		else if ((now/900000000) % 3 == 1) {
			setImage(croc2);
		}
		else if ((now/900000000) % 3 == 2) {
			setImage(croc1);
		}

	}

}
