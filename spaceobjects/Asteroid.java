package spaceobject;

public class Asteroid extends SpaceObject
{
    private final static int WIDTH = //Place width (horizontal size) of asteroid here.
    private final static int HEIGHT = //Place height (vertical size) of asteroid here.
    private final static int MAXXVEL = 5 //Place maximum x velocity here
    private final static int MAXYVEL = 5 //Place maximum y velocity here
    
    public Asteroids(Location loc, GameField field)
    {
        super.(loc, -(MAXXVEL * Math.random()) + 1, ((MAXYVEL * 2) * Math.random()) - MAXYVEL, field, WIDTH, HEIGHT);
    }
    
    public void act() {
        move();
    }

}
