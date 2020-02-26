package models;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	public int points = 0;
	int end = 0;
	int livesCount =3;
	// this changes in turn to decide the picture to use
	private boolean second = false;
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
	private void goBack() {
		setX(300);
		setY(685.8+movement);
	}
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		goBack();
		imgW1 = new Image("file:img/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:img/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:img/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:img/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:img/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:img/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:img/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:img/froggerRightJump.png", imgSize, imgSize, true, true);
		
		/*
		 * when a key is pressed
		 */
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				/*
				 * if onMove then the action is locked
				 */
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
		/*
		 *  when the key is released
		 */
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
	/*
	 * animations when frog is dead
	 */
	@Override
	public void act(long now) {
		//int bounds = 0;
		/*
		 * if out of bounds, then the movement is invalid (y)
		 */
		if (getY()<0||getY()>724) {
			goBack();
		}
		/*
		 * if out of bounds, then the movement is invalid (x)
		 */
		if (getX()>600) {
			move(-movementX*2, 0);
		}
		if (getX()<0) {
			move(movementX*2, 0);
		}
		if (carDeath) {
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
				setImage(new Image("file:img/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
					
				}
			}
			
		}
		if (waterDeath) {
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
				setImage(new Image("file:img/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		/*
		 * if runs into a car object
		 */
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		/*
		 * if on the log
		 */
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		/*
		 * if on the turtle
		 */
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		/*
		 * if on the wet turtle
		 */
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		/*
		 * if being eaten by a croc
		 */
		else if(getIntersectingObjects(Croc.class).size() >= 1) {
			points-=50;
			changeScore = true;
			goBack();
		}
		else if(getIntersectingObjects(WaterCroc.class).size() >= 1) {
			playSound = true;
			goBack();
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			/*
			 * if the end is occupied
			 */
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				waterDeath = true;
			}
			/*
			 * if wins
			 */
			else{
				points+=50;
				w=800;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
				changeScore = true;
				goBack();
			}
			
		}
		/*
		 * when frog is in the water
		 */
		else if (getY()<413){
			waterDeath = true;
		}
	}
	/*
	 * if all the ends have been achieved
	 */
	public boolean win() {
		return (end==1);
	}
	
	public boolean lose() {
		return (livesCount == 0);
	}
	/*
	 * return the score
	 */
	public int getPoints() {
		return points;
	}
	
	/*
	 * return the score to timer to update the score
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public boolean changeLives() {
		if(changeLives) {
			livesCount--;
			changeLives = false;
			return true;
		}
		return false;
	}
	
	public boolean playSound() {
		if (playSound) {
			playSound = false;
			return true;
		}
		return false;
	}

}
