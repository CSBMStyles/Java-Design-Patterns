package patterns.creational.abstract_factory.excersice.app;

import patterns.creational.abstract_factory.excersice.buttons.Button;
import patterns.creational.abstract_factory.excersice.checkboxes.Checkbox;
import patterns.creational.abstract_factory.excersice.factories.GUIFactory;

/**
 * Factory users don't care which concrete factory they use since they work with
 * factories and products through abstract interfaces.
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
