import java.util.Scanner;

public class StringPool {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        String str3 = "Hell" + "o";

        String str4 = new String("Hello");

        System.out.println("Standard comp");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println("Comp with \"new\" String");
        System.out.println(str1 == str4);

        System.out.println("Reassign with .intern()");
        str4 = str4.intern();//.intern() returns a String and adds it to the pool, now it adds "Hello" which is already addressed
        System.out.println(str1 == str4);

        System.out.println("Testing Scanner");
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter now: (Hello)");
        String str5 = scnr.next();

        System.out.println(str1 == str5);//Turns out .next() returns a new String, so not in the pool
        //makes sense, now we can understand why zyBook practices did not allowed ==
        //but still we can add this value into the pool

        System.out.println("Adding to pool");
        str5 = str5.intern();//We add it here with .intern()

        System.out.println(str1 == str5);//Now it is true

        str2 += " world"; //would changing a String in the address cause any changes in the other ones?
        System.out.println(str1);
        System.out.println(str2);
    }
}
