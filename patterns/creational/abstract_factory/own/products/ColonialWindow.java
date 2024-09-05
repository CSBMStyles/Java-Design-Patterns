package patterns.creational.abstract_factory.own.products;

public class ColonialWindow implements Window {
    @Override
    public void getDescription() {
        System.out.println("Colonial window: Wooden frame with decorative details.");
    }
}
