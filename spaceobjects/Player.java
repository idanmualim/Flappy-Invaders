package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final static int INITIAL_VELOCITY = 25;//Initial upward velocity
	private final static int WIDTH = 20; //Horizontal length of ship
	private final static int HEIGHT = 10; //Vertical length of ship
	private final static int GRAVITY = 5; //Set acceleration

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
