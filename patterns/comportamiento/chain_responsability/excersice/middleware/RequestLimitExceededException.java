package patterns.comportamiento.chain_responsability.excersice.middleware;

public class RequestLimitExceededException extends RuntimeException {
    public RequestLimitExceededException(String message) {
        super(message);
    }
}
