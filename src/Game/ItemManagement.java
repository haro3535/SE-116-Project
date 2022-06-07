package Game;

import Inventory.Armors.David_s_Armor;
import Inventory.Items;
import Inventory.Shields.Nethersbane;
import Inventory.Swords.*;
import Inventory.Wands.Prophecy;
import Inventory.Wands.Splinter;

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
        ordinary = new ArrayList<>();
        ordinary.add(new Nethersbane(false));
        ordinary.add(new Cometfell(false));
        ordinary.add(new Infamy(false));
        ordinary.add(new Splinter(false));
        // For Epic
        // TODO: Epic ayarlama yap
        // For Rare
        rare = new ArrayList<>();
        rare.add(new Skycutter(false));
        // For Legendary
        legendary = new ArrayList<>();
        legendary.add(new Prophecy(false));
        legendary.add(new David_s_Armor(false));
        legendary.add(new Soulblade(false));
        legendary.add(new Oblivion(false));
    }
}
