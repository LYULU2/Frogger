package models;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * class represent the main frog, Singleton applied
 * @author Luer Lyu
 *
 */
public class Frogger extends Animal {
	private static Frogger animalInstance;
	/**
	 * constructor for frogger
	 */
	private Frogger() {
		setImage(new Image("file:img/froggerUp.png", imgSize, imgSize, true, true));
		imgW1 = new Image("file:img/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:img/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:img/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:img/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:img/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:img/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:img/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:img/froggerRightJump.png", imgSize, imgSize, true, true);
		setKeyPressed();
		setKeyReleased();
	}
	/**
	 * set actions when a key is pressed
	 */
	public void setKeyPressed() {
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
					if (event.getCode() == KeyCode.W) {	  
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points+=10;
						}
						move(0, -movement);
						setImage(imgW1);
						second = false;
					}
					else if (event.getCode() == KeyCode.A) {	            	
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					}
					else if (event.getCode() == KeyCode.S) {	            	
						move(0, movement);
						setImage(imgS1);
						second = false;
					}
					else if (event.getCode() == KeyCode.D) {	            	
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
			}
		});
	}
	/**
	 * set actions when the key is released
	 */
	public void setKeyReleased() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				//if onMove then the action is locked
				if (noMove) {}
				else {
					if (second) {
						if (event.getCode() == KeyCode.W) {	  
							move(0, -movement);
							changeScore = false;
							setImage(imgW1);
							second = false;
						}
						else if (event.getCode() == KeyCode.A) {	            	
							move(-movementX, 0);
							setImage(imgA1);
							second = false;
						}
						else if (event.getCode() == KeyCode.S) {	            	
							move(0, movement);
							setImage(imgS1);
							second = false;
						}
						else if (event.getCode() == KeyCode.D) {	            	
							move(movementX, 0);
							setImage(imgD1);
							second = false;
						}
					}
					else if (event.getCode() == KeyCode.W) {	            	
						move(0, -movement);
						setImage(imgW2);
						second = true;
					}
					else if (event.getCode() == KeyCode.A) {	            	
						move(-movementX, 0);
						setImage(imgA2);
						second = true;
					}
					else if (event.getCode() == KeyCode.S) {	            	
						move(0, movement);
						setImage(imgS2);
						second = true;
					}
					else if (event.getCode() == KeyCode.D) {	            	
						move(movementX, 0);
						setImage(imgD2);
						second = true;
					}
				}
			}
		});	
	}
	/**
	 * create an instance of Animal if there is null
	 * @return an instance of Animal
	 */
	public static Frogger getAnimal() {
		if(animalInstance == null) {
			animalInstance = new Frogger();
		}
		return animalInstance;
	}
	/**
	 * set the position of the animal to the original
	 */
	@Override
	public void goBack() {
		setX(300);
		setY(685.8+movement);
		setImage(new Image("file:img/froggerUp.png", imgSize, imgSize, true, true));
	}
}
