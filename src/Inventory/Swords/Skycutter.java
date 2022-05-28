package Inventory.Swords;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Sword;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Skycutter extends Sword {

    SecureRandom random = new SecureRandom();

    public Skycutter(boolean isWield) {
        super(isWield);
        setName("Skycutter");
        setValue("Rare");
        setWeight(5.0);
        setDamage(random.nextDouble(5,10)/10.0); // Each weapon has own damage value.
        setSword(true);
    }

    @Override
    public void Attack(Characters whoIsAttacking,Characters whoGetAttacked) {
        whoGetAttacked.HealthPointCalculator(whoIsAttacking.getStrength()*getDamage());
        System.out.println("" + whoGetAttacked.getName() + " get " + whoIsAttacking.getVitality()*getDamage() + " damage!");
    }

    @Override
    public void SpecialAction(Characters characters,ArrayList<Enemy> enemies,String which) {
        characters.setUnTouchable(true);
        characters.setHowMuchTurnWillStayOut(random.nextInt(2,4));  // her turn de bu sayıyı azalt
        System.out.println("" + characters.getName() + " will stay out for " + characters.getHowMuchTurnWillStayOut() + " turn!");
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
