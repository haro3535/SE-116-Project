package Game;

import Characters.Fighter;
import Characters.Characters;
import Characters.Healer;
import Characters.Tank;
import Characters.Enemy;
import Inventory.Armors.David_s_Armor;
import Inventory.Items;
import Inventory.Swords.Skycutter;
import Inventory.Wands.Prophecy;
import Inventory.Weapons;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Characters fighter = new Fighter();
        Characters tank = new Tank();
        Characters healer = new Healer();
        Enemy enemy = new Enemy("enemy1");
        Weapons skycutter = new Skycutter(true);
        fighter.getItems().add(skycutter);


        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        System.out.println("Enemy hp "+enemy.getHealthPoint());
        System.out.println("Fighter strength " +fighter.getStrength());
        ItemActionManagement.Attack(fighter,enemy);
        System.out.println("fighter attacked to enemy");
        ItemActionManagement.SpecialAction(fighter,enemies,"");
        System.out.println("Enemy hp "+enemy.getHealthPoint());

        System.out.println("------------------------------");

        Weapons skycutter1 = new Skycutter(true);
        enemy.getItems().add(skycutter1);
        System.out.println("tank hp " + tank.getHealthPoint());
        ItemActionManagement.Attack(enemy,tank);
        System.out.println("tank hp " + tank.getHealthPoint());
        tank.getItems().add(new David_s_Armor(true));
        ItemActionManagement.Attack(enemy,tank);
        System.out.println("Enemy attack to the tank");
        System.out.println("tank hp " + tank.getHealthPoint());






    }
}

class ItemActionManagement{

    public static void Attack(Characters whoIsAttacking, Characters whoGetAttacked){

        for (Items itm:
                whoIsAttacking.getItems()) {
            if (ItemManagement.ClassNameForWeapons(itm.getClass().getName())) {
                if (((Weapons) itm).isWield()) {
                    ((Weapons) itm).Attack(whoIsAttacking, whoGetAttacked);
                }
            }
        }
    }

    public static void SpecialAction(Characters characters,ArrayList<Enemy> enemies,String which){
        for (Items itm:
                characters.getItems()) {
            if (ItemManagement.ClassNameForWeapons(itm.getClass().getName())) {
                if (((Weapons) itm).isWield()) {
                    ((Weapons) itm).SpecialAction(characters,enemies,which);
                }
            }
        }
    }



}
