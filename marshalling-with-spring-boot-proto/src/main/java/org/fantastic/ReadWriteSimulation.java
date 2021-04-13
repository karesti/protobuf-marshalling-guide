package org.fantastic;

import org.fantastic.data.Data;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
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
   public ReadWriteSimulation(PersonalShoppersRepository repository, RemoteCacheManager remoteCacheManager) {
      this.repository = repository;

      // TODO: Remove in 12.1.1.Final
      RemoteCache<String, String> metadataCache =
            remoteCacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
      GeneratedSchema schema = new SBSerializationContextInitializerImpl();
      metadataCache.put(schema.getProtoFileName(), schema.getProtoFile());
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
