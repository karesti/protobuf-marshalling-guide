package lookiero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws Exception {
        People.PersonalShopper shopper1 = People.PersonalShopper.newBuilder().setId(UUID.randomUUID().toString())
              .setCity("BILBAO").setName("Oihana").build();

        FileOutputStream output = new FileOutputStream("people.txt");
        shopper1.writeTo(output);

        People.PersonalShopper shopper2 =
              People.PersonalShopper.parseFrom(new FileInputStream("people.txt"));

        System.out.println("1");
        System.out.println(shopper1);
        System.out.println("2");
        System.out.println(shopper2);
    }
}
