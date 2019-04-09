package tk.dadle8.web.services.client;

import tk.dadle8.web.services.client.generated.Country;
import tk.dadle8.web.services.client.generated.CountryService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/countries?wsdl");
        CountryService personService = new CountryService(url);
        List<Country> countries = personService
                .getCountryWebServicePort()
                .getCountries(args[0], args[1], args[2], args[3], args[4]);
        for (Country country : countries) {
            System.out.println(
                    "Country{" + "id=" + country.getId()
                            + ", name=" + country.getName()
                            + ", fullname=" + country.getFullname()
                            + ", population=" + country.getPopulation()
                            + ", capital" + country.getCapital()
                            + '}');
        }
        System.out.println("Total countries: " + countries.size());
    }
}
