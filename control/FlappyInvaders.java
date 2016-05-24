package control;

public class FlappyInvaders
{
    public static void main(String[] args)
    {
        Controller control = new Controller();
        GUI graphicsUser = new GUI(control);
        control.setGUI(graphicsUser);
    }
}
