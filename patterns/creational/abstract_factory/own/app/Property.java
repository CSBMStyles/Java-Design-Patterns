package patterns.creational.abstract_factory.own.app;

import patterns.creational.abstract_factory.own.factory.PropertyFactory;
import patterns.creational.abstract_factory.own.products.Door;
import patterns.creational.abstract_factory.own.products.Window;

public class Property {
    private Door door;
    private Window window;

    public Property(PropertyFactory factory) {
        door = factory.createDoor();
        window = factory.createWindow();
    }

    public void describe() {
        door.getDescription();
        window.getDescription();
    }
}
