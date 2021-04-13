package org.fantastic.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Data {

   public static final String PERSONAL_SHOPPER_NAMES_PROTO = "personal-shopper-proto";

   private static Random random = new Random();

   public static PersonalShopper getRandomPersonalShopper() {
      int id = random.nextInt(Data.SHOPPERS.size());
      return SHOPPERS.get(id);
   }

   public static final List<PersonalShopper> SHOPPERS = Arrays.asList(
         PersonalShopper.create("Itxaso", City.BILBAO),
         PersonalShopper.create("Leire", City.BILBAO),
         PersonalShopper.create("Oihana", City.BILBAO),
         PersonalShopper.create("Nerea", City.BILBAO),
         PersonalShopper.create("Nekane", City.BILBAO),
         PersonalShopper.create("Elaia", City.BILBAO),
         PersonalShopper.create("Iker", City.BILBAO),
         PersonalShopper.create("Unai", City.BILBAO),
         PersonalShopper.create("Gaizka", City.BILBAO),
         PersonalShopper.create("Imanol", City.BILBAO),
         PersonalShopper.create("Markel", City.BILBAO),
         PersonalShopper.create("Jone", City.BILBAO),
         PersonalShopper.create("Miren", City.PARIS),
         PersonalShopper.create("Briguitte", City.PARIS),
         PersonalShopper.create("Carole", City.PARIS),
         PersonalShopper.create("Lucie", City.PARIS),
         PersonalShopper.create("Chloe", City.PARIS),
         PersonalShopper.create("Marlene", City.PARIS),
         PersonalShopper.create("Yoanne", City.PARIS),
         PersonalShopper.create("Stéphanie", City.PARIS),
         PersonalShopper.create("Laura", City.PARIS),
         PersonalShopper.create("Amelie", City.PARIS),
         PersonalShopper.create("Claudine", City.PARIS),
         PersonalShopper.create("Isabelle", City.PARIS),
         PersonalShopper.create("Nolia", City.PARIS),
         PersonalShopper.create("Marie", City.PARIS),
         PersonalShopper.create("Frédérique", City.PARIS)
   );
}
