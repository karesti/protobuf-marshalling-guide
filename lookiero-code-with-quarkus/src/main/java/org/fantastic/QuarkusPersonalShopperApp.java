package org.fantastic;

import io.quarkus.runtime.Quarkus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuarkusPersonalShopperApp {
   private static final Logger LOGGER = LoggerFactory.getLogger(QuarkusPersonalShopperApp.class.getName());

   public static void main(String ... args) {
      LOGGER.info("Run quarkus app");
      Quarkus.run(args);
   }
}