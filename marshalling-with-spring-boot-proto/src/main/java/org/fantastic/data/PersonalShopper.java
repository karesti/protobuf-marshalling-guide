package org.fantastic.data;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.Objects;
import java.util.UUID;

public class PersonalShopper {
   private String id;
   private String name;
   private City city;

   @ProtoFactory
   public PersonalShopper(String id, String name, City city) {
      this.id = id;
      this.name = name;
      this.city = city;
   }

   public static PersonalShopper create(String name, City city) {
      return new PersonalShopper(UUID.randomUUID().toString(), name, city);
   }

   @ProtoField(number = 1)
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   @ProtoField(number = 2)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @ProtoField(number = 3)
   public City getCity() {
      return city;
   }

   public void setCity(City city) {
      this.city = city;
   }

   @Override
   public String toString() {
      return "PersonalShopper{" + "id=" + id + ", name='" + name + '\'' + ", city=" + city + '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      PersonalShopper that = (PersonalShopper) o;
      return Objects.equals(id, that.id) && Objects.equals(name, that.name) && city == that.city;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, city);
   }
}
