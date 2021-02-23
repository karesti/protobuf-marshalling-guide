package org.fantastic;

import io.quarkus.infinispan.client.Remote;
import io.quarkus.scheduler.Scheduled;
import org.fantastic.data.Data;
import org.fantastic.data.PersonalShopper;
import org.infinispan.client.hotrod.RemoteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonalShoppersReadWriteSimulation {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalShoppersReadWriteSimulation.class.getName());

    @Inject
    @Remote("protobuf-personal-shoppers")
    RemoteCache<String, PersonalShopper> personalShopperProtobuf;

    @Scheduled(every = "1s")
    public void createPersonalShopper() {
        PersonalShopper personalShopper = Data.getRandomPersonalShopper();
        personalShopperProtobuf.putAsync(personalShopper.getId().toString(), personalShopper)
              .whenComplete((a, er) -> LOGGER.info("Personal Shopper created"));

    }

    @Scheduled(every = "2s")
    public void getShopper() {
        personalShopperProtobuf.getAsync(Data.getRandomPersonalShopper().getId().toString())
              .whenComplete((data, er) -> {
                  LOGGER.info("Personal Shopper Read");
                  LOGGER.info(data.toString());
              });
    }
}
