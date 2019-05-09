package tk.dadle8.web.erros;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrottlingExceptionMapper implements ExceptionMapper<ThrottlingException> {

    @Override
    public Response toResponse(ThrottlingException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
