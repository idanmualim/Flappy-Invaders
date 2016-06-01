//this class is purely an idea. we can implement it if we have extra time. 
//planet slowly moves across screen makes it look more like your moving.
//planet could kill the player maybe even enemy ships too or it could be only aesthetic
package spaceobjects;

import field.GameField;
import field.Location;

public class Planet extends SpaceObject {

  private final static int VELOCITY = -1;
  Location location;


  public Planet(Location loc, GameField field) {
    super(loc, DEFAULT_SPEED, 0, field, WIDTH, HEIGHT);
    setImg();                             //possibly have multiple different planet images so theres a variety
    timer = MOVE_RATE;
  }
  
  
	public void act() {
		location.setLocation((int)(location.getX() + VELOCITY), location.getY());
	}
	
	public Location getLocation() {
	  return location;
	}
}
