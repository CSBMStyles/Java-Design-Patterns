package patterns.creational.abstract_factory.excersice.app;

import patterns.creational.abstract_factory.excersice.factories.GUIFactory;
import patterns.creational.abstract_factory.excersice.factories.MacOSFactory;
import patterns.creational.abstract_factory.excersice.factories.WindowsFactory;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    /**
    En este ejemplo, los botones y las casillas actuarán como productos. Tienen dos variantes: macOS y Windows.

    La fábrica abstracta define una interfaz para crear botones y casillas. Hay dos fábricas concretas, que devuelven ambos productos en una única variante.

    El código cliente funciona con fábricas y productos utilizando interfaces abstractas. Esto permite al código cliente funcionar con cualquier variante de producto creada por el objeto de fábrica.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
