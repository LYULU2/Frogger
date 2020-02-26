package sceneView;

import java.util.ArrayList;

import models.Croc;
import models.Digit;

public class MainSceneView2 extends MainSceneView {

	
	ArrayList<Croc> crocs = new ArrayList<Croc> ();
	public MainSceneView2() {
		crocs.add(new Croc(10+5,106));
		crocs.add(new Croc(138+5,106));
		crocs.add(new Croc(135+5 + 141-13,106));
		crocs.add(new Croc(135+5 + 141-13+141-13+1,106));
		crocs.add(new Croc(135+5 + 141-13+141-13+141-13+3,106));
		
	}
	
	public ArrayList<Croc> getCrocs() {
		return crocs;
	}
	
	public void passScore(int n) {
		animal.points = n;
		int shift = 0;
		int x= 150;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, x - shift, yPosScore));
    		  shift+=30;
    		}
	}

}
