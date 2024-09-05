package patterns.creational.abstract_factory.excersice.buttons;

/**
 * La fábrica abstracta asume que tienes varias familias de productos,
 * estructuradas en jerarquías de clases separadas (Botón/Checkbox). Todos los productos de
 * la misma familia tienen una interfaz común.
 *
 * Esta es la interfaz común para la familia de botones.
 */
public interface Button {
    void paint();
}
