package spaceobjects;

import Location;

public class SpaceObject {

	private Location location;
	private int direction;
	private int speed;
	
	public SpaceObject(Location loc, int dir, int vel) {
		location = loc;
		direction = dir;
		speed = vel;
	}
	
	public void act() {
		
	}
	
	public void shoot() {
		
	}
	
	public Location getLocation() {
		return location;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
