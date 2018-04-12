package Home;

public class Square {
    protected double height;

    public double getHeight() {
        return height;
    }

    public Square(double height) {

        this.height = height;
    }

    public double calcSq() {
        return (double)(this.height * this.height);
    }
}
