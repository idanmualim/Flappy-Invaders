package spaceobject;

public class Asteroid extends SpaceObject
{
    private final int WIDTH = //Place width (horizontal size) of asteroid here.
    private final int HEIGHT = //Place height (vertical size) of asteroid here.
    private final int MAXXVEL = 5 //Place maximum x velocity here
    private final int MAXYVEL = 5 //Place maximum y velocity here
    
    public Asteroids(Location loc, GameField field)
    {
        super.(loc, MAXXVEL * Math.random(), MAXYVEL * Math.random(), field, WIDTH, HEIGHT);
    }
    
    public void act() {
        move();
    }

}
