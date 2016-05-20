package spaceobject;

public class Asteroid extends SpaceObject
{
    private final int WIDTH = //Place width (horizontal size) of asteroid here.
    private final int HEIGHT = //Place height (vertical size) of asteroid here.
    private final int MAXXVEL = //Place maximum x velocity here
    private final int MAXYVEL = //Place maximum y velocity here
    
    public Asteroids(Location loc, GameField field)
    {
        super.(loc, MAXXVEL * Math.random(), MAXYVEL * Math.random(), field, WIDTH, HEIGHT);
    }

}
