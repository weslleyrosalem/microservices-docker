package br.com.fiap.restauranteapp.api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.fiap.restauranteapp.exception.InvalidInputException;

@Provider
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(InvalidInputException e) {

        ResponseBuilder rb = Response.status(Status.BAD_REQUEST);

        rb.entity(e.getErrors());
        return rb.build();   
    }
}