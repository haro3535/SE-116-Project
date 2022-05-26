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
        setBlockChance(random.nextInt(0,20));
    }

    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {

    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which) {

    }
}
