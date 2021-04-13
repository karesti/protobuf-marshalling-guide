package org.fantastic;

import org.fantastic.data.City;
import org.fantastic.data.PersonalShopper;
import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(schemaPackageName = "fantastic",
      includeClasses = { PersonalShopper.class, City.class })
public interface SBSerializationContextInitializer extends SerializationContextInitializer {
}
