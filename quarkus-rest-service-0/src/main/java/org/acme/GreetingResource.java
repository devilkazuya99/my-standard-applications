package org.acme;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    @Inject
    Logger logger;

    @Inject
    @RestClient
    ExternalService1 service1;

    @Inject
    @RestClient
    ExternalService2 service2;

    @RolesAllowed("User")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ServiceData> hello() {
        logger.info("Received request.");

        logger.info("Getting service data from service1.");
        ServiceData serviceData1 = service1.getData();

        logger.info("Getting service data from service2.");
        ServiceData serviceData2 = service2.getData();

        logger.info("Returning service data.");
        return List.of(serviceData1, serviceData2);
    }
}