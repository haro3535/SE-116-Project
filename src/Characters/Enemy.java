package Characters;


import Inventory.Items;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Enemy extends Characters{
    private boolean isStunned;
    private int howManyTurns;
    SecureRandom random = new SecureRandom();

    public Enemy(String name){
        super(name);
        setIntelligence(random.nextDouble(1,6));
        setStrength(random.nextDouble(1,6));
        setVitality(random.nextDouble(1,6));
        setHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setItems(new ArrayList<>());
        setStunned(false);
        setHowManyTurns(0);
        setCharge(0);
        setUltiReady(false);
    }

    @Override
    public void Examine(ArrayList<Items> dropped, String which, String which1) {
        System.out.println("Enemy don't have Examine action!");
    }
    @Override
    public void Pick(ArrayList<Items> droppedItems,String which,String which1) {
        System.out.println("Enemy don't have Pick action!");
    }

    @Override
    public void Wear(ArrayList<Items> items, String which, String which1) {
        System.out.println("Enemy don't have Wear action!");
    }
    @Override
    public void Wield(ArrayList<Items> items, String which, String which1) {
        System.out.println("Enemy don't have Wield action!");
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public int getHowManyTurns() {
        return howManyTurns;
    }

    public void setHowManyTurns(int howManyTurns) {
        this.howManyTurns = howManyTurns;
    }
}
