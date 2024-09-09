package patterns.creational.prototipe.exersice.shapes;

public class Rectangle extends Shape {
    
    public int width;
    public int height;

    // Constructor por defecto
    public Rectangle() {
    }

    // Constructor de copia
    public Rectangle(Rectangle target) {
        // Llama al constructor de copia de la superclase Shape
        super(target);
        // Si el objeto target no es nulo, copia su ancho y alto
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    // Sobrescribe el método clone para clonar un rectángulo
    @Override
    public Shape clone() {
        // Retorna una nueva instancia de Rectangle con los mismos valores
        return new Rectangle(this);
    }

    // Sobrescribe el método equals para comparar dos rectángulos
    @Override
    public boolean equals(Object object2) {
        // Verifica si el objeto es una instancia de Rectangle y si son iguales en la superclase
        if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
        Rectangle shape2 = (Rectangle) object2;
        // Compara el ancho y alto de los dos rectángulos
        return shape2.width == width && shape2.height == height;
    }
}
