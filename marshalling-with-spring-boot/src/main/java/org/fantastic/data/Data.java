package org.fantastic.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Data {
   public static final String PERSONAL_SHOPPER_NAMES_JAVA ="java-personal-shoppers";
   private static Random random = new Random();

   public static PersonalShopper getRandomPersonalShopper() {
      int id = random.nextInt(Data.SHOPPERS.size());
      return SHOPPERS.get(id);
   }

   public static final List<PersonalShopper> SHOPPERS = Arrays.asList(
         PersonalShopper.create("Aitor"),
         PersonalShopper.create("Ander"),
         PersonalShopper.create("Andoni"),
         PersonalShopper.create("Asier"),
         PersonalShopper.create("Eneko"),
         PersonalShopper.create("Gorka"),
         PersonalShopper.create("Koldo"),
         PersonalShopper.create("Mattin"),
         PersonalShopper.create("Amaia"),
         PersonalShopper.create("Ane"),
         PersonalShopper.create("Edurne"),
         PersonalShopper.create("Josune"),
         PersonalShopper.create("Izaro"),
         PersonalShopper.create("Neskutz"),
         PersonalShopper.create("Itxaso"),
         PersonalShopper.create("Leire"),
         PersonalShopper.create("Oihana"),
         PersonalShopper.create("Nerea"),
         PersonalShopper.create("Nekane"),
         PersonalShopper.create("Elaia"),
         PersonalShopper.create("Iker"),
         PersonalShopper.create("Unai"),
         PersonalShopper.create("Gaizka"),
         PersonalShopper.create("Imanol"),
         PersonalShopper.create("Markel"),
         PersonalShopper.create("Jon"),
         PersonalShopper.create("Mireia")
   );
}
