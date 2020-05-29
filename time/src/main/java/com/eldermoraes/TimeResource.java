package com.eldermoraes;

import java.io.ByteArrayInputStream;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
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

    private String getTime(){
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://worldclockapi.com/api/json/cet/now").request().get();
        String jsonObject = response.readEntity(String.class);
        return Json.createReader(new ByteArrayInputStream(jsonObject.getBytes())).readObject().getString("currentDateTime");
    }
}