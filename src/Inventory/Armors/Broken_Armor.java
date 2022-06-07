package Inventory.Armors;

import Inventory.Clothes;

import java.security.SecureRandom;

public class Broken_Armor extends Clothes {
    SecureRandom random = new SecureRandom();

    public Broken_Armor(boolean isWore) {
        super(isWore);
        setName("Broken Armor");
        setValue("Ordinary");
        setWeight(0.2);
        setBlockPercent(random.nextInt(10,30));
    }

    @Override
    public String displayClassName() {
        return super.displayClassName();
    }
}
