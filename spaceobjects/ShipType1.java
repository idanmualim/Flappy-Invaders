package spaceobjects

public class ShipType1 extends SpaceObject
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class EnemyShip
     */
    public ShipType1(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
    }

    public act()
    {
        // moves forawrd until shot or out of screen
    }
}
