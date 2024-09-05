package patterns.creational.abstract_factory.own.products;

public class ModernWindow implements Window {
    @Override
    public void getDescription() {
        System.out.println("Modern window: Large glass with minimal frame.");
    }
}
