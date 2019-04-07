package tk.dadle8.web.services;

import tk.dadle8.web.services.generated.Person;
import tk.dadle8.web.services.generated.PersonService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        List<Person> persons = personService.getPersonWebServicePort().getPersons();
        for (Person person : persons) {
            System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() + ", age: " + person.getAge());
        }
        System.out.println("Total persons: " + persons.size());
    }
}
