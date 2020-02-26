package sceneView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.MyStage;
import models.BackgroundImage;
import models.Digit;
import models.TextButton;

public class ScoreSceneView extends SceneView {

	TextButton start;
	TextButton back;
	String fileName = "HighScore.txt";
	int numberOfDigits = 4;
	public ScoreSceneView(boolean win) {
		background = new MyStage();
		
		BackgroundImage bkdg = new BackgroundImage("file:img/ScoreBoard.png");
		start = new TextButton("file:img/playAgain.png",260,720,180);
		back = new TextButton("file:img/back.png",140,720,80);
		background.add(bkdg);
		if(win) {
			background.add(new TextButton("file:img/win.png",60,40,450));
		}else{
			background.add(new TextButton("file:img/lose.png",85,40,400));
		}
		
		background.add(start);
		background.add(back);
		try {
			printScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		background.start();
		background.playMusic("music/endSong.mp3",false);
	}
	
	public void printScore() throws IOException {
		int n;
		String text = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		int shift =0;
		int yPos = 195;
		int x=400;
		//or always leave a space for 0?
		while((text = bufferReader.readLine())!=null) {
			n =Integer.parseInt(text);
			for(int i=0;i<numberOfDigits;i++) {
				if (n > 0) {
		    		  int d = n / 10;
		    		  int k = n - d * 10;
		    		  n = d;
		    		  background.add(new Digit(k, 30, x - shift, yPos));
		    		  shift+=30;
		    		}
				else {
					background.add(new Digit(0, 30, x - shift, yPos));
					shift+=30;
		    		}
			}
			
			yPos+=48;
			x=400;
			shift=0;
		}
		bufferReader.close();
	}
	
	public void printCurrentScore(int n) {
		int shift = 0;
		int x= 480;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, x - shift, 70));
    		  shift+=30;
    		}
	}
	
	
	
	public TextButton getStart() {
		return start;
	}

	public TextButton getBack() {
		return back;
	}
	
	public MyStage getStage() {
		return background;
	}
}
