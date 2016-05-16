package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field);
	}
	
	public void act() {
		setYVel(getYVel() - 1);
		move();
	}
	
	public void checkHit() {
		// checks if player is hit by missile or ship or rock 
		// if hit ends game maybe explosion annimation first?
		// Wait for Brandon to finish the Hitbox class
	}

	public void shoot() {
		Bullet b = new Bullet(getLocation(), true);
		getGameField().addBulletToField(b);
		
	}
	
}
