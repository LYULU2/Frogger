package models;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * this abstract class represent the basic actions for any frogger
 * @author Luer Lyu
 *
 */
abstract public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	// share common life and score and end
	public static int points = 0;
	public static int end = 0;
	public static int livesCount =3;
	// this changes in turn to decide the picture to use
	boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	boolean changeLives = false;
	boolean playSound = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	/**
	 * set the position of the animal to the original
	 */
	abstract public void goBack();
	/**
	 * constructor for animal
	 */
	public Animal() {
		goBack();
	}
	@Override
	/**
	 * changes the status
	 * @param a lone number representing current time in milli seconds
	 */
	public void act(long now) {
		conditionSimpleCheck(now);
		// if on the log
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		// if on the turtle
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		// if on the wet turtle
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(CrocEnd.class).size() >= 1) {
			endFrogOperation();
		}
		else if(getIntersectingObjects(WaterCroc.class).size() >= 1) {
			playSound = true;
			goBack();
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			endOperation();
		}
		//when frog is in the water
		else if (getY()<413){
			waterDeath = true;
		}
	}
	/**
	 * check the simple boxes, e.g. if it's out of bound
	 * or if it's been hit by a car
	 * @param now long number represents the current time
	 */
	public void conditionSimpleCheck(long now) {
		// if out of bounds, then the movement is invalid
		if (getY()<0||getY()>724) {
			goBack();
		}
		if (getX()>580) {
			move(-movementX*2, 0);
		}
		if (getX()<0) {
			move(movementX*2, 0);
		}
		if (carDeath) {
			hitByCar(now);		
		}
		if (waterDeath) {
			fallWater(now);
		}
		//if runs into a car object or snake
		if (getIntersectingObjects(Obstacle.class).size() >= 1||
				getIntersectingObjects(Snake.class).size() >= 1) {
			carDeath = true;
		}
	}
	/**
	 * set the operation when frog reaches the end
	 */
	public void endOperation() {
		inter = (ArrayList<End>) getIntersectingObjects(End.class);
		// if the end is occupied
		if (getIntersectingObjects(End.class).get(0).isActivated()) {
			waterDeath = true;
		}
		// if wins
		else{
			points+=50;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			changeScore = true;
			goBack();
		}
	}
	/**
	 * actions been taken when frog reaches frogEnd
	 */
	public void endFrogOperation() {
		if(getIntersectingObjects(CrocEnd.class).get(0).isActivated()) {
			waterDeath = true;
		}
		else if (getIntersectingObjects(CrocEnd.class).get(0).getEaten()) {
			carDeath = true;
		}else {
			points+=50;
			w=800;
			getIntersectingObjects(CrocEnd.class).get(0).setEnd();
			end++;
			changeScore = true;
			goBack();
		}
	}
	/**
	 * generate actions when been hit by car
	 * @param now long represents the current time
	 */
	public void hitByCar(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:img/cardeath1.png", imgSize, imgSize, true, true));
		}
		if (carD==2) {
			setImage(new Image("file:img/cardeath2.png", imgSize, imgSize, true, true));
		}
		if (carD==3) {
			setImage(new Image("file:img/cardeath3.png", imgSize, imgSize, true, true));
		}
		if (carD == 4) {
			goBack();
			carDeath = false;
			changeLives = true;
			carD = 0;
			
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
				
			}
		}
	}
	/**
	 * generate actions when object fell into water
	 * @param now long represents the current time
	 */
	public void fallWater(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:img/waterdeath1.png", imgSize,imgSize , true, true));
		}
		if (carD==2) {
			setImage(new Image("file:img/waterdeath2.png", imgSize,imgSize , true, true));
		}
		if (carD==3) {
			setImage(new Image("file:img/waterdeath3.png", imgSize,imgSize , true, true));
		}
		if (carD == 4) {
			setImage(new Image("file:img/waterdeath4.png", imgSize,imgSize , true, true));
		}
		if (carD == 5) {
			goBack();
			waterDeath = false;
			changeLives = true;
			carD = 0;
			//setImage(new Image("file:img/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
		}
	}
	/**
	 * get the status of the game
	 * @return true if all ends are filled, otherwise false
	 */
	public boolean win() {
		return (end==5);
	}
	/**
	 * get the status of the game
	 * @return true if all lives are used, otherwise false
	 */
	public boolean lose() {
		return (livesCount == 0);
	}
	/**
	 * get the current point
	 * @return an int of the current points
	 */
	public static int getPoints() {
		return points;
	}
	
	/**
	 * tell the controller if score is updated
	 * @return true if score is changed, false otherwise
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	/**
	 * update status of the game
	 * @return true if one life is cost, false otherwise
	 */
	public boolean changeLives() {
		if(changeLives) {
			livesCount--;
			changeLives = false;
			return true;
		}
		return false;
	}
	/**
	 * update the name of the song
	 * @return true of the song needs to be changed, false otherwise
	 */
	public boolean playSound() {
		if (playSound) {
			playSound = false;
			return true;
		}
		return false;
	}
	
	/**
	 * set everything to default before next round
	 */
	public void setDefault() {
		Animal.livesCount = 3;
		Animal.end = 0;
	}
}
