package Home;

public class Oval extends Square {
    private double rad;

    public Oval(double height, double rad) {
        super(height);
        this.rad = rad;
    }

    @Override
    public double calcSq() {
        return Math.PI * rad * height;
    }
}
