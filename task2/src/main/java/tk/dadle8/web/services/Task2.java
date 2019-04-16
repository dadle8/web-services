package tk.dadle8.web.services;

import javax.xml.ws.Endpoint;

public class Task2 {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/countries";
        Endpoint.publish(url, new CountryWebService());
    }
}
