package rs.in.milivojevic;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);
        int maxThreads = 4;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        get("/api", (request, response) -> {
            String name = request.queryParams("name");
            return name + "<br>" + "request.queryParams";
        });
    }
}
