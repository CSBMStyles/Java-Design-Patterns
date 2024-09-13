package patterns.estructural.decorator.excersice;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        // Crear la carpeta 'excersice' si no existe
        File outDir = new File("src/patterns/estructural/decorator/excersice");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        // Crear el archivo 'OutputDemo.txt' si no existe
        File outFile = new File("src/patterns/estructural/decorator/excersice/OutputDemo.txt");
        if (!outFile.exists()) {
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("patterns/estructural/decorator/excersice/out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("patterns/estructural/decorator/excersice/out/OutputDemo.txt");

        System.out.println("- Input ≈");
        System.out.println(salaryRecords);
        System.out.println("- Encoded ≈");
        System.out.println(plain.readData());
        System.out.println("- Decoded ≈");
        System.out.println(encoded.readData());
    }
}