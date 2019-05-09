package tk.dadle8.web.erros;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalIdExceptionMapper implements ExceptionMapper<IllegalIdException> {

    @Override
    public Response toResponse(IllegalIdException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
