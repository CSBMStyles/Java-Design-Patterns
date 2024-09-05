package patterns.creational.abstract_factory.own.factory;

import patterns.creational.abstract_factory.own.products.ColonialDoor;
import patterns.creational.abstract_factory.own.products.ColonialWindow;
import patterns.creational.abstract_factory.own.products.Door;
import patterns.creational.abstract_factory.own.products.Window;

public class ColonialPropertyFactory implements PropertyFactory {
    @Override
    public Door createDoor() {
        return new ColonialDoor();
    }

    @Override
    public Window createWindow() {
        return new ColonialWindow();
    }
}
