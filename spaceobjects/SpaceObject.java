package spaceobjects;

import Location;

public class SpaceObject {

	private Location location;
	private int xSpeed;
	private int ySpeed;
	
	public SpaceObject(Location loc, int xSpeed, int ySpeed) {
		location = loc;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
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
