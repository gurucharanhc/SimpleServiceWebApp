package com.example.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("myresourceheaderinjection")
//if we make it as singleton then only one time we will see Instantiate MyResuourece ....... otherwise every request we will see Instantiate MyResuourece .......
//@Singleton  // comment this guy if we are injecting guruHeader1 and charanHeader1. If we comment singleton then for everyrequest jax-rs instantiate a new object which is waste of memory/ Think about how to come up with a optimized solution
public class MyResourceHeaderInjection {
	
	@HeaderParam("x-guru") String guruHeader1;
	@HeaderParam("x-charan") String charanHeader1;

	{
		System.out.println("Instantiate MyResuourece .......");
	}
	
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!  guruHeader1 "+ guruHeader1
        		+ "charanHeader1 " +charanHeader1;
    }
    
    
    //test url: http://localhost:8081/simple-service-webapp/webapi/myresource/otherstuff?name=guru&address="Sandiego"
   // add header param x-guru-header in postman rest client and set value to guru
    //output : other stuff, name is guruaddress is "Sandiego"Header is guru
    // Ex: http://localhost:8081/simple-service-webapp/webapi/myresourceheaderinjection/otherstuff  with header param x-guru = guru and x-charan = charan
    //output: other stuff, name is nulladdress is nullHeader is UNSET guruHeader1 gurucharanHeader1 charan
    @GET
    @Path("/otherstuff")
    public String getOtherStuff(@QueryParam("name") String name, 
    		@QueryParam("address") String address, 
    		@DefaultValue("UNSET") @HeaderParam("x-guru-header") String guruHeader){
    	
    	return "other stuff, name is "+name + "address is "+address + "Header is "+guruHeader
    			+" guruHeader1 "+ guruHeader1
        		+ " charanHeader1 " +charanHeader1;
    }
    
    @DELETE
    @Path("/otherstuff")
    public String deleteOtherStuff(){
    	return "delete other stuff";
    }
    
    
    
    //Test url : http://localhost:8081/simple-service-webapp/webapi/myresource/customers/ID-1
    @GET
    //@Path("/customers/{id}")
    //using the below we can have multiple param inside the curley braces {id: \\d+}
    @Path("/customers/ID-{id: \\d+}")
    public String getOneCustomer(@PathParam("id") String theId){
    	return "This is customer "+theId;
    }
    
    
    

}
