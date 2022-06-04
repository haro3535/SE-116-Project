package Inventory;

public abstract class Sword extends Weapons {
    public Sword(boolean isWield) {
        super(isWield);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Damage Multiplier: Strength x" + getDamage());
        System.out.println("----------------------------");
    }
}
