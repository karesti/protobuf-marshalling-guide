package org.fantastic;

import org.fantastic.data.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class ReadWriteSimulation {

   private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   private final PersonalShoppersRepository repository;

   @Autowired
   public ReadWriteSimulation(PersonalShoppersRepository repository) {
      this.repository = repository;
   }

   @Scheduled(fixedDelay = 1000)
   public void createPersonalShopper() {
      this.repository.create(Data.getRandomPersonalShopper());
   }

   @Scheduled(fixedDelay = 1000)
   public void retrievePersonalShopper() {
      logger.info("The Personal Shopper was found " + this.repository.findById(Data.getRandomPersonalShopper().getId()));
   }
}
