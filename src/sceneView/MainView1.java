package sceneView;

import models.Digit;
import models.End;
import models.Snake;
import models.WaterCroc;
/**
 * add extra view for level 1 main game scene
 * @author Luer Lyu
 *
 */
public class MainView1 extends MainView {

	/**
	 * add extra objects
	 */
	public MainView1() {
		//End(x, y), the end position for frog
		background.add(new End(15,106));
		background.add(new End(138+5,106));
		background.add(new End(135+5 + 141-8,106));
		background.add(new End(135+5 + 141-13+141-8+1,106));
		background.add(new End(135+5 + 141-13+141-13+141-13+3,106));
		background.add(new WaterCroc(100, -130, 166, 0.75));
		//print the current score
		background.add(new Digit(0, 30, 150, yPosScore));
		background.add(new Snake(300,450,-0.4,50,50));
		printHighScore();
	}
	/**
	 * print digit on the screen 
	 */
	public void printHighScore() {
		//prints out the highest score so far
		int shift = 0;
		int x= 320;
		int n = highestScore;
		if(n == 0) {
			background.add(new Digit(0, 30, x, yPosScore));
		}
		while (n > 0) {
		    int d = n / 10;
		    int k = n - d * 10;
		    n = d;
			background.add(new Digit(k, 30, x - shift, yPosScore));
			shift+=30;
		}
	}
}
