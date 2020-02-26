package sceneView;

import java.util.ArrayList;

import models.Animal;
import models.CrocEnd;
import models.Digit;
/**
 * add extra view for level 2 main game scene
 * @author Luer Lyu
 *
 */
public class MainView2 extends MainView {

	
	ArrayList<CrocEnd> crocs = new ArrayList<CrocEnd> ();
	/**
	 * add extra actors
	 */
	public MainView2() {
		background.add(new CrocEnd(10,106));
		background.add(new CrocEnd(138+5,106));
		background.add(new CrocEnd(135+5 + 141-8,106));
		background.add(new CrocEnd(135+5 + 141-13+141-8+1,106));
		background.add(new CrocEnd(135+5 + 141-13+141-13+141-13+3,106));
		printScore(Animal.getPoints());
		frog1.setDefault();
	}
	
	public ArrayList<CrocEnd> getCrocs() {
		return crocs;
	}
	/**
	 * print current score
	 * @param n current score
	 */
	public void printScore(int n) {
		int shift = 0;
		int x= 150;
		// the points cannot be 0
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, x - shift, yPosScore));
    		  shift+=30;
    		}
	}

}
