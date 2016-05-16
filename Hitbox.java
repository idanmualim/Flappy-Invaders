
/**
 * Write a description of class Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hitbox
{
    private Location loc;
    int length, width, direction;

    /**
     * Constructor for objects of class Hitbox
     */
    public Hitbox(Location location, int xLen, int yWid, int rotation)
    {
        loc = location;
        length = xLen;
        width = yWid;
        direction = rotation;
    }
    
    public void changeLocation(Location newLoc)
    {
        loc = newLoc;
    }
    
    public void changeRoation(int rotation)
    {
        direction = rotation;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean checkCollision(Location bullet)
    {
        int xCoordinate = bullet.getX();
        return false;
    }
}
