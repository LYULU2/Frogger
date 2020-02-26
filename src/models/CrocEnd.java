package models;

import java.util.Random;

import javafx.scene.image.Image;
/**
 * represents crocdiles that appears in the destinations
 * @author Luer Lyu
 *
 */
public class CrocEnd extends End {
	Image croc1;
	Image croc2;
	Image end;
	Image frog;
	boolean eaten;
	int remainder;
	/**
	 * constructor
	 * @param xpos int representing the x position
	 * @param ypos int representing the y position
	 */
	public CrocEnd(int xpos, int ypos) {
		super(xpos,ypos);
		croc1 = new Image("file:img/croc1.png", 50, 50, true, true);
		croc2 = new Image("file:img/croc2.png", 50, 50, true, true);
		end = new Image("file:img/EndEmpty.png", 50, 50, true, true);
		frog = new Image("file:img/FrogEnd2.png", 50, 50, true, true);
		setX(xpos);
		setY(ypos);
		Random rand = new Random();
		remainder =  rand.nextInt(10);
	}

	/**
	 * change the image set for the object
	 * @param now current time in milli seconds
	 */
	@Override
	public void act(long now) {
		if(!activated) {
			if ((now/900000000)  % 10 ==remainder) {
				eaten = true;
				setImage(croc1);
			}
			else if ((now/900000000) % 10 == (remainder+1)%10) {
				setImage(croc2);
				eaten = true;
			}
			else if ((now/900000000) % 10 == (remainder+2)%10) {
				eaten = true;
				setImage(croc1);
			}
			else {
				eaten = false;
				setImage(end);
			}
		}
	}
	/**
	 * frog is already in the destination
	 * then the boolean will be set to false
	 */
	@Override
	public void setEnd() {
		activated = true;
		setImage(frog);
	}
	
	public boolean getEaten() {
		return eaten;
	}

}
