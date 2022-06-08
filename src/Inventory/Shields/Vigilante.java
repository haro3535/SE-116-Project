package Inventory.Shields;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Shield;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Vigilante extends Shield {
    SecureRandom random = new SecureRandom();

    public Vigilante(boolean isWield) {
        super(isWield);
        setName("Vigilante");
        setValue("Legendary");
        setWeight(3.2);
        setDamage(Math.round(random.nextDouble(9,16))/20.0);
        setShield(true);
        setSword(false);
        setWand(false);
    }

    @Override
    public void CalculateBlockChance() {
        setBlockChance(random.nextInt(0,3));
    }

    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(9,16))/20.0);
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getVitality()*getDamage());
            whoIsAttacking.ChargeCalculator();
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which, Characters characters1) {
        try {
            setStunTurn(random.nextInt(6,8));

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
