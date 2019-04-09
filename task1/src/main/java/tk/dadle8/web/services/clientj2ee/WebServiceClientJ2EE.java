package tk.dadle8.web.services.clientj2ee;

import tk.dadle8.web.services.clientj2ee.generated.Country;
import tk.dadle8.web.services.clientj2ee.generated.CountryServiceJ2EE;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClientJ2EE {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/task1-1.0-SNAPSHOT/CountryServiceJ2EE?wsdl");
        CountryServiceJ2EE countryServiceJ2EE = new CountryServiceJ2EE(url);
        List<Country> countries = countryServiceJ2EE
                .getCountryWebServiceJ2EEPort()
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
