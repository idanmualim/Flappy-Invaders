
public class Hitbox
{
    private Location loc;
    double radius;

    public Hitbox(Location location, double rad)
    {
        loc = location;
        radius = rad;
    }
    
    public void changeLocation(int x, int y)
    {
        loc.setLocation(x, y);
    }

    public boolean checkCollision(Location bullet)
    {
        int a = loc.getX() - bullet.getX();
        int b = loc.getY() - bullet.getY();
        if (Math.sqrt(a*a + b*b) <= radius)
            return true;
        else
            return false;
    }
}
