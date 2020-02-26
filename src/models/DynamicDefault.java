package models;
/**
 * abstract class to manage all the objects that
 * has a default moving pattern default in the scene
 * @author Luer Lyu
 *
 */
public abstract class DynamicDefault extends Actor {
	double speed;
	int xForwardBound;
	int xBackwardBound;
	int xForwardPos;
	int xBackwardPos;
	public DynamicDefault() {
	}

	/**
	 * set the boundary for the object
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>xForwardBound && speed>0)
			setX(xForwardPos);
		if (getX()<xBackwardBound && speed<0)
			setX(xBackwardPos);
	}

}
