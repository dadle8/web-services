package tk.dadle8.web.services.client;

import tk.dadle8.web.services.client.generated.Country;
import tk.dadle8.web.services.client.generated.CountryService;
import tk.dadle8.web.services.client.generated.IllegalValueTypeException;
import tk.dadle8.web.services.client.generated.IllegalIdException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/countries?wsdl");
        CountryService countryService = new CountryService(url);

        List<String> argsForQuery = new ArrayList<>(6);
        argsForQuery.addAll(Arrays.asList(args));

        switch (argsForQuery.get(0)) {
            case "search":
                search(countryService,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "create":
                create(countryService,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "update":
                update(countryService,
                        argsForQuery.get(1),
                        argsForQuery.get(2),
                        argsForQuery.get(3),
                        argsForQuery.get(4),
                        argsForQuery.get(5));
                break;
            case "delete":
                delete(countryService, argsForQuery.get(1));
                break;
            default:
                System.err.println("Unknown operation");
        }
    }

    private static void search(CountryService countryService, String id, String name, String fullname, String population, String capital) {
        try {
            List<Country> countries = countryService
                    .getCountryWebServicePort()
                    .getCountries(id, name, fullname, population, capital);
            for (Country country : countries) {
                System.out.println(
                        "Country{" + "id = " + country.getId()
                                + ", name = " + country.getName()
                                + ", fullname = " + country.getFullname()
                                + ", population = " + country.getPopulation()
                                + ", capital = " + country.getCapital()
                                + '}');
            }
            System.out.println("Total countries: " + countries.size());
        } catch (IllegalValueTypeException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void create(CountryService countryService, String id, String name, String fullname, String population, String capital) {
        try {
            System.out.println(countryService.getCountryWebServicePort().createCountry(id, name, fullname, population, capital));
        } catch (IllegalValueTypeException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void update(CountryService countryService, String id, String name, String fullname, String population, String capital) {
        try {
            System.out.println(countryService.getCountryWebServicePort().updateCountry(id, name, fullname, population, capital));
        } catch (IllegalValueTypeException | IllegalIdException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void delete(CountryService countryService, String id) {
        try {
            System.out.println(countryService.getCountryWebServicePort().deleteCountry(id));
        } catch (IllegalValueTypeException | IllegalIdException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
