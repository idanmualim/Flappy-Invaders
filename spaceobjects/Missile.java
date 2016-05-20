package spaceobjects;

public class Missile extends SpaceObject
{
    private final int WIDTH = //put width (horizontal length) of missile hitbox here
    private final int HEIGHT = //put height (vertical length) of missile hitbox here
    private final int XSPEED = //put initial horizontal speed here (Make sure it's negative)
    
    public Missiles(Location loc, GameField field)
    {
        super(loc, XSPEED, 0, field, WIDTH, HEIGHT);    
    }
    
    public void changeVelocity()
    {
        
    }
}
