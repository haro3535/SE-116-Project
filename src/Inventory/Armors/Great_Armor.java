package Inventory.Armors;

import Inventory.Clothes;

import java.security.SecureRandom;

public class Great_Armor extends Clothes {
    SecureRandom random = new SecureRandom();

    public Great_Armor(boolean isWore) {
        super(isWore);
        setName("Great Armor");
        setValue("Rare");
        setWeight(0.8);
        setBlockPercent(random.nextInt(25,55));
    }

    @Override
    public String displayClassName() {
        return getClass().getName();
    }
}
