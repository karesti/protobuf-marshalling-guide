package org.fantastic.data;

import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.descriptors.Type;

import java.util.UUID;

@ProtoAdapter(UUID.class)
public class UUIDAdapter {
   @ProtoFactory
   UUID create(String value) {
      return UUID.fromString(value);
   }

   @ProtoField(number = 1, type = Type.STRING, defaultValue = "")
   String value(UUID value) {
      return value.toString();
   }
}
