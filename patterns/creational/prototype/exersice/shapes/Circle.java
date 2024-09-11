package patterns.creational.prototype.exersice.shapes;

// Clase Circle que extiende de Shape
public class Circle extends Shape {
    
    public int radius;

    // Constructor por defecto
    public Circle() {
    }

    // Constructor de copia
    public Circle(Circle target) {
        // Llama al constructor de copia de la superclase Shape
        super(target);
        // Si el objeto target no es nulo, copia su radio
        if (target != null) {
            this.radius = target.radius;
        }
    }

    // Sobrescribe el método clone para clonar un círculo
    @Override
    public Shape clone() {
        // Retorna una nueva instancia de Circle con los mismos valores
        return new Circle(this);
    }

    // Sobrescribe el método equals para comparar dos círculos
    @Override
    public boolean equals(Object object2) {
        // Verifica si el objeto es una instancia de Circle y si son iguales en la superclase
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        // Compara los radios de los dos círculos
        return shape2.radius == radius;
    }
}