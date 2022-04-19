package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(configKey = "external-api-2")
public interface ExternalService2 {

  @GET
  @Path("/service2")
  ServiceData getData();

}
