package Home;

public class Bike extends Transport {
    private double temp, tempIncrease;

    public Bike(String model, double fuelConsumption, double tempIncrease) {
        super(model,fuelConsumption);
        this.tempIncrease = tempIncrease;
    }

    public double getTempIncrease() {
        return tempIncrease;
    }

    public void startTemp(double c){
        this.temp = c;
    }

    public void go(int km){
        super.go(km);
        this.temp = this.temp + km*tempIncrease;
    }

    public double getTemp() {
        return temp;
    }
}
