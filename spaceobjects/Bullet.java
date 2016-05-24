package spaceobjects;

import javax.swing.ImageIcon;

import field.Hitbox;
import field.Location;

public class Bullet extends SpaceObject {

	private final int DEFAULT_SPEED = 10;
	
	public Bullet(Location loc, boolean firedByPlayer) {
		setHitbox(new Hitbox(loc, 5, 4));
		setLocation(loc);
		setImg(new ImageIcon("src/bullet.png").getImage());
		if(firedByPlayer)
			setXVel(DEFAULT_SPEED);
		else
			setXVel(-DEFAULT_SPEED);
	}
	
	public void act() {
		move();
	}
	
}
