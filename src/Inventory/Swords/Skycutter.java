package Inventory.Swords;

import Inventory.Weapons;

import java.security.SecureRandom;

public class Skycutter extends Weapons {

    SecureRandom random = new SecureRandom();

    public Skycutter() {
        setName("Skycutter");
        setValue("Rare");
        setWeight(5.0);
        setDamage(random.nextInt(1,5)/10.0); // Each weapon has own damage value.
    }

    @Override
    public void Attack() {

    }

    @Override
    public void SpecialAction() {

    }

}
