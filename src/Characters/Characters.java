package Characters;

import Inventory.Clothes;
import Inventory.Items;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public abstract class Characters {

    private String name;
    private double strength;
    private double vitality;
    private double intelligence;
    private ArrayList<Items> items;
    private double healthPoint;
    private boolean unTouchable;
    private int howMuchTurnWillStayOut;
    private double maxHealthPoint;

    public Characters() {
        name = "Unknown";
        strength = 0.0;
        vitality = 0.0;
        intelligence = 0.0;
        items = new ArrayList<>();
        healthPoint = 0.0;
        unTouchable = false;
        howMuchTurnWillStayOut = 0;
    }

    public Characters(String name) {
        this.name = name;  // For enemy
    }

    SecureRandom random = new SecureRandom();
    public void HealthPointCalculator(double takenDamage){

        boolean isWoreAnything = false;
        for (Items itm:
             getItems()) {
            if (((Clothes) itm).isWore()) {
                isWoreAnything = true;
                setHealthPoint(
                        getHealthPoint() - (takenDamage - (takenDamage*(((Clothes) itm).getBlockPercent()/100.0))) // Armor decreases taken damage
                        );
            }
        }
        if (!isWoreAnything) {
            setHealthPoint(getHealthPoint()-takenDamage);
        }

    }

    public void StayOut(boolean unTouchable,int turn){
        setUnTouchable(unTouchable);
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

    public boolean isUnTouchable() {
        return unTouchable;
    }

    public void setUnTouchable(boolean unTouchable) {
        this.unTouchable = unTouchable;
    }

    public int getHowMuchTurnWillStayOut() {
        return howMuchTurnWillStayOut;
    }

    public void setHowMuchTurnWillStayOut(int howMuchTurnWillStayOut) {
        this.howMuchTurnWillStayOut = howMuchTurnWillStayOut;
    }

    public double getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(double maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }
}
