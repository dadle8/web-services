package tk.dadle8.web.erros;

public class CountryServiceFault {
    private static final String DEFAULT_MESSAGE = "Error in CounryWebService";
    protected String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public static CountryServiceFault defaultInstance() {
        CountryServiceFault fault = new CountryServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}