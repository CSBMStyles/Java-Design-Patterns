package patterns.creational.factory_method.own;

import patterns.creational.factory_method.own.factory.DocumentFactory;
import patterns.creational.factory_method.own.factory.PDFDocumentFactory;
import patterns.creational.factory_method.own.factory.WordDocumentFactory;

// Main.java
public class Main {
    /** Usamos las fábricas para crear y trabajar con los documentos. */

    public static void main(String[] args) {
        // Crear una fábrica para documentos PDF
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        pdfFactory.openDocument();

        // Crear una fábrica para documentos Word
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.openDocument();
    }
}
