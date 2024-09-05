package patterns.creational.abstract_factory.own.app;

import patterns.creational.abstract_factory.own.factory.ColonialPropertyFactory;
import patterns.creational.abstract_factory.own.factory.ModernPropertyFactory;
import patterns.creational.abstract_factory.own.factory.PropertyFactory;

public class Main {
    public static void main(String[] args) {
        // Crear inmueble estilo moderno
        PropertyFactory modernFactory = new ModernPropertyFactory();
        Property modernProperty = new Property(modernFactory);
        System.out.println("Modern Property Description:");
        modernProperty.describe();

        System.out.println();

        // Crear inmueble estilo colonial
        PropertyFactory colonialFactory = new ColonialPropertyFactory();
        Property colonialProperty = new Property(colonialFactory);
        System.out.println("Colonial Property Description:");
        colonialProperty.describe();
    }
}
