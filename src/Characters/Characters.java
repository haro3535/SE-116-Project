package Characters;

import Game.ItemManagement;

import Inventory.Clothes;
import Inventory.Items;
import Inventory.Shield;
import Inventory.Weapons;


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
    private int charge;
    private boolean isUltiReady;

    public Characters() {
        name = "Unknown";
        strength = 0.0;
        vitality = 0.0;
        intelligence = 0.0;
        items = new ArrayList<>();
        healthPoint = 0.0;
        unTouchable = false;
        howMuchTurnWillStayOut = 0;
        charge = 0;
        isUltiReady = false;
    }

    public Characters(String name) {  // For enemy
        this.name = name;
        strength = 0.0;
        vitality = 0.0;
        intelligence = 0.0;
        items = new ArrayList<>();
        healthPoint = 0.0;
        unTouchable = false;
        howMuchTurnWillStayOut = 0;
        charge = 0;
        isUltiReady = false;
    }


    public void HealthPointCalculator(double takenDamage){

        Clothes armor = null;
        Shield shield = null;

        boolean isWoreAnything = false;
        boolean isWieldShield = false;
        try {
            for (Items itm:
                    getItems()) {
                if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                    if (((Weapons) itm).isWield() && ((Weapons) itm).isShield()) {
                        shield = (Shield) itm;
                        isWieldShield = true;
                    }
                }
                else if (ItemManagement.ClassNameForClothes(itm.displayClassName())) {
                    if (((Clothes) itm).isWore()) {
                        armor = (Clothes) itm;
                        isWoreAnything = true;
                    }
                }
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Item's array is empty!");
        }

        try {
            if (isWieldShield && !isWoreAnything) {
                shield.CalculateBlockChance();
                double damage = takenDamage*shield.getBlockChance();
                if (damage > 0.0) {
                    setHealthPoint(getHealthPoint()-takenDamage);
                }else System.out.println("Blocked!");
            }

            if (isWoreAnything && !isWieldShield) {
                setHealthPoint(
                        getHealthPoint()- (takenDamage - (takenDamage*(armor.getBlockPercent()/100.0)))
                );
            }

            if (isWieldShield && isWoreAnything) {
                shield.CalculateBlockChance();
                double damage = takenDamage*shield.getBlockChance();
                if (damage > 0.0) {
                    setHealthPoint(
                            getHealthPoint()- (takenDamage - (takenDamage*(armor.getBlockPercent()/100.0)))
                    );
                }else System.out.println("Blocked!");

            }

            if (!isWieldShield && !isWoreAnything){
                setHealthPoint(getHealthPoint()-takenDamage);
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("HealthPointCalculator has a problem about object Clothe or object Shield!");
        }
    }
    public abstract void Examine(ArrayList<Items> dropped,String which,String which1);
    public abstract void Pick(ArrayList<Items> droppedItems,String which,String which1);
    public abstract void Wear(ArrayList<Items> items, String which, String which1);
    public abstract void Wield(ArrayList<Items> items, String which, String which1);


    public void ListInventory(){
        System.out.println("************************");
        System.out.println("" + getName() + "'s Inventory");
        System.out.println("************************");
        try {
            for (Items itm:
                    getItems()) {
                itm.printInfo();
                System.out.print(" - Item Number: " + getItems().indexOf(itm) + "\n");
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Item's array is empty!");
        }
    }

    public void CheckCharge(){
        if (getCharge() == 100) {
            setUltiReady(true);
        }
    }

    public String Ready(){
        if (isUltiReady()) {
            return "Ready";
        }else return "Not Ready";
    }

    public void printCharacterInfo(){
        System.out.println("************************");
        System.out.println("Character's information");
        System.out.println("************************");
        System.out.println("Name: " + getName());
        System.out.println("Strength: " + Math.round(getStrength()));
        System.out.println("Vitality: " + Math.round(getVitality()));
        System.out.println("Intelligence: " + Math.round(getIntelligence()));
        System.out.printf("%s%.1f%n","HP: ", getHealthPoint());
       // System.out.println("Charge: " + getCharge());
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

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public boolean isUltiReady() {
        return isUltiReady;
    }

    public void setUltiReady(boolean ultiReady) {
        isUltiReady = ultiReady;
    }
}
