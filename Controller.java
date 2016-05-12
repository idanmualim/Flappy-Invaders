public class Controller {
    
    private GUI graphicsUserInt;

    public Controller() {
        
    }

    public void setGUI(GUI gui) {
        graphicsUserInt = gui;
    }
    
    public static void main(String[] args) {
        Controller gameController = new Controller();
        GUI gui = new GUI(gameController);
        gameController.setGui(gui);
    }
}
