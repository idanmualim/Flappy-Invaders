package spaceobjects;

public class Missile extends SpaceObject
{
    private final int WIDTH = //put width (horizontal length) of missile hitbox here
    private final int HEIGHT = //put height (vertical length) of missile hitbox here
    private final int INITIALXSPEED = //put initial horizontal speed here (Make sure it's negative)
    private final int ACCELERATION = //put acceleration of missile to the left. (Make sure it's negative)
    private int xSpeed;
    
    public Missiles(Location loc, GameField field)
    {
        xSpeed = INITIALXSPEED;
        super(loc, XSPEED, 0, field, WIDTH, HEIGHT);
    }
    
    public void changeVelocity()
    {
        setXVel(xSpeed + ACCELERATION);
    }
}
