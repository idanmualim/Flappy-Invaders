
/**
 * Write a description of class FlappyInvaders here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyInvaders
{
    public static void main(String[] args)
    {
        Controller control = new Controller();
        GUI graphicsUser = new GUI(control);
        control.setGUI(graphicsUser);
    }
}
