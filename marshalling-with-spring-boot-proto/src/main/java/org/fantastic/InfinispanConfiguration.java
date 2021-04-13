package org.fantastic;

import org.fantastic.data.Data;
import org.infinispan.commons.marshall.ProtoStreamMarshaller;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
public class InfinispanConfiguration {

   @Bean
   @Order(Ordered.HIGHEST_PRECEDENCE)
   public InfinispanRemoteCacheCustomizer caches() {
      return b -> {
         b.remoteCache(Data.PERSONAL_SHOPPER_NAMES_PROTO).marshaller(ProtoStreamMarshaller.class);

         // TODO: Remove in 12.1.1.Final
         b.addContextInitializer(new SBSerializationContextInitializerImpl());
      };
   }
}
