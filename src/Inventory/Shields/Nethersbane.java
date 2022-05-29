package Inventory.Shields;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Shield;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Nethersbane extends Shield {


    SecureRandom random = new SecureRandom();

    public Nethersbane(boolean isWield){
        super(isWield);
        setName("Nethersbane");
        setValue("Ordinary");
        setWeight(1.0);
        setDamage(random.nextDouble(1,5)/10.0);
        setShield(true);
        setSword(false);
        setWand(false);
        setBlockChance(random.nextInt(0,20));
        setStunTurn(random.nextInt(1,4));
    }

    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        whoGetAttacked.HealthPointCalculator(whoIsAttacking.getVitality()*getDamage());
        System.out.println("" + whoGetAttacked.getName() + " get " + whoIsAttacking.getVitality()*getDamage() + " damage!");
    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which) {
        for (Enemy enm:
             enemies) {
            if (enm.getName().toLowerCase().contains(which)) {
                enm.setStunned(true);
                enm.setHowManyTurns(getStunTurn());
                System.out.println("" + enm.getName() + " stunned for " + getStunTurn() + " turn!");
            }
        }
    }
    @Override
    public String displayClassName() {
        return getClass().getName();
    }
}
