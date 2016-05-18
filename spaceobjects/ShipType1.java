package spaceobjects

public class ShipType1 extends SpaceObject
{
    import field.GameField;
    import field.Location;

    public ShipType1(Location loc, int xVel, int yVel, GameField field, int radius) {
		super(loc, xVel, yVel, field, radius);
    }

    public act()
    {
        // moves forawrd until shot or out of screen
    }
}
