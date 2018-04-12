package Home;

public class Main {

    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Square s1 = new Square(4);
        Triangle t1 = new Triangle(5, 3);
        Oval o1 = new Oval(3, 6);
        Rectangle r1 = new Rectangle(6, 4);

        Square sqr[] = {c1, s1, t1, o1, r1};
        for (Square square : sqr) {
            System.out.println(square.calcSq());
        }
    }
    }
}
