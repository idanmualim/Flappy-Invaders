package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private final int INITIAL_VELOCITY = 5;

	public Player(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
	}
	
	public void act() {
		setYVel(getYVel() - 1);
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
