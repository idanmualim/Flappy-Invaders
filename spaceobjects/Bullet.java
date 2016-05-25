package spaceobjects;

import field.Hitbox;
import field.Location;

public class Bullet extends SpaceObject {

	private final int DEFAULT_SPEED = 10;
	
	public Bullet(Location loc, boolean firedByPlayer) {
		setHitbox(new Hitbox(loc, 10, 8));
		setLocation(loc);
		setImg("bullet.png");
		if(firedByPlayer)
			setXVel(DEFAULT_SPEED);
		else
			setXVel(-DEFAULT_SPEED);
	}
	
	public void act() {
		move();
	}
	
}
