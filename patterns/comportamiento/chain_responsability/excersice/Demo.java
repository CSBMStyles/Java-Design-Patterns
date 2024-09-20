package patterns.comportamiento.chain_responsability.excersice;

import patterns.comportamiento.chain_responsability.excersice.middleware.Middleware;
import patterns.comportamiento.chain_responsability.excersice.middleware.RequestLimitExceededException;
import patterns.comportamiento.chain_responsability.excersice.middleware.RoleCheckMiddleware;
import patterns.comportamiento.chain_responsability.excersice.middleware.ThrottlingMiddleware;
import patterns.comportamiento.chain_responsability.excersice.middleware.UserExistsMiddleware;
import patterns.comportamiento.chain_responsability.excersice.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success = false;
        boolean exceptionOccurred = false;
        do {
            try {
                System.out.print("Enter email: ");
                String email = reader.readLine();
                System.out.print("Input password: ");
                String password = reader.readLine();

                // Intentamos iniciar sesión
                success = server.logIn(email, password);

            } catch (RequestLimitExceededException e) {
                // Manejar la excepción de límite de solicitudes y salir del bucle
                System.out.println(e.getMessage());
                exceptionOccurred = true; // Activar bandera de excepción
            }
        } while (!success && exceptionOccurred);
    }
}
