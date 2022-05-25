package Characters;

import Inventory.Items;

import java.util.ArrayList;

public abstract class Characters {

    private String name;
    private double strength;
    private double vitality;
    private double intelligence;
    private ArrayList<Items> items;
    private double healthPoint;

    public Characters() {
        name = "Unknown";
        strength = 0.0;
        vitality = 0.0;
        intelligence = 0.0;
        items = new ArrayList<>();
        healthPoint = 0.0;
    }

    public Characters(String name) {
        this.name = name;  // For enemy
    }

    public void HealthPointCalculator(double takenDamage){
        setHealthPoint(getHealthPoint()-takenDamage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getVitality() {
        return vitality;
    }

    public void setVitality(double vitality) {
        this.vitality = vitality;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }
}
