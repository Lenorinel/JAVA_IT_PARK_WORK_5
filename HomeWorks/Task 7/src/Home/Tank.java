package Home;

public class Tank extends Transport {
    private int ammo;
    private int ammoConsupt;

    public Tank(String name, double fuelConsumption, int ammoConsupt){
        super(name,fuelConsumption);
        this.ammoConsupt = ammoConsupt;
    }

    public int getAmmoConsupt() {
        return ammoConsupt;
    }

    public void addAmmo(int ammo) {
        this.ammo += ammo;
    }

    public void go(int km) {
        super.go(km);
        this.ammo = this.ammo - km*ammoConsupt;
    }
    public void show() {
        System.out.println(this.ammo);
    }
}
