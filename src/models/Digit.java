package models;

import javafx.scene.image.Image;
/**
 * class for setting letters and digits, overload used
 * @author Luer Lyu
 *
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * constructor for number
	 * @param n representing the number been printed
	 * @param dim the width and the height of the object
	 * @param x x position
	 * @param y y position
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:img/Digit/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	/**
	 * constructor for letter
	 * @param n char representing a letter
	 * @param dim the width and the height
	 * @param x x position
	 * @param y y position
	 */
	public Digit(char n, int dim, int x, int y) {
		im1 = new Image("file:img/Digit/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
}
