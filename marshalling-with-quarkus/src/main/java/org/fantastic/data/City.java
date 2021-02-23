package org.fantastic.data;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum City {
   @ProtoEnumValue(number = 1)
   BILBAO,
   @ProtoEnumValue(number = 2)
   PARIS
}
