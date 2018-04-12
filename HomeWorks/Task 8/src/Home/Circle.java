package Home;

public class Circle extends Square{

    public Circle(double height) {
        super(height);
    }

    public double calcSq() {
        return Math.PI * height * height;
    }
}
