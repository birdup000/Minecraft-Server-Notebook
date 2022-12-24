package rs.in.milivojevic;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);

        threadPool(20, 10, 30000); // 20 threads, 10 min idle time, 30 seconds timeout

        get("/api", (request, response) -> {
            String name = request.queryParams("name");
            return name + "<br>" + "request.queryParams";
        });
    }
}
