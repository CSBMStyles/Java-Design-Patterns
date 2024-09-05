package patterns.creational.abstract_factory.own.factory;

import patterns.creational.abstract_factory.own.products.ModernDoor;
import patterns.creational.abstract_factory.own.products.ModernWindow;
import patterns.creational.abstract_factory.own.products.Window;
import patterns.creational.abstract_factory.own.products.Door;

public class ModernPropertyFactory implements PropertyFactory {
    @Override
    public Door createDoor() {
        return new ModernDoor();
    }

    @Override
    public Window createWindow() {
        return new ModernWindow();
    }
}
