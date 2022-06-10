package Game;

import Inventory.Armors.*;
import Inventory.Items;
import Inventory.Shields.*;
import Inventory.Swords.*;
import Inventory.Wands.Crystal_Wand;
import Inventory.Wands.Holy_Wand;
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
    public static ArrayList<Items> epic;
    public static void CreateItem(){
        // For Ordinary
        ordinary = new ArrayList<>();
        ordinary.add(new Nethersbane(false));
        ordinary.add(new Cometfell(false));
        ordinary.add(new Splinter(false));
        ordinary.add(new Broken_Armor(false));
        ordinary.add(new Old_Armor(false));
        ordinary.add(new Broken_Shield(false));
        // For Rare
        rare = new ArrayList<>();
        rare.add(new Skycutter(false));
        rare.add(new Great_Armor(false));
        rare.add(new Great_Shield(false));
        rare.add(new Crystal_Wand(false));
        // For Epic
        epic = new ArrayList<>();
        epic.add(new Slayer(false));
        epic.add(new Kings_Armor(false));
        epic.add(new Aegis(false));
        epic.add(new Holy_Wand(false));
        // For Legendary
        legendary = new ArrayList<>();
        legendary.add(new Prophecy(false));
        legendary.add(new David_s_Armor(false));
        legendary.add(new Soulblade(false));
        legendary.add(new Oblivion(false));
        legendary.add(new Vigilante(false));
    }
}
