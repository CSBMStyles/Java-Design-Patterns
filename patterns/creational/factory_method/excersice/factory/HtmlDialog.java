package patterns.creational.factory_method.excersice.factory;

import patterns.creational.factory_method.excersice.buttons.Button;
import patterns.creational.factory_method.excersice.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}