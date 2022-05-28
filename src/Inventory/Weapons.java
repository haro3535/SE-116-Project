package Inventory;

import Characters.Characters;
import Characters.Enemy;

import java.util.ArrayList;

public abstract class Weapons implements Items{

    private String name;
    private double weight;
    private String value;
    private double damage;
    private boolean isWield;
    private boolean isSword;
    private boolean isShield;
    private boolean isWand;

    public Weapons(boolean isWield) {
        name = "Unknown";
        weight = 0.0;
        value = "Unknown";
        damage = 0.0;
        this.isWield = isWield;
        isSword = false;
        isWand = false;
        isShield = false;
    }


    public void printInfo(){
        System.out.println("****** Weapon's Info ******");
        System.out.println("Name: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("Value: " + getValue());
        System.out.println("Damage Multiplier:  x" + getDamage());
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

    public abstract void Attack(Characters whoIsAttacking, Characters whoGetAttacked);
    public abstract void SpecialAction(Characters characters,ArrayList<Enemy> enemies,String which);

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

    public boolean isWield() {
        return isWield;
    }

    public void setWield(boolean wield) {
        isWield = wield;
    }

    public boolean isSword() {
        return isSword;
    }

    public void setSword(boolean sword) {
        isSword = sword;
    }

    public boolean isShield() {
        return isShield;
    }

    public void setShield(boolean shield) {
        isShield = shield;
    }

    public boolean isWand() {
        return isWand;
    }

    public void setWand(boolean wand) {
        isWand = wand;
    }
}
