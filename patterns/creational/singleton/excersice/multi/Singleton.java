package patterns.creational.singleton.excersice.multi;

public final class Singleton {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        // El enfoque tomado aquí se llama bloqueo de doble verificación (DCL). 
        // Existe para prevenir condiciones de carrera entre múltiples hilos que 
        // pueden intentar obtener la instancia singleton al mismo tiempo, creando 
        // instancias separadas como resultado.
        //
        // Puede parecer que tener la variable `result` aquí es completamente 
        // inútil. Sin embargo, hay una advertencia muy importante al implementar 
        // el bloqueo de doble verificación en Java, que se resuelve introduciendo 
        // esta variable local.
        //
        // Puedes leer más información sobre los problemas de DCL en Java aquí:
        // https://refactoring.guru/java-dcl-issue

        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}