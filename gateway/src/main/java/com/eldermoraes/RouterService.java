package com.eldermoraes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/router")
public interface RouterService {
    
    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime();
}