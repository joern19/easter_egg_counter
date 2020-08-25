package org.acme.getting.started.async;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author not-a-robot
 */
@Path("/counter")
public class CounterResource {
    
    @Inject
    private CounterCache cc;
    
    @POST
    @Transactional
    @Path("/addOne")
    public Response add() {
        cc.addOne();
        return Response.status(204).build();
    }
    
    @GET
    @Path("/value")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getValue() {
        return Response.ok(Long.toString(cc.getValue())).build();
    }
}
