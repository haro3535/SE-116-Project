package Inventory.Armors;

import Inventory.Clothes;

import java.security.SecureRandom;

public class Kings_Armor extends Clothes {
    SecureRandom random = new SecureRandom();

    public Kings_Armor(boolean isWore) {
        super(isWore);
        setName("King's Armor");
        setValue("Epic");
        setWeight(1.6);
        setBlockPercent(random.nextInt(40,85));
    }

    @Override
    public String displayClassName() {
        return super.displayClassName();
    }
}
