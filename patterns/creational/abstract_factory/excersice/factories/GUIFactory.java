package patterns.creational.abstract_factory.excersice.factories;

import patterns.creational.abstract_factory.excersice.buttons.Button;
import patterns.creational.abstract_factory.excersice.checkboxes.Checkbox;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
