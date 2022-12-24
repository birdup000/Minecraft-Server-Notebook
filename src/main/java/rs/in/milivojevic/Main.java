package rs.in.milivojevic;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        int maxThreads = 4;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        // Accept GET requests
        get("/api", (request, response) -> {
            String email = request.queryParams("email");
            String password = request.queryParams("psw");
            String passwordRepeat = request.queryParams("psw-repeat");
            response.status(200);
            if (email == null | password == null | passwordRepeat == null) {
                response.status(206);
                if (password != passwordRepeat) {
                    response.status(400);
                    return "Passwords don't match!";
                }
                return "Error one of the credentials aren't supplied!";
            }
            return email + passwordRepeat + password;
        });

        // Accept POST requests
        post("/api", (request, response) -> {
            String email = request.queryParams("email");
            String password = request.queryParams("psw");
            String passwordRepeat = request.queryParams("psw-repeat");
            response.status(200);
            if (email == null | password == null | passwordRepeat == null) {
                response.status(206);
                if (password != passwordRepeat) {
                    response.status(400);
                    return "Passwords don't match!";
                }
                return "Error one of the credentials aren't supplied!";
            }
            return email + passwordRepeat + password;
        });

        // Set up the CORS preflight route
        options("/api", (request, response) -> {
            // Enable CORS
            response.header("Access-Control-Allow-Origin", "");
            response.header("Access-Control-Request-Method", "");
            response.header("Access-Control-Allow-Headers", "");
            return "";
        });
    }
}