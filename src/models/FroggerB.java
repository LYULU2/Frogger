package models;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * class represent the second frog for two players, Singleton applied
 * @author Luer Lyu
 *
 */
public class FroggerB extends Animal {
	private static FroggerB animalInstance;
	/**
	 * constructor for the second frogger
	 */
	private FroggerB() {
		int imgSizeb = 37; 
		setImage(new Image("file:img/froggerUpB.png", imgSizeb, imgSizeb, true, true));
		imgW1 = new Image("file:img/froggerUpB.png", imgSizeb, imgSizeb, true, true);
		imgA1 = new Image("file:img/froggerLeftB.png", imgSizeb, imgSizeb, true, true);
		imgS1 = new Image("file:img/froggerDownB.png", imgSizeb, imgSizeb, true, true);
		imgD1 = new Image("file:img/froggerRightB.png", imgSizeb, imgSizeb, true, true);
		imgW2 = new Image("file:img/froggerUpJumpB.png", imgSizeb, imgSizeb, true, true);
		imgA2 = new Image("file:img/froggerLeftJumpB.png", imgSizeb, imgSizeb, true, true);
		imgS2 = new Image("file:img/froggerDownJumpB.png", imgSizeb, imgSizeb, true, true);
		imgD2 = new Image("file:img/froggerRightJumpB.png", imgSizeb, imgSizeb, true, true);
		setKeyPressed();
		setKeyReleased();
	}
	/**
	 * set actions when the key is released
	 */
	public void setKeyReleased() {
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
					if (event.getCode() == KeyCode.UP) {	  
						if (getY() < w) {
							changeScore = true;
							w = getY();
							points+=10;
						}
						move(0, -movement);
						setImage(imgW1);
						second = false;
					}
					else if (event.getCode() == KeyCode.LEFT) {	            	
						move(-movementX, 0);
						setImage(imgA1);
						second = false;
					}
					else if (event.getCode() == KeyCode.DOWN) {	            	
						move(0, movement);
						setImage(imgS1);
						second = false;
					}
					else if (event.getCode() == KeyCode.RIGHT) {	            	
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
			}
		});
	}
	/**
	 * set actions when a key is pressed
	 */
	public void setKeyPressed() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				//if onMove then the action is locked
				if (noMove) {}
				else {
				if (second) {
					if (event.getCode() == KeyCode.UP) {	  
						move(0, -movement);
						changeScore = false;
						setImage(imgW1);
						second = false;
					}
					else if (event.getCode() == KeyCode.LEFT) {	            	
					   	move(-movementX, 0);
					   	setImage(imgA1);
						second = false;
					 }
					else if (event.getCode() == KeyCode.DOWN) {	            	
						move(0, movement);
					    setImage(imgS1);
					    second = false;
					}
					else if (event.getCode() == KeyCode.RIGHT) {	            	
						move(movementX, 0);
						setImage(imgD1);
						second = false;
					}
				}
				else if (event.getCode() == KeyCode.UP) {	            	
					move(0, -movement);
					setImage(imgW2);
					second = true;
				}
				else if (event.getCode() == KeyCode.LEFT) {	            	
					move(-movementX, 0);
					setImage(imgA2);
					second = true;
				}
				else if (event.getCode() == KeyCode.DOWN) {	            	
					move(0, movement);
					setImage(imgS2);
					second = true;
				}
				else if (event.getCode() == KeyCode.RIGHT) {	            	
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
	public static FroggerB getAnimal() {
		if(animalInstance == null) {
			animalInstance = new FroggerB();
		}
		return animalInstance;
	}
	/**
	 * set the position of the animal to the original
	 */
	@Override
	public void goBack() {
		setX(267);
		setY(688.8+movement);
		setImage(new Image("file:img/froggerUpB.png", imgSize, imgSize, true, true));
	}
}
