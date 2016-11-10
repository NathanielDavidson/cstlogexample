package edu.csumb.cst438fa16hello.rest;

import edu.csumb.cst438fa16hello.DayOfWeek;
import edu.csumb.cst438fa16hello.LoggerMe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * REST service that greets requests.
 *
 * This is a "root resource class" as explained in
 * https://jersey.java.net/documentation/latest/jaxrs-resources.html
 */
@Path("/")
public class HelloService {
    @GET
    @Path("/today")
    public String today() {
        LoggerMe.getLOG().debug("user requested today's date");
	return DayOfWeek.today();
    }

    @GET
    @Path("/hello")
    public Response hello(@QueryParam("name") String name) {
        if (name == null || name.isEmpty()) {
            LoggerMe.getLOG().debug("name was empty, sent bad request");
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            LoggerMe.getLOG().debug("valid name was entered here is the name: "+name);
            return Response.ok("hello " + name).build();
        }
    }
}
