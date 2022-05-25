package Inventory;

public abstract class Weapons implements Items{

    private String name;
    private double weight;
    private String value;
    private double damage;

    public Weapons() {
        name = "Unknown";
        weight = 0.0;
        value = "Unknown";
        damage = 0.0;
    }


    public void printInfo(){
        System.out.println("****** Weapon's Info ******");
        System.out.println("Name: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("Value: " + getValue());
        System.out.println("Damage Multiplier:  x" + getDamage());
        System.out.println("----------------------------");
    }
    public abstract void Attack();
    public abstract void SpecialAction();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
