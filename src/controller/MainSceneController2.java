package controller;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import models.Croc;
import sceneView.MainSceneView2;

public class MainSceneController2 extends MainSceneController {

	ArrayList<Croc> crocs;
	Random rand = new Random();
	int temp;
	int[] check = new int [5];
	boolean changeSong;
	public MainSceneController2(MainSceneView2 mainSceneView,boolean changeSong) {
		super(mainSceneView);
		// TODO Auto-generated constructor stub
		this.crocs = mainSceneView.getCrocs();
		this.changeSong = changeSong;
	}
	@Override
	public void start() {
		if(changeSong) {
			background.playMusic("music/FroggerThemeSong2.mp3",true);
		}
		else {
			background.playMusic("music/FroggerMainSong.mp3",true);
		}
    	createTimer();
        timer.start();
	}
	
	@Override
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if(now/900000000  % 6==0) {
            		temp = rand.nextInt(20);
            		if(temp<5) {
            			if(check[temp]==0) {
                			background.add(crocs.get(temp));
                    		check[temp]=1;
            			}
            		}
            		
            	}
            	else if(now/900000000  % 6 ==3) {
            		temp = rand.nextInt(10);
            		if(temp<5) {
            			if(check[temp]==1) {
                			background.remove(crocs.get(temp));
                			check[temp]=0;
                		}
            		}
            	}
            	/*
            	 * score changes
            	 */
            	if (animal.changeScore()) {
            		//update highest score
            		updateNumber(animal.getPoints());
            		//update the 
            		digit_s = printNumber(150,yPosScore,animal.getPoints(),digit_s);
            	}
            	/*
            	 * # of lives changes
            	 */
            	if (animal.changeLives()) {
            		updateLives();
            	}
            	/*
            	 * wins
            	 */
            	if (animal.win()) {
            		background.stopMusic();
            		stop();
            		background.stop();
            		insertScore();
            		/*
            		 * write score to the file
            		 */
            		try {
						writeScore();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		scoreFactory.init(animal.getPoints(),true);
            	}
            	if(animal.lose()) {
            		background.stopMusic();
            		stop();
            		background.stop();
            		insertScore();
            		/*
            		 * write score to the file
            		 */
            		try {
						writeScore();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		scoreFactory.init(animal.getPoints(),false);
            	}
            }
        };
    }
	public void changeSong() {
		background.playMusic("music/FroggerThemeSong2.mp3",true);
	}
}
