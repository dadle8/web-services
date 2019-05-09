package tk.dadle8.web.services.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import tk.dadle8.web.services.task.Country;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryClient {

    private static final String URL = "http://localhost:8080/rest/countries";

    public static void main(String[] args) {
        Client client = Client.create();

        List<String> argsForQuery = new ArrayList<>();
        argsForQuery.addAll(Arrays.asList(args));

        switch (argsForQuery.get(0)) {
            case "search":
                search(client,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "create":
                create(client,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "update":
                update(client,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "delete":
                delete(client, argsForQuery.get(1));
                break;
            default:
                System.err.println("Unknown operation");
        }
    }

    private static void search(Client client,
                               String id,
                               String name,
                               String fullname,
                               String population,
                               String capital) {
        WebResource webResource = client.resource(URL);
        webResource = webResource
                .queryParam("id", id)
                .queryParam("name", name)
                .queryParam("fullname", fullname)
                .queryParam("population", population)
                .queryParam("capital", capital);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            System.err.println(response.getEntity(new GenericType<String>() {
            }));
            return;
        }

        GenericType<List<Country>> type = new GenericType<List<Country>>() {
        };
        response.getEntity(type).forEach(System.out::println);
    }

    private static void create(Client client, String id, String name, String fullname, String population, String capital) {
        WebResource webResource = client.resource(URL);
        webResource = webResource
                .queryParam("id", id)
                .queryParam("name", name)
                .queryParam("fullname", fullname)
                .queryParam("population", population)
                .queryParam("capital", capital);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            System.err.println(response.getEntity(new GenericType<String>() {
            }));
            return;
        }

        System.out.println(response.getEntity(new GenericType<String>() {
        }));
    }

    private static void update(Client client, String id, String name, String fullname, String population, String capital) {
        WebResource webResource = client.resource(URL);
        webResource = webResource
                .queryParam("id", id)
                .queryParam("name", name)
                .queryParam("fullname", fullname)
                .queryParam("population", population)
                .queryParam("capital", capital);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            System.err.println(response.getEntity(new GenericType<String>() {
            }));
            return;
        }

        System.out.println(response.getEntity(new GenericType<String>() {
        }));
    }

    private static void delete(Client client, String id) {
        WebResource webResource = client.resource(URL);
        webResource = webResource.queryParam("id", id);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            System.err.println(response.getEntity(new GenericType<String>() {
            }));
            return;
        }

        System.out.println(response.getEntity(new GenericType<String>() {
        }));
    }
}
