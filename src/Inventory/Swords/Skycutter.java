package Inventory.Swords;

import Characters.Characters;
import Characters.Enemy;
import Characters.Fighter;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Skycutter extends Weapons {

    SecureRandom random = new SecureRandom();

    public Skycutter() {
        setName("Skycutter");
        setValue("Rare");
        setWeight(5.0);
        setDamage(random.nextInt(1,5)/10.0); // Each weapon has own damage value.
    }

    @Override
    public void Attack(Characters characters, String who, ArrayList<Enemy> enemies, String which) {
        enemies.get(FindEnemyIndex(which,enemies)).HealthPointCalculator(characters.getStrength()*getDamage());
    }

    @Override
    public void SpecialAction() {

    }

    public static int FindEnemyIndex(String which, ArrayList<Enemy> enemies){
        int index = 0;
        for (Enemy enm:
             enemies) {
            if (enm.getName().equals(which)) {
                index = enemies.indexOf(enm);
            }
        }
        return index;
    }

}
