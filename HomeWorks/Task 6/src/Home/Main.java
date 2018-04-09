package Home;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int z=0;
        RationalNumber RatN = new RationalNumber(15, 5);

        RatN.setT(64);
        RatN.setR(8);

        System.out.println(RatN.getT());
        System.out.println(RatN.show());
        System.out.println(RatN.toDouble());

        RationalNumber RatI = new RationalNumber();
        System.out.println(RatI.show());
        System.out.println(RatI.toDouble());
        System.out.println("Enter two numbers to calculate NOD ");

        int x = s.nextInt();
        int y = s.nextInt();

        if (RatN.nod(x, y) == 0)
            System.out.println("Wrong entering numbers");
        else
            System.out.println("Nod of you entering numbers is: " + RatN.nod(x, y));
        RatN.optimize();

    }
}
