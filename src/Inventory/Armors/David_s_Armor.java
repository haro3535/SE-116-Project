package Inventory.Armors;

import Inventory.Clothes;

import java.security.SecureRandom;

public class David_s_Armor extends Clothes {
    SecureRandom random = new SecureRandom();

    public David_s_Armor() {
        setName("David's Armor");
        setValue("Legendary");
        setWeight(10.0);
        setBlockPercent(random.nextInt(90,101));
    }

    @Override
    public void Protect() {

    }
}
