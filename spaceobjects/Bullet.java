package spaceobjects;

import field.Hitbox;
import field.Location;

public class Bullet extends SpaceObject {

	private final int DEFAULT_SPEED = 10;
	
	public Bullet(Location loc, boolean firedByPlayer) {
		setHitbox(new Hitbox(loc, 10, 8));
		setLocation(loc);
		if(firedByPlayer) {
			setXVel(DEFAULT_SPEED);
			setImg("bullet.png");
		}
		else {
			setXVel(-DEFAULT_SPEED);
			setImg("enemy_bullet.png");
		}
	}
	
	public void act() {
		move();
	}
	
	
}
