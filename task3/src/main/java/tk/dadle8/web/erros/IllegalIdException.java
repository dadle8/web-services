package tk.dadle8.web.erros;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "tk.dadle8.web.erros.CountryServiceFault")
public class IllegalIdException extends Exception {

    private final CountryServiceFault fault;

    public IllegalIdException(String message, CountryServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public IllegalIdException(String message, CountryServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public CountryServiceFault getFaultInfo() {
        return fault;
    }
}