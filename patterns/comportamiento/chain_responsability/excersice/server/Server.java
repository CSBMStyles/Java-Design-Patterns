package patterns.comportamiento.chain_responsability.excersice.server;

import patterns.comportamiento.chain_responsability.excersice.middleware.Middleware;
import patterns.comportamiento.chain_responsability.excersice.middleware.RequestLimitExceededException;

import java.util.HashMap;
import java.util.Map;

/**
 * Server class.
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    public boolean logIn(String email, String password) {
        boolean result = false;
        try {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            result = true;
        }
    }
    catch (RequestLimitExceededException e) {
        System.out.println(e.getMessage());
        result = false;
    }
    return result;
}

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}