package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "external-api-1")
public interface ExternalService1 {

  @GET
  @Path("/service1")
  ServiceData getData();

}
