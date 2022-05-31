package Inventory.Wands;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Wand;


import java.security.SecureRandom;
import java.util.ArrayList;

public class Prophecy extends Wand {

    SecureRandom random = new SecureRandom();

    public Prophecy(boolean isWield){
        super(isWield);
        setName("Prophecy");
        setWeight(10.0);
        setValue("Legendary");
        setDamage(random.nextDouble(4,16)/20.0);
        setHealingRate(random.nextDouble(14,17)/10.0);
        setWand(true);
        setShield(false);
        setSword(false);
    }
    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getIntelligence()*getDamage());
            System.out.println("" + whoGetAttacked.getName() + " get " + whoIsAttacking.getVitality()*getDamage() + " damage!");
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters whoWillGetHealing, ArrayList<Enemy> enemies, String which) {
        try {
            if (whoWillGetHealing.getMaxHealthPoint() < whoWillGetHealing.getHealthPoint()+((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate())) {
                whoWillGetHealing.setHealthPoint(whoWillGetHealing.getMaxHealthPoint());
            }else {
                whoWillGetHealing.setHealthPoint((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate());
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("One or more parameter is null!");
        }
    }

    @Override
    public String displayClassName() {
        return getClass().getName();
    }
}
