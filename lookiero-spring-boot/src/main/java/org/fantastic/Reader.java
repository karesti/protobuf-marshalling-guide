package org.fantastic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.lang.invoke.MethodHandles;
import java.util.Random;

@Component
public class Reader {

   private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   private final PersonalShoppersRepository repository;
   private final Random random;

   @Inject
   public Reader(PersonalShoppersRepository repository) {
      this.repository = repository;
      random = new Random();
   }

   @Scheduled(fixedDelay = 1000)
   public void createOne() {
      int id = this.random.nextInt(Data.SHOPPERS.size());
      this.repository.create(Data.SHOPPERS.get(id));
   }

   @Scheduled(fixedDelay = 1000)
   public void retrieveBasqueName() {
      int id = this.random.nextInt(Data.SHOPPERS.size());
      logger.info("FIND RESULT " + this.repository.findById(Data.SHOPPERS.get(id).getId()));
   }
}
