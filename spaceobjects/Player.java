package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final static int INITIAL_VELOCITY = //Initial upward velocity
	private final static int WIDTH; //Horizontal length of ship
	private final static int HEIGHT; //Vertical length of ship
	private final static int GRAVITY; //Set acceleration

	public Player(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
	}
	
	public void act() {
		setYVel(getYVel() - GRAVITY);
		move();
	}
	
	public void bounce() {
		super.setYVel(initialVelocity);
	}

	public void shoot() {
		Bullet b = new Bullet(getLocation(), true);
		getGameField().addBulletToField(b);
		
	}
	
}
