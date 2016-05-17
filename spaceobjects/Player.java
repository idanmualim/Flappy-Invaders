package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private int initialVelocity;

	public Player(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
		initialVelocity = yVel;
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
