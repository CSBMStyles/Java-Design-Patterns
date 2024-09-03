package patterns.creational.factory_method.own.factory;

import patterns.creational.factory_method.own.document.Document;
import patterns.creational.factory_method.own.document.PDFDocument;

// PDFDocumentFactory.java
public class PDFDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}
