package org.fantastic;

import org.fantastic.data.Data;
import org.fantastic.data.PersonalShopper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@Component
@CacheConfig(cacheNames = Data.PERSONAL_SHOPPER_NAMES_JAVA)
public class PersonalShoppersRepository {
   private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   private Map<String, PersonalShopper> database = new HashMap<>();

   @Cacheable(unless="#result == null")
   public PersonalShopper findById(String id) {
      logger.info("Execute findById " + id);
      return database.get(id);
   }

   public void create(PersonalShopper shopper) {
      database.put(shopper.getId(), shopper);
   }

}
