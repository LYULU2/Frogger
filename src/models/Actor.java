package models;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import application.World;
/**
 * abstract class which defines the basic methods for actors
 * @author Luer Lyu
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * change the position of the actor in the scene
	 * @param dx an int that been added to the current x position
	 * @param dy an int that been added to the current y position
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * get the whole pane
     * @return the parent of the actor which is the pane and casts to World
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * get the width of the actor
     * @return a double represents the width
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * get the height of the actor
     * @return a double represents the height
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * gets a array of objects that have interaction with actor of class A that calls this function
     * @param <A> the class name
     * @param cls the metadata about A
     * @return an arrayList of Actors
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    /**
     * gets the object that has interaction with actor of class A that calls this function
     * @param <A> the class name
     * @param cls the metadata about A
     * @return the single object
     */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
    /**
     * changes the status of the game
     * @param now a lone number representing current time in milli seconds
     */
    public abstract void act(long now);

}
