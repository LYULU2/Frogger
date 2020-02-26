package application;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import models.Actor;
/**
 * define the basic functions for the pane
 * @author Luer Lyu
 *
 */

public abstract class World extends Pane {
    private AnimationTimer timer;
    
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					setSceneReleased(newValue);
					setScenePressed(newValue);
				}
				
			}
    		
		});
    }
    /**
     * set the action for scene when the Scene is been clicked
     * @param newValue represents the scene
     */
    public void setScenePressed(Scene newValue) {
    	newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(getOnKeyPressed() != null) 
					getOnKeyPressed().handle(event);
				List<Actor> myActors = getObjects(Actor.class);
				for (Actor anActor: myActors) {
					if (anActor.getOnKeyPressed() != null) {
						anActor.getOnKeyPressed().handle(event);
					}
				}
			}
			
		});
    }
    /**
     * set the action for scene when the key is been released
     * @param newValue represents the scene
     */
    public void setSceneReleased(Scene newValue) {
    	newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(getOnKeyReleased() != null) 
					getOnKeyReleased().handle(event);
				List<Actor> myActors = getObjects(Actor.class);
				for (Actor anActor: myActors) {
					if (anActor.getOnKeyReleased() != null) {
						anActor.getOnKeyReleased().handle(event);
					}
				}
			}
			
		});
    }

    /**
     * create an AnimationTimer for the game
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
            }
        };
    }

    /**
     * call the function to create timer and starts the timer
     */
    public void start() {
    	createTimer();
        timer.start();
    }

    /**
     * stops the timer
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * add Actor
     * @param actor the Actor object that needs to be added to the pane
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * remove Actor
     * @param actor the Actor object that needs to be removed from the pane
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * gets a list of all the objects of class A
     * @param <A> the class name 
     * @param cls the metadata about A
     * @return an arrayList of Actors
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * change the status of the game
     * @param now current time in milli seconds
     */
    public abstract void act(long now);
}
