package patterns.creational.factory_method.own.document;

/**
 * Definimos una interfaz común para todos los documentos.
 */
public interface Document {
    void open();
    void close();
    void save();
}