package patterns.creational.prototipe.exersice.cache;

import patterns.creational.prototipe.exersice.shapes.Circle;
import patterns.creational.prototipe.exersice.shapes.Rectangle;
import patterns.creational.prototipe.exersice.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {
    // Mapa para almacenar las formas en caché
    private Map<String, Shape> cache = new HashMap<>();

    // Constructor que inicializa el caché con algunas formas predefinidas
    public BundledShapeCache() {
        // Crear una instancia de Circle
        Circle circle = new Circle();
        // Establecer las propiedades del círculo
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "Green";

        // Crear una instancia de Rectangle
        Rectangle rectangle = new Rectangle();
        // Establecer las propiedades del rectángulo
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";

        // Agregar las formas al caché con sus respectivas claves
        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    // Método para agregar una forma al caché
    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    // Método para obtener una copia de una forma del caché
    public Shape get(String key) {
        // Retorna una copia clonada de la forma almacenada en el caché
        return cache.get(key).clone();
    }
}
