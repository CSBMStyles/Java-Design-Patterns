package patterns.creational.prototype.exersice;

import java.util.ArrayList;
import java.util.List;

import patterns.creational.prototype.exersice.shapes.Circle;
import patterns.creational.prototype.exersice.shapes.Rectangle;
import patterns.creational.prototype.exersice.shapes.Shape;

public class Demo {
    public static void main(String[] args) {
        // Lista original de formas
        List<Shape> shapes = new ArrayList<>();
        // Lista para almacenar las copias de las formas
        List<Shape> shapesCopy = new ArrayList<>();

        // Crear una instancia de Circle
        Circle circle = new Circle();
        // Establecer las propiedades del círculo
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        // Agregar el círculo a la lista original de formas
        shapes.add(circle);

        // Clonar el círculo y agregar la copia a la lista original de formas
        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        // Crear una instancia de Rectangle
        Rectangle rectangle = new Rectangle();
        // Establecer las propiedades del rectángulo
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        // Agregar el rectángulo a la lista original de formas
        shapes.add(rectangle);

        // Clonar y comparar las formas
        cloneCompare(shapes, shapesCopy);
    }

    // Método para clonar y comparar las formas
    private static void cloneCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        // Clonar cada forma de la lista original y agregarla a la lista de copias
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        // Comparar las formas originales con sus copias
        for (int i = 0; i < shapes.size(); i++) {
            // Verificar si las formas son objetos diferentes
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                // Verificar si las formas son idénticas
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
