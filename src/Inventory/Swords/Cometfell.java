package Inventory.Swords;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Sword;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Cometfell extends Sword {

    SecureRandom random = new SecureRandom();

    public Cometfell(boolean isWield) {
        super(isWield);
        setName("Cometfell");
        setValue("Ordinary");
        setWeight(0.2);
        setDamage(Math.round(random.nextDouble(1,5))/20.0); // Each weapon has own damage value.
        setSword(true);
        setWand(false);
        setShield(false);
    }

    @Override
    public void Attack(Characters whoIsAttacking, Characters whoGetAttacked) {
        try {
            setDamage(Math.round(random.nextDouble(1,5))/20.0); // Each weapon has own damage value.
            if (!whoIsAttacking.isUnTouchable()) {
                System.out.println("" + whoIsAttacking.getName() + " attacking to " + whoGetAttacked.getName());
                whoGetAttacked.HealthPointCalculator(whoIsAttacking.getStrength()*getDamage());
                whoIsAttacking.ChargeCalculator();
            }else
                System.out.println("" + whoIsAttacking.getName() + " can't attack right now. He/She will stay out for " + whoIsAttacking.getHowMuchTurnWillStayOut() + " turn!");
        }catch (NullPointerException nullPointerException){
            System.out.println("One or two of Character object is null!");
        }
    }

    @Override
    public void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which,Characters unNecessary) {
        try {
            characters.setUnTouchable(true);
            characters.setHowMuchTurnWillStayOut(random.nextInt(1,3));
            System.out.println("" + characters.getName() + " will stay out for " + characters.getHowMuchTurnWillStayOut() + " turn!");
            characters.setCharge(0);
        }catch (NullPointerException nullPointerException){
            System.out.println("One or more parameter is null!");
        }
    }

    @Override
    public String displayClassName() {
        return super.displayClassName();
    }
}
