package Home;

public class Fly extends Transport {
    private double flyMagic;
    private double flyMagicConsumpt;

    public Fly(String model, double fuelConsumption, double flyMagicConsumpt) {
        super(model,fuelConsumption);
        this.flyMagicConsumpt = flyMagicConsumpt;
    }

    public double getFlyMagicConsumpt() {
        return flyMagicConsumpt;
    }

    public void addFlyMagic(double mp) {
        this.flyMagic += mp;
    }
    public void go(int km){
        super.go(km);
        this.flyMagic = this.flyMagic - km*(flyMagicConsumpt/100);
    }
    public double getFlyMagic() {
        return flyMagic;
    }
}
