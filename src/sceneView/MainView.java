package sceneView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import application.MyStage;
import javafx.animation.AnimationTimer;
import models.BackgroundImage;
import models.Frogger;
import models.FroggerB;
import models.FroggerLife;
import models.Log;
import models.Obstacle;
import models.TextButton;
import models.Turtle;
import models.WetTurtle;

/**
 * abstract class that add basic actors to the scene
 * and add common methods to the class
 * @author Luer Lyu
 *
 */
abstract public class MainView extends SceneView {

	Frogger frog1;
	FroggerB frog2;
	int yPosScore = 40;
	String fileName = "HighScore.txt";
	int highestScore;
	int[] highScoreList = new int[10];
	String[] highScoreNames = new String[10];
	TextButton pause;
	ArrayList<FroggerLife> lives = new ArrayList<FroggerLife> ();
	/**
	 * constructor for MainSceneView, add Actors to the stage 
	 */
	public MainView() {
		background = new MyStage();
		BackgroundImage froggerback = new BackgroundImage("file:img/bkgd.png");
		background.add(froggerback);
		addLog();
		addTurtle();
		addObstacle();
		addFrogLives();
		frog1 = Frogger.getAnimal();
		background.add(frog1);
		pause = new TextButton("file:img/pause.png",500,20,40);
		background.add(pause);
		//put the highest score on the screen
		try {
			getScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
		background.start();
	}
	/**
	 * add 3 lives in the corner and also in the arrayList
	 */
	public void addFrogLives() {
		lives.add(new FroggerLife(10,760));
		lives.add(new FroggerLife(40,760));
		lives.add(new FroggerLife(70,760));
		for(int i=0;i<lives.size();i++) {
			background.add(lives.get(i));
		}
	}
	/**
	 * add Log models: Log(img, size, x, y, speed);
	 */
	public void addLog() {
		background.add(new Log("file:img/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:img/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:img/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("file:img/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:img/logs.png", 300, 400, 276, -2));
		background.add(new Log("file:img/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:img/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:img/log3.png", 150, 490, 329, 0.75));
	}
	/**
	 * add turtles
	 * (Wet)turtle(x, y, speed, width, height )
	 */
	public void addTurtle() {
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
	}
	/**
	 * add obstacles
	 * obstacle(img, x, y, speed,width, height)
	 */
	public void addObstacle() {
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
	}
	/**
	 * read the scores from the history score file and get the highest
	 * numbers on even numbered lines, names on odd numbered lines
	 * @throws IOException when the file does not exist
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
			highScoreNames[index] = bufferReader.readLine();
			if(temp>highestScore) {
				// load the highest number else remain 0
				highestScore =temp;
			}
			index++;
		}
		bufferReader.close();
	}
	
	public TextButton getPause() {
		return pause;
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
	
	public String[] getScoreName() {
		return highScoreNames;
	}
}
