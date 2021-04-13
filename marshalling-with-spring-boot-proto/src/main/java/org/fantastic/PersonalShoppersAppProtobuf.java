package org.fantastic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PersonalShoppersAppProtobuf {

   public static void main(String... args) {
      new SpringApplicationBuilder().sources(PersonalShoppersAppProtobuf.class).run(args);
   }
}
