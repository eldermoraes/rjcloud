package com.eldermoraes;

import java.time.Instant;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.annotation.Counted;

@Path("/time")
public class TimeResource {

    private int count = 0;

    @GET
    @Counted
    public Response hello() {
        return Response.ok(getTime() + " - " + count++ + "\n").build() ;
    }

    private Instant getTime(){
        return Instant.now();
    }
}