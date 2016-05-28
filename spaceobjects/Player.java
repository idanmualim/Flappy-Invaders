package spaceobjects;

import field.GameField;
import field.Location;

public class Player extends SpaceObject{
	
	private static final int INITIAL_VELOCITY = -8;
	private static final int CEILING = 64;
	double trueYVel;

	public Player(Location loc, int xVel, int yVel, GameField field) {
		super(loc, xVel, yVel, field, 62, 44);
		setImg("ship1.png");
	}
	
	public void act() {
		setYVel(getYVel() + 0.3);
		if (getLocation().getY() <= CEILING) {
			setLocation(new Location(getLocation().getX(), 65));
			setYVel(1);
		}
		move();
	}
	
	public void bounce() {
		setYVel(INITIAL_VELOCITY);
	}

	public void shoot() {
		Location loc = getLocation();
		Bullet b = new Bullet(new Location(loc.getX() + 62, loc.getY() + 22), true);
		getGameField().addBulletToField(b);
		
	}
	
}
