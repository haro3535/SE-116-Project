package Game;

import Inventory.Items;
import Inventory.Shields.Nethersbane;
import Inventory.Swords.Skycutter;
import Inventory.Wands.Prophecy;

import java.util.ArrayList;

public class ItemManagement {
    public static boolean ClassNameForWeapons(String className){

        try {
            String[] split = className.split("\\.");

            for (String st:
                    Items.WeaponsClassNames) {
                if (st.equals(split[2])) {
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Something went wrong in class names!");
        }
        return false;
    }

    public static boolean ClassNameForClothes(String className){

        try {
            String[] split = className.split("\\.");

            for (String st:
                    Items.ClothesClassNames) {
                if (st.equals(split[2])) {
                    return true;
                }
            }
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Something went wrong in class names!");
        }
        return false;
    }

    public static ArrayList<Items> ordinary;
    public static ArrayList<Items> rare;
    public static ArrayList<Items> legendary;
    public static void CreateItem(){
        // For Ordinary
        ordinary.add(new Nethersbane(false));
        // For Rare
        rare.add(new Skycutter(false));
        // For Legendary
        legendary.add(new Prophecy(false));
    }
}
