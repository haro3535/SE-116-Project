package Inventory.Armors;

import Inventory.Clothes;

import java.security.SecureRandom;

public class Old_Armor extends Clothes {
    SecureRandom random = new SecureRandom();

    public Old_Armor(boolean isWore) {
        super(isWore);
        setName("Old Armor");
        setValue("Ordinary");
        setWeight(0.2);
        setBlockPercent(random.nextInt(10,30));
    }

    @Override
    public String displayClassName() {
        return getClass().getName();
    }
}
