package spaceobjects;

public class Missile extends SpaceObject
{
    private final int xSIZE = //put length of missile hitbox here
    private final int ySIZE = //put height of missile hitbox here
    private final int XSPEED = //put initial horizontal speed here (Make sure it's negative)
    
    public Missiles(Location loc, GameField field)
    {
        super(Loc, XSPEED, 0, field, SIZE);    
    }
}
