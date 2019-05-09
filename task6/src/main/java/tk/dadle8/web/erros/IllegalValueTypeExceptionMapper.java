package tk.dadle8.web.erros;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalValueTypeExceptionMapper implements ExceptionMapper<IllegalValueTypeException> {

    @Override
    public Response toResponse(IllegalValueTypeException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
