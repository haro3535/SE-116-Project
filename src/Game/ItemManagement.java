package Game;

import Inventory.Items;

public class ItemManagement {
    public static boolean ClassNameForWeapons(String className){

        String[] split = className.split("\\.");

        for (String st:
                Items.WeaponsClassNames) {
            if (st.equals(split[2])) {
                return true;
            }
        }
        return false;
    }

    public static boolean ClassNameForClothes(String className){

        String[] split = className.split("\\.");

        for (String st:
                Items.ClothesClassNames) {
            if (st.equals(split[2])) {
                return true;
            }
        }
        return false;
    }
}
