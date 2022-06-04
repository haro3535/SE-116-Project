package Inventory.Wands;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Wand;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Splinter extends Wand {

    SecureRandom random = new SecureRandom();

    public Splinter(boolean isWield){
        super(isWield);
        setName("Splinter");
        setWeight(5.0);
        setValue("Ordinary");
        setWand(true);
        setShield(false);
        setSword(false);
    }
    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(4,16)/20.0));
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getIntelligence()*getDamage());
            System.out.println("" + whoGetAttacked.getName() + " get " + whoIsAttacking.getIntelligence()*getDamage() + " damage!");
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters whoWillGetHealing, ArrayList<Enemy> enemies, String which) {
        try {
            setHealingRate(random.nextDouble(5,11)/10.0);
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
