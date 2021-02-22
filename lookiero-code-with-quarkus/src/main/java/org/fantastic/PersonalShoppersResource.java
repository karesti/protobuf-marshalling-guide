package org.fantastic;

import io.vertx.core.json.JsonObject;
import org.fantastic.data.City;
import org.fantastic.data.PersonalShopper;
import org.infinispan.client.hotrod.DataFormat;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.UUID;
import javax.ws.rs.core.MediaType;

@Path("/lookiero")
public class PersonalShoppersResource {

    RemoteCache<String, PersonalShopper> personalShopperProtobuf;
    RemoteCache<String, PersonalShopper> personalShopperText;
    RemoteCacheManager remoteCacheManager;

    @Inject
    public PersonalShoppersResource(RemoteCacheManager remoteCacheManager) {
        this.remoteCacheManager = remoteCacheManager;
        personalShopperProtobuf = remoteCacheManager.getCache("protobuf-personal-shoppers");
        personalShopperText = remoteCacheManager.getCache("text-personal-shoppers");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Lookiero!!!";
    }

    @POST
    @Path("{city}/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonalShopper createPersonalShopper(@PathParam("city") City city, @PathParam("name") String name) {
        PersonalShopper personalShopper = new PersonalShopper(UUID.randomUUID(), name, city);
        personalShopperProtobuf.putAsync(UUID.randomUUID().toString(), personalShopper);
        return personalShopper;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonalShopper getShopper(@PathParam("id") String shopperId) {
        return personalShopperProtobuf.get(shopperId);
    }

    @GET
    @Path("text/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getShoperText(@PathParam("id") String shopperId) {
        Object s = personalShopperText
//              .withDataFormat(
//                    DataFormat.builder().keyType(org.infinispan.commons.dataconversion.MediaType.APPLICATION_OBJECT)
//                          .valueType(org.infinispan.commons.dataconversion.MediaType.APPLICATION_JSON).build())
              .get(shopperId);
        System.out.println(s);
        System.out.println(JsonObject.mapFrom(s));
        return s;
//        return personalShopperText.get(shopperId);
    }

}
