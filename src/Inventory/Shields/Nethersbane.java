package Inventory.Shields;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Shield;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Nethersbane extends Shield {


    SecureRandom random = new SecureRandom();

    public Nethersbane(boolean isWield){
        super(isWield);
        setName("Nethersbane");
        setValue("Ordinary");
        setWeight(0.5);
        setDamage(Math.round(random.nextDouble(1,5))/20.0);
        setShield(true);
        setSword(false);
        setWand(false);

    }

    @Override
    public void CalculateBlockChance() {
        setBlockChance(random.nextInt(0,20));
    }


    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(1,5))/20.0);
            System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
            whoGetAttacked.HealthPointCalculator(whoIsAttacking.getVitality()*getDamage());
            System.out.println("" + whoGetAttacked.getName() + " get " + Math.round(whoIsAttacking.getVitality()*getDamage()) + " damage!");
            whoIsAttacking.ChargeCalculator();
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which,Characters unNecessary) {

        try {
            setStunTurn(random.nextInt(1,4));

            for (Enemy enm:
                    enemies) {
                if (enm.getName().toLowerCase().contains(which)) {
                    enm.setStunned(true);
                    enm.setHowManyTurns(getStunTurn());
                    System.out.println("" + enm.getName() + " stunned for " + getStunTurn() + " turn!");
                }
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
