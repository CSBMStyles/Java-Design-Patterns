package patterns.estructural.decorator.excersice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = 6;

    /**
     * Constructor que inicializa el decorador con la fuente de datos dada.
     * 
     * @param source La fuente de datos a decorar.
     */
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    /**
     * Obtiene el nivel de compresión actual.
     * 
     * @return El nivel de compresión.
     */
    public int getCompressionLevel() {
        return compLevel;
    }

    /**
     * Establece un nuevo nivel de compresión.
     * 
     * @param value El nuevo nivel de compresión.
     */
    public void setCompressionLevel(int value) {
        compLevel = value;
    }

    /**
     * Escribe datos comprimidos en la fuente de datos.
     * 
     * @param data Los datos a escribir.
     */
    @Override
    public void writeData(String data) {
        super.writeData(compress(data)); // Escribe los datos comprimidos
        // NOTE la razon de usar super es para no llamar al metodo de la clase padre
    }

    /**
     * Lee datos de la fuente de datos y los descomprime.
     * 
     * @return Los datos descomprimidos.
     */
    @Override
    public String readData() {
        return decompress(super.readData()); // Lee y descomprime los datos
    }

    /**
     * Comprime una cadena de texto.
     * 
     * @param stringData La cadena de texto a comprimir.
     * @return La cadena comprimida en formato Base64.
     */
    private String compress(String stringData) {
        byte[] data = stringData.getBytes(); // Convierte la cadena a bytes
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data); // Escribe los datos comprimidos
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray()); // Codifica los datos comprimidos en Base64
        } catch (IOException ex) {
            return null; // En caso de error, retorna null
        }
    }

    /**
     * Descomprime una cadena de texto en formato Base64.
     * 
     * @param stringData La cadena de texto comprimida en formato Base64.
     * @return La cadena descomprimida.
     */
    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData); // Decodifica la cadena Base64 a bytes
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) { // Lee los datos descomprimidos
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray()); // Convierte los bytes descomprimidos a cadena
        } catch (IOException ex) {
            return null; // En caso de error, retorna null
        }
    }
}
