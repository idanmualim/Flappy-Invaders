package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	//0.3 and -8
	private static final int INITIAL_VELOCITY = -14;
	private static final int CEILING = 44;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 64, 44);
		setImg("player.png");
	}
	
	public void act() {
		if (getXVel() > 0)
			setXVel(getXVel() - 2);
		else {
			setYVel(getYVel() + 0.8);
		if (getLocation().getY() <= CEILING) {
			setLocation(new Location(getLocation().getX(), getHitBox().getHeight() + 1));
			setYVel(1);
		}
		}
		move();
	}
	
	public void bounce() {
		setYVel(INITIAL_VELOCITY);
	}

	public void shoot() {
		Location loc = getLocation();
		Bullet b = new Bullet(new Location(loc.getX() + 64, loc.getY() + 22), true);
		getGameField().addBulletToField(b);
		
	}
	
}
