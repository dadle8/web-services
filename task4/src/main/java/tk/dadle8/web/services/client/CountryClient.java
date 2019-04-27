package tk.dadle8.web.services.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import tk.dadle8.web.services.Country;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class CountryClient {

    private static final String URL = "http://localhost:8080/rest/countries";

    public static void main(String[] args) {
        Client client = Client.create();
        getCountries(client, args[0], args[1], args[2], args[3], args[4]).forEach(System.out::println);
    }

    private static List<Country> getCountries(Client client,
                                              String id,
                                              String name,
                                              String fullname,
                                              String population,
                                              String capital) {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource
                    .queryParam("id", id)
                    .queryParam("name", name)
                    .queryParam("fullname", fullname)
                    .queryParam("population", population)
                    .queryParam("capital", capital);
        }

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Country>> type = new GenericType<List<Country>>() {
        };
        return response.getEntity(type);
    }

}
