package Inventory.Wands;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Wand;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Prophecy extends Wand {

    SecureRandom random = new SecureRandom();

    public Prophecy(boolean isWield){
        super(isWield);
        setName("Prophecy");
        setWeight(10.0);
        setValue("Legendary");
        setDamage(random.nextDouble(4,16)/10.0);
        setHealingRate(random.nextDouble(14,17)/10.0);
        setWand(true);
    }
    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        whoGetAttacked.HealthPointCalculator(whoIsAttacking.getIntelligence()*getDamage());
        System.out.println("" + whoGetAttacked.getName() + " get " + whoIsAttacking.getVitality()*getDamage() + " damage!");
    }

    @Override
    public void SpecialAction(Characters whoWillGetHealing, ArrayList<Enemy> enemies, String which) {
        if (whoWillGetHealing.getMaxHealthPoint() < whoWillGetHealing.getHealthPoint()+((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate())) {
            whoWillGetHealing.setHealthPoint(whoWillGetHealing.getMaxHealthPoint());
        }else {
        whoWillGetHealing.setHealthPoint((whoWillGetHealing.getHealthPoint()/2.0)*getHealingRate());
        }
    }
}
