package au.com.versent;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

@Path("/api")
public class DemoResource {

  @Inject
  Logger logger;

  @GET
  @Path("/service1")
  public ServiceData handleRequest() {
    ServiceData data = new ServiceData();
    data.setName("REST Service 1");
    data.setDescription("Description of service 1");
    logger.info("Returning request from Service 1.");
    return data;
  }
}