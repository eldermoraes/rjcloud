package com.eldermoraes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://time:8080/time")
public interface TimeService {

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime();
    
}