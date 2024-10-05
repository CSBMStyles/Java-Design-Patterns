package patterns.comportamiento.state.excersice;

import patterns.comportamiento.state.excersice.ui.Player;
import patterns.comportamiento.state.excersice.ui.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}