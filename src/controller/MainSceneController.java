package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;

import application.MyStage;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.Animal;
import models.Digit;
import models.FroggerLife;
import sceneFactory.ScoreFactory;
import sceneView.MainSceneView;

public abstract class MainSceneController {

	int highestScore;
	String fileName = "HighScore.txt";
	AnimationTimer timer;
	Animal animal;
	MyStage background;
	int yPosScore = 40;
	ArrayList<FroggerLife> lives;
	int livesCount = 2;
	int[] highScoreList;
	Digit digit_s;
	Digit digit_h;
	// current level of the game
	public int level = 1;
	public int[] prevScores = {-100,-100,-100,-100,-100};
	public int scorePrev =0;
	ScoreFactory scoreFactory;
	
	public MainSceneController(MainSceneView mainSceneView) {
		this.timer = mainSceneView.getTimer();
		this.animal = mainSceneView.getFrog();
		this.background = mainSceneView.getStage();
		this.lives = mainSceneView.getLives();
		this.highestScore = mainSceneView.getHighestScore();
		this.highScoreList = mainSceneView.getScoreList();
	}
	
	/*
	 * timer handles the status of the game
	 */
	abstract public void createTimer();
    	
	public void insertScore() {
		int current = animal.getPoints();
		int temp;
		for(int i=0;i<highScoreList.length;i++) {
			//insert the current the score if applicable
			if(highScoreList[i] == 0) {
				highScoreList[i] = current;
				break;
			}else {
				if(current>highScoreList[i]) {
					temp = highScoreList[i];
					highScoreList[i] = current;
					current = temp;
				}
			}
			
		}
	}
	
	public void writeScore() throws IOException {
		
		// save the changes to the file 
		FileWriter fileWriter = new FileWriter(fileName);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    for(int point : highScoreList){
	    	printWriter.print(point + "\n");
	    }
	    printWriter.close();
	}
	
	/*
	 * called when the game starts
	 */
	public void start() {
		background.playMusic("music/FroggerMainSong.mp3",true);
    	createTimer();
        timer.start();
    }
	/*
	 * called when the game stops
	 */
    public void stop() {
        timer.stop();
    }
    
    /*
     * update the current highest score
     */
    public void updateNumber(int n) {
    	// if new score has been created
    	if(highestScore < n) {
    		digit_h = printNumber(320,yPosScore,n,digit_h);
    	}else {
    		digit_h = printNumber(320,yPosScore,highestScore,digit_h);
    	}
    }
    
    /*
     * print number on screen (Xpos, Ypos, number)
     */
    public Digit printNumber(int x, int y, int n, Digit digit) {
    	int shift = 0;
    	Digit temp = null;
    	if(digit != null) {
    		background.remove(digit);
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  temp = new Digit(k, 30, x - shift, y);
    		  background.add(temp);
    		  shift+=30;
    		}
    	return temp;
    }
    /*
     * update lives left
     */
    public void updateLives() {
    	background.remove(lives.get(livesCount));
    	lives.remove(livesCount);
    	showAlert();
		livesCount--;
		
    }
    
    public void showAlert() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	if(livesCount>0) {
    		alert.setTitle("Checkout the summary for this round!");
    		prevScores[level-1]=animal.getPoints()-scorePrev;
    		alert.setHeaderText("You Gained "+prevScores[level-1]+" points!");
    		String info ="Ranking For The Scores: ";
        	Arrays.sort(prevScores);
        	//reverse the array
        	for(int i = 0; i < prevScores.length / 2; i++)
        	{
        	    int temp = prevScores[i];
        	    prevScores[i] = prevScores[prevScores.length - i - 1];
        	    prevScores[prevScores.length - i - 1] = temp;
        	}
        	for(int i=0;i<level;i++) {
        		info+=(i+1)+": "+prevScores[i]+"; ";
        	}
        	alert.setContentText(info);
    		
    		alert.show();
    	}
    	scorePrev = animal.getPoints();
    	level++;
    }
    
    public void createScoreFactory(Stage primaryStage) {
    	scoreFactory = new ScoreFactory(primaryStage);
    }
}
