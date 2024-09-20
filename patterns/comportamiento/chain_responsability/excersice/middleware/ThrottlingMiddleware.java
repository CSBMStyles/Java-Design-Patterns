package patterns.comportamiento.chain_responsability.excersice.middleware;

/**
 * ConcreteHandler. Checks whether there are too many failed login requests.
 */
public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    /**
     * Please, not that checkNext() call can be inserted both in the beginning
     * of this method and in the end.
     *
     * This gives much more flexibility than a simple loop over all middleware
     * objects. For instance, an element of a chain can change the order of
     * checks by running its check after all other checks.
     */
    public boolean check(String email, String password) {
            // Si el tiempo actual es mayor que el tiempo actual más 60 segundos
            if (System.currentTimeMillis() > currentTime + 60_000) {
                // Reinicia el contador de solicitudes
                request = 0;
                // Actualiza el tiempo actual
                currentTime = System.currentTimeMillis();
            }
    
            // Incrementa el contador de solicitudes
            request++;
            
            // Si el número de solicitudes excede el límite permitido por minuto
            if (request > requestPerMinute) {
                System.out.println("Request limit exceeded!");
                throw new RequestLimitExceededException("Too many requests per minute.");
            }
            // Llama al siguiente método en la cadena de responsabilidad
            return checkNext(email, password);
        }
    
}
