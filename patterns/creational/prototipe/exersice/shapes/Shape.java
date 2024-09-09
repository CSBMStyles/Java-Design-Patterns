package patterns.creational.prototipe.exersice.shapes;

import java.util.Objects;

public abstract class Shape {
    // Coordenadas x e y de la forma
    public int x;
    public int y;
    // Color de la forma
    public String color;

    // Constructor por defecto
    public Shape() {
    }

    // Constructor de copia
    public Shape(Shape target) {
        // Si el objeto target no es nulo, copia sus propiedades
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    // Método abstracto para clonar la forma
    public abstract Shape clone();

    // Sobrescribe el método equals para comparar dos formas
    @Override
    public boolean equals(Object object2) {
        // Verifica si el objeto es una instancia de Shape
        if (!(object2 instanceof Shape)) return false;
        Shape shape2 = (Shape) object2;
        // Compara las coordenadas y el color de las dos formas
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }
}
