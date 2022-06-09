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
        setValue("Legendary");
        setWeight(3.2);
        setDamage(Math.round(random.nextDouble(9,16))/20.0);
        setWand(true);
        setShield(false);
        setSword(false);
    }
    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(9,16))/20.0);
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getIntelligence()*getDamage());
            whoIsAttacking.ChargeCalculator();
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters whoIsHealing, ArrayList<Enemy> enemies, String which ,Characters whoWillGetHealing) {
        try {
            setHealingRate(random.nextDouble(14,17)/10.0);
            if (whoWillGetHealing.getMaxHealthPoint() < whoWillGetHealing.getHealthPoint()+((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate())) {
                System.out.println("" + whoIsHealing.getName() + " healed +" + (whoWillGetHealing.getMaxHealthPoint()-whoWillGetHealing.getHealthPoint()) + " hp" + whoWillGetHealing.getName());
                whoWillGetHealing.setHealthPoint(whoWillGetHealing.getMaxHealthPoint());
            }else {
                System.out.println("" + whoIsHealing.getName() + " healed +" + ((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate()) + " hp" + whoWillGetHealing.getName());
                whoWillGetHealing.setHealthPoint(whoWillGetHealing.getHealthPoint()+(whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate());
            }
            whoIsHealing.setCharge(0);
        }catch (NullPointerException nullPointerException){
            System.out.println("One or more parameter is null!");
        }
    }

    @Override
    public String displayClassName() {
        return getClass().getName();
    }
}
