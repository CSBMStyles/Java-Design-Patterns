package patterns.creational.abstract_factory.own.products;

public class ColonialDoor implements Door {
    @Override
    public void getDescription() {
        System.out.println("Colonial door: Ornate and classic design.");
    }
}
