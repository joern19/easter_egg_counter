package org.acme.getting.started.async;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author not-a-robot
 */
@Path("/")
public class RootResource {
    
    @GET
    public Response redirect() {
        return Response.status(301).location(URI.create("https://hirschfeld.tech")).build();
    }
    
}
