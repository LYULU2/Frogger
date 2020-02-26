
package sceneView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.MyStage;
import models.BackgroundImage;
import models.Digit;
import models.TextButton;
/**
 * set the view for score scene
 * @author Luer Lyu
 *
 */
public class ScoreView extends SceneView {

	TextButton start;
	TextButton back;
	String fileName = "HighScore.txt";
	int numberOfDigits = 4;
	/**
	 * set the view for the scene
	 */
	public ScoreView() {
		background = new MyStage();
		BackgroundImage bkdg = new BackgroundImage("file:img/ScoreBoard.png");
		start = new TextButton("file:img/playAgain.png",260,720,180);
		back = new TextButton("file:img/back.png",140,720,80);
		background.add(bkdg);
		
		background.add(start);
		background.add(back);
		try {
			printScore();
		} catch (IOException e) {
			e.printStackTrace();
		}
		background.start();
		background.playMusic("music/endSong.mp3",false);
	}
	/**
	 * print score on the screen according to the ranking
	 * along with names 
	 * @throws IOException when the file cannot be found
	 */
	public void printScore() throws IOException {
		int n;
		String text = null;
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferReader = new BufferedReader(fileReader);
		int shift =0;
		int yPos = 195;
		int x=500;
		String Name;
		while((text = bufferReader.readLine())!=null) {
			n =Integer.parseInt(text);
			Name = bufferReader.readLine();
			printBoth(shift,x,yPos,n,Name);
			yPos+=48;
		}
		bufferReader.close();
	}
	/**
	 * write on the screen (both scores and name)
	 * @param shift int represents the shift digit will make
	 * @param x int represents the start position of the score
	 * @param yPos int represents the y position
	 * @param n int represents the number been printed
	 * @param Name String represents player's name
	 */
	public void printBoth(int shift, int x, int yPos,int n,String Name) {
		//print score
		for(int i=0;i<numberOfDigits;i++) {
			if (n > 0) {
	    		  int d = n / 10;
	    		  int k = n - d * 10;
	    		  n = d;
	    		  background.add(new Digit(k, 30, x - shift, yPos));
	    	}
			else {
				background.add(new Digit(0, 30, x - shift, yPos));
	    	}
			shift+=30;
		}
		x-=30;
		//print name
		for(int j=0;j<3;j++) {
			background.add(new Digit(Name.charAt(j),24,x-shift,yPos));
			shift+=24;
		}
	}
	/**
	 * print current score on screen
	 * @param n int final score
	 */
	public void printCurrentScore(int n) {
		int shift = 0;
		int x= 480;
		if(n==0) {
			background.add(new Digit(0, 30, x, 70));
		}
		while( n>0 ) {
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
