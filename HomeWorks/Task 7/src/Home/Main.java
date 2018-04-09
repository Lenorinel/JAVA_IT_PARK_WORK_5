package Home;

public class Main {

    public static void main(String[] args) {
        Transport car = new Transport("Audi", 25);

        car.addFuel(80);
        car.go(100);
        System.out.println(car.fuelAmount);
        System.out.println("==========");

        Fly wing = new Fly("Tu144", 350, 20);

        wing.addFuel(4000);
        wing.addFlyMagic(120);
        wing.go(100);
        System.out.println(wing.fuelAmount);
        System.out.println(wing.getFlyMagic());
        System.out.println("=========");

        Tank panzer = new Tank("T34",27,2);

        panzer.addFuel(134);
        panzer.addAmmo(132);
        panzer.go(36);
        System.out.println(panzer.fuelAmount);
        panzer.show();
        System.out.println("=========");

        bike bike = new bike("Java", 13, 1.4);
                bike.addFuel(56);
        bike.startTemp(25);
        bike.go(15);
        System.out.println(bike.fuelAmount);
        System.out.println(bike.getTemp());
        System.out.println("=========");
        }

    }



