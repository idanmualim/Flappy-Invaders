//this class is purely an idea. we can implement it if we have extra time. 
//planet slowly moves across screen makes it look more like your moving.
//planet could kill the player maybe even enemy ships too or it could be only aesthetic
package spaceobjects;

import field.GameField;
import field.Location;

public class Planet extends SpaceObject {

  private final static int DEFAULT_SPEED = 1;
  private final static int MOVE_RATE = 1;
  private final static int WIDTH = 100;   //width of planet. planets should be the biggest thing on the screen
  private final static int HEIGHT = 100;  //length of planet
  private int timer;

  public Planet(Location loc, GameField field) {
    super(loc, DEFAULT_SPEED, 0, field, WIDTH, HEIGHT);
    setImg();                             //possibly have multiple different planet images so theres a variety
    timer = MOVE_RATE;
  }
  
  public void act() {
    if(timer <= 0)
      {
        move();
        timer = MOVE_RATE
      }
    else
      timer--;
  }
}
