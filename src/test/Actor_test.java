package test;

import static org.junit.Assert.*;

import org.junit.Before;

import javafx.embed.swing.JFXPanel;
import models.Animal;
import models.CrocEnd;
import models.End;
import models.Frogger;
import models.Log;

import org.junit.Test;


public class Actor_test {
	/**
	 * this makes sure that the class will
	 * be able to run the test under javafx environment
	 */
	@Before
	public void init() {
		new JFXPanel();
	}
	End end;
	/**
     * this tests end can return the right
     * boolean when an end has not been activated
     */
    @Test
    public void end_test_false() {
    	end = new End(1,2);
    	assertEquals(false,end.isActivated());
    }
	/**
	 * this tests end can return the right
	 * boolean when an end is been activated
	 */
    @Test
    public void end_test_true() {
    	end = new End(1,2);
		end.setEnd();
    	assertEquals(true,end.isActivated());
    }
    
    /**
     * if frog can return to the right
     * position whe  goback is called
     */
    @Test
    public void frogger_goback_test() {
    	Frogger frog = Frogger.getAnimal();
    	frog.goBack();
    	assertEquals(300,(int)frog.getX());
    	assertEquals(712,(int)frog.getY());
    }
    /**
     * test lose method will reutrn true when
     * all lives are lost
     */
    @Test
    public void frogger_lose_true() {
    	Frogger frog = Frogger.getAnimal();
    	Animal.livesCount = 0;
    	assertEquals(true,frog.lose());
    }
    /**
     * test lose method will reutrn true when
     * no lives are lost
     */
    @Test
    public void frogger_lose_false() {
    	Frogger frog = Frogger.getAnimal();
    	assertEquals(false,frog.lose());
    }
    /**
     * test if the members in the frog will be
     * set to default when been set default
     */
    @Test
    public void frogger_set_default() {
    	Frogger frog = Frogger.getAnimal();
    	frog.setDefault();
    	assertEquals(3,Animal.livesCount);
    	assertEquals(0,Animal.end);
    }
    /**
     * test if the boolean represents winning
     * will return true when no end is filled
     */
    @Test
    public void frogger_win_false() {
    	Frogger frog = Frogger.getAnimal();
    	Animal.end = 0;
    	assertEquals(false,frog.win());
    }
    /**
     * test if the boolean represents winning
     * will return true when all ends are filled
     */
    @Test
    public void frogger_win_true() {
    	Frogger frog = Frogger.getAnimal();
    	Animal.end = 5;
    	assertEquals(true,frog.win());
    }
    /**
     * test the if the get left function will
     * return the correct boolean when log is
     * moving towards right
     */
    @Test
    public void log_getLeft_test_false() {
    	Log log = new Log("file:img/log3.png", 150, 0, 166, 0.75);
    	assertEquals(false,log.getLeft());
    }
    /**
     * test the if the get left function will
     * return the correct boolean when log is
     * moving towards left
     */
    @Test
    public void log_getLeft_test_true() {
    	Log log = new Log("file:img/log3.png", 150, 0, 166, -0.75);
    	assertEquals(true,log.getLeft());
    }
    /**
     * test the function getPoints in Animal
     */
    @Test
    public void Animal_getPoints() {
    	Animal.points =100;
    	assertEquals(100,Animal.getPoints());
    }
    /**
     * test if crocodile end can return the correct
     * boolean when the end is not been set
     */
    @Test
    public void crocEnd_setEnd_false() {
    	CrocEnd croc;
    	croc = new CrocEnd(1,2);
    	assertEquals(false,croc.isActivated());
    }
    /**
     * test if crocodile end can return the correct
     * boolean when the end is set
     */
    @Test
    public void crocEnd_setEnd_true() {
    	CrocEnd croc1;
    	croc1 = new CrocEnd(1,2);
    	croc1.setEnd();
    	assertEquals(true,croc1.isActivated());
    }
}