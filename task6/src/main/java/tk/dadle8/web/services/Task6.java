package tk.dadle8.web.services;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import tk.dadle8.web.services.task.CountryResource;

import java.io.IOException;
import java.net.URI;

public class Task6 {
    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) {
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new
                    PackagesResourceConfig(CountryResource.class.getPackage().getName());
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}
