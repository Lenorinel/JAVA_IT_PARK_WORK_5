package Home;

public class Transport {
    private String model;
    protected double fuelAmount;
    protected double fuelConsumption;

    public Transport(String model,double fuelConsumption) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
    }
    public void go(int km) {
        this.fuelAmount = this.fuelAmount - km*(fuelConsumption/100);
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
