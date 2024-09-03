package patterns.creational.factory_method.own.factory;

import patterns.creational.factory_method.own.document.Document;

/** Definimos una clase abstracta para la factoría de documentos. */
public abstract class DocumentFactory {
    
    /* Método que crea un documento. */
    public abstract Document createDocument();
    
    /* Método que abre un documento. */
    public void openDocument() {
        Document document = createDocument();
        document.open();
    }
    
    /* Método que cierra un documento. */
    public void closeDocument() {
        Document document = createDocument();
        document.close();
    }
    
    /* Método que guarda un documento. */
    public void saveDocument() {
        Document document = createDocument();
        document.save();
    }
}
