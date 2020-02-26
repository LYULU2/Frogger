package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.MainController1;
import javafx.embed.swing.JFXPanel;
import sceneView.MainView1;
public class Controller_test {

	/**
	 * this makes sure that the class will
	 * be able to run the test under javafx environment
	 */
	@Before
	public void init() {
		new JFXPanel();
	}
	int[] prevScores = {2, 6, 4};
	/**
	 * test the sort method if it can
	 * put the added score to the
	 * right position
	 */
	@Test
	public void sortRoundScores_test() {
		MainView1 view =new MainView1();
		MainController1 controller = new MainController1(view);
		controller.prevScores = prevScores;
		controller.sortRoundScores();
		int[] sorted =  {6,4,2};
		assertArrayEquals(sorted,controller.prevScores);
	}

}
