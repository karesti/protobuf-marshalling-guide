package org.fantastic;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@CacheConfig(cacheNames = Data.PERSONAL_SHOPPER_NAMES_JSON)
public class PersonalShoppersRepository {

   private Map<String, PersonalShopper> database = new HashMap<>();

   @Cacheable(unless="#result == null")
   public PersonalShopper findById(String id) {
      return database.get(id);
   }

   public void create(PersonalShopper shopper) {
      database.put(shopper.getId(), shopper);
   }

}
