package org.fantastic.data;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(
      includeClasses = { PersonalShopper.class, UUIDAdapter.class, City.class },
      schemaPackageName = "lookiero"
)
public interface LookieroContextInitializer extends SerializationContextInitializer {
}
