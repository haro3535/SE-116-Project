package Inventory;

public abstract class Wand extends Weapons{
    private double healingRate;
    public Wand(boolean isWield) {
        super(isWield);
        healingRate = 0.0;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Damage Multiplier: Intelligence x" + getDamage());
        System.out.println("----------------------------");
    }

    public double getHealingRate() {
        return healingRate;
    }

    public void setHealingRate(double healingRate) {
        this.healingRate = healingRate;
    }
}
