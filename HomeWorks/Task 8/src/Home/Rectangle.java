package Home;

public class Rectangle extends Square {
    private double base;

    public Rectangle(double height, double base) {
        super(height);
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double calcSq() {
        return (double)(this.height * this.base);
    }
}
