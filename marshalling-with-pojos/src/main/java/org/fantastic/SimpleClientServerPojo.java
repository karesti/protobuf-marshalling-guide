package org.fantastic;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
import org.infinispan.commons.marshall.JavaSerializationMarshaller;

public class SimpleClientServerPojo {
   public static void main(String[] args) {
      ConfigurationBuilder builder = new ConfigurationBuilder();
      builder.addServer().host("127.0.0.1").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);
      builder.addJavaSerialAllowList(".*");
      builder.marshaller(new JavaSerializationMarshaller());
      RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());
      RemoteCache<String, Person> cache = cacheManager.getCache("pojo-personal-shoppers");
      cache.put("123", new Person("Enrique", 29));
      System.out.printf("key = %s\n", cache.get("123"));
      cacheManager.stop();
   }
}
