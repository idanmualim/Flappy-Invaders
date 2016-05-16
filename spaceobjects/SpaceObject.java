package spaceobjects;

import Location;

public class SpaceObject {

	private Location location;
	private int xSpeed;
	private int ySpeed;
	private Hitbox hitbox;
	
	public SpaceObject(Location loc, int xSpeed, int ySpeed, double hitboxRadius) {
		location = loc;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		hibox = new Hitbox(loc, hitboxRadius);
	}
	
	public void act() {
		
	}
	
	public void shoot() {
		
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(int x, int y) {
		location.setLocation(x, y);
	}
	
	public int getXSpeed() {
		return xSpeed;	
	}
	
	public int getYSpeed() {
		return ySpeed;
	}
	
}
