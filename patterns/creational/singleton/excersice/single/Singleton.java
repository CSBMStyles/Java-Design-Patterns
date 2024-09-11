package patterns.creational.singleton.excersice.single;

public final class Singleton {

    // Variable estática para almacenar la única instancia de la clase Singleton
    private static Singleton instance;
    
    // Variable pública para almacenar un valor asociado a la instancia
    public String value;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase
    private Singleton(String value) {
        // El siguiente código emula una inicialización lenta
        try {
            Thread.sleep(1000); // Pausa la ejecución durante 1 segundo
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value; // Asigna el valor pasado al constructor a la variable de instancia
    }

    // Método estático para obtener la única instancia de la clase Singleton
    public static Singleton getInstance(String value) {
        // Si la instancia aún no ha sido creada, se crea una nueva
        if (instance == null) {
            instance = new Singleton(value);
        }
        // Devuelve la instancia única de la clase Singleton
        return instance;
    }
}
