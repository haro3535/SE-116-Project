package Inventory.Shields;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Shield;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Aegis extends Shield {
    SecureRandom random = new SecureRandom();

    public Aegis(boolean isWield) {
        super(isWield);
        setName("Aegis");
        setValue("Epic");
        setWeight(1.6);
        setDamage(Math.round(random.nextDouble(7,14))/20.0);
        setShield(true);
        setSword(false);
        setWand(false);
    }

    @Override
    public void CalculateBlockChance() {
        setBlockChance(random.nextInt(0,5));
    }

    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(7,14))/20.0);
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getVitality()*getDamage());
            whoIsAttacking.ChargeCalculator();
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which, Characters whoWillGetHealing) {
        try {
            setStunTurn(random.nextInt(4,6));

            for (Enemy enm:
                    enemies) {
                if (enm.getName().toLowerCase().contains(which)) {
                    enm.setStunned(true);
                    enm.setHowManyTurns(enm.getHowManyTurns() + getStunTurn());
                    System.out.println("" + enm.getName() + " stunned for " + getStunTurn() + " turn!");
                }
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("One or more parameter is null!");
        }
    }
}
