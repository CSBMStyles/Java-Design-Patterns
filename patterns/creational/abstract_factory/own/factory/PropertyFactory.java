package patterns.creational.abstract_factory.own.factory;

import patterns.creational.abstract_factory.own.products.Door;
import patterns.creational.abstract_factory.own.products.Window;

public interface PropertyFactory {
    Door createDoor();
    Window createWindow();
}
