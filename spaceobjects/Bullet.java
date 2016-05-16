public class Bullet extends SpaceObject
{
    private int xPos;
    public Bullet(Location loc, int dir, int vel)
    {
        super.(loc, dir, vel);
        xPos = loc.getX;
    }

    public int getXPos() {
        return loc.getX();
    }

    public int getYPos() {
        return loc.getY();
    }

    public void moveBullet(int xSpeed)
    {
        //only moves in x coordinate
        xPos += xSpeed;
    }
}
