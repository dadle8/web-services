package tk.dadle8.web.services;

import javax.xml.ws.Endpoint;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");

        String url = "http://0.0.0.0:8080/countries";
        Endpoint.publish(url, new CountryWebService());
    }
}
