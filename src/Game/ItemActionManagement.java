package Game;

import Characters.Characters;
import Characters.Enemy;
import Inventory.Items;
import Inventory.Weapons;

import java.util.ArrayList;

public class ItemActionManagement {
    public static void Attack(Characters whoIsAttacking, Characters whoGetAttacked){

        try {
            for (Items itm:
                    whoIsAttacking.getItems()) {
                if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                    if (((Weapons) itm).isWield()) {
                        ((Weapons) itm).Attack(whoIsAttacking, whoGetAttacked);
                        return;
                    }
                }
            }
            System.out.println("" + whoIsAttacking.getName() + " is not using any weapon!");
        }catch (NullPointerException nullPointerException){
            System.out.println("Item array is empty!");
        }
    }

    public static void SpecialAction(Characters characters, ArrayList<Enemy> enemies, String which,Characters characters1){

        try {
            for (Items itm:
                    characters.getItems()) {
                if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                    if (((Weapons) itm).isWield()) {
                        ((Weapons) itm).SpecialAction(characters,enemies,which,characters1);
                        return;
                    }
                }
            }
            System.out.println("" + characters.getName() + " is not using any weapon!");
        }catch (NullPointerException nullPointerException){
            System.out.println("Item array is empty!");
        }
    }
}
