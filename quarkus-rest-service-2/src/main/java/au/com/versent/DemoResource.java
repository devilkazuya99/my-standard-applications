package au.com.versent;

import java.security.SecureRandom;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.jboss.logging.Logger;

@Path("/api")
public class DemoResource {

  @Inject
  Logger logger;

  @GET
  @Path("/service2")
  @Produces(MediaType.APPLICATION_JSON)
  @Retry(maxRetries = 8)
  public Response handleRequest() {

    ServiceData data = new ServiceData();
    data.setName("REST Service 2");
    data.setDescription("Description of service 2");

    maybeFail("Failed to generate Service Data.");
    logger.info("Returning request from Service 2.");

    return Response.ok(data).build();
  }

  private void maybeFail(String failureLogMessage) {
    if (new SecureRandom().nextBoolean()) {
      logger.error(failureLogMessage);
      throw new RuntimeException("Resource failure.");
    }
  }
}