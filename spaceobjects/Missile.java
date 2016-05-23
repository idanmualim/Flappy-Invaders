package spaceobjects;

public class Missile extends SpaceObject
{
    private final int WIDTH = 20;//put width (horizontal length) of missile hitbox here
    private final int HEIGHT = 5;//put height (vertical length) of missile hitbox here
    private final int INITIALXSPEED = 5;//put initial horizontal speed here (Make sure it's negative)
    private final int ACCELERATION = 3;//put acceleration of missile to the left. (Make sure it's negative)
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
