package Inventory;


public abstract class Clothes implements Items {

    private String name;
    private double weight;
    private String value;
    private int blockPercent;
    private boolean isWore;

    public Clothes(boolean isWore) {
        name = "Unknown";
        weight = 0.0;
        value = "Unknown";
        blockPercent = 0;
        this.isWore = isWore;
    }

    @Override
    public void printInfo(){
        System.out.println("****** Cloth's Info ******");
        System.out.println("Name: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("Value: " + getValue());
        System.out.println("Block Chance:  %" + getBlockPercent());
        System.out.println("----------------------------");
    }

    @Override
    public String displayName() {
        return getName();
    }

    @Override
    public double displayWeight() {
        return getWeight();
    }

    @Override
    public String displayValue() {
        return getValue();
    }

    @Override
    public String displayClassName() {
        return getClass().getName();
    }

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

    public int getBlockPercent() {
        return blockPercent;
    }

    public void setBlockPercent(int blockPercent) {
        this.blockPercent = blockPercent;
    }

    public boolean isWore() {
        return isWore;
    }

    public void setWore(boolean wore) {
        isWore = wore;
    }
}
