package sceneView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import application.MyStage;
import javafx.animation.AnimationTimer;
import models.Animal;
import models.BackgroundImage;
import models.Digit;
import models.End;
import models.FroggerLife;
import models.Log;
import models.Obstacle;
import models.Turtle;
import models.WetTurtle;

abstract public class MainSceneView extends SceneView {

	Animal animal;
	int yPosScore = 40;
	String fileName = "HighScore.txt";
	int highestScore;
	int[] highScoreList = new int[10];
	ArrayList<FroggerLife> lives = new ArrayList<FroggerLife> ();
	public MainSceneView() {
		 background = new MyStage();

		BackgroundImage froggerback = new BackgroundImage("file:img/bkgd.png");
		    
		background.add(froggerback);
		
		/*
		 * Log(img, size, x, y, speed)	
		 */
		background.add(new Log("file:img/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:img/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:img/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("file:img/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:img/logs.png", 300, 400, 276, -2));
		background.add(new Log("file:img/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:img/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:img/log3.png", 150, 490, 329, 0.75));
		/*
		 * turtle(x, y, speed, width, height )
		 */
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		/*
		 * End(x, y), the end position for frog
		 */
		background.add(new End(10,96));
		background.add(new End(138,96));
		background.add(new End(135 + 141-13,96));
		background.add(new End(135 + 141-13+141-13+1,96));
		background.add(new End(135 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:img/froggerUp.png");
		background.add(animal);
		/*
		 * obstacle(img, x, y, speed,width, height) +60
		 */
		background.add(new Obstacle("file:img/truck1"+"Right.png", 0, 709-50, 1, 120, 120));
		background.add(new Obstacle("file:img/truck1"+"Right.png", 300, 709-50, 1, 120, 120));
		background.add(new Obstacle("file:img/truck1"+"Right.png", 600, 709-50, 1, 120, 120));
		background.add(new Obstacle("file:img/car1Left.png", 100, 657-50, -1, 50, 50));
		background.add(new Obstacle("file:img/car1Left.png", 250, 657-50, -1, 50, 50));
		background.add(new Obstacle("file:img/car1Left.png", 400, 657-50, -1, 50, 50));
		background.add(new Obstacle("file:img/car1Left.png", 550, 657-50, -1, 50, 50));
		background.add(new Obstacle("file:img/truck2Right.png", 0, 600-50, 1, 200, 200));
		background.add(new Obstacle("file:img/truck2Right.png", 500, 600-50, 1, 200, 200));
		background.add(new Obstacle("file:img/car1Left.png", 500, 550-50, -5, 50, 50));
		/*
		 * add 3 lives in the corner
		 */
		lives.add(new FroggerLife(10,760));
		lives.add(new FroggerLife(40,760));
		lives.add(new FroggerLife(70,760));
		for(int i=0;i<lives.size();i++) {
			background.add(lives.get(i));
		}
		
		/*
		 * put the highest score on the screen
		 */
		try {
			getScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//prints out the highest score so far
		int shift = 0;
		int x= 320;
		int n = highestScore;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, x - shift, yPosScore));
    		  shift+=30;
    		}
		
		background.start();
	}
	
	/*
	 * return the highest score in the file
	 */
	public void getScore() throws IOException {
		int temp;
		String text = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		int index =0;
		while((text = bufferReader.readLine())!=null) {
			temp =Integer.parseInt(text);
			highScoreList[index] = temp;
			if(temp>highestScore) {
				// load the highest number else remain 0
				highestScore =temp;
			}
			index++;
		}
		bufferReader.close();
	}
	
	public Animal getFrog() {
		return animal;
	}
	
	public AnimationTimer getTimer() {
		return timer;
	}
	
	public MyStage getStage() {
		return background;
	}
	
	public ArrayList<FroggerLife> getLives(){
		return lives;
	}

	public int getHighestScore() {
		return highestScore;
	}
	
	public int[] getScoreList() {
		return highScoreList;
	}
}
