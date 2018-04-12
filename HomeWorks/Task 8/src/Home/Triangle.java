package Home;

public class Triangle extends Square{
    private double base;

    public Triangle(double height, double base) {
        super(height);
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public double calcSq() {
        return (1.0/2)* this.base * this.height;
    }
}
