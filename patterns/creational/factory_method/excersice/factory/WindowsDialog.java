package patterns.creational.factory_method.excersice.factory;

import patterns.creational.factory_method.excersice.buttons.Button;
import patterns.creational.factory_method.excersice.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}