package Game;

import Characters.Characters;
import Characters.Fighter;
import Characters.Healer;
import Characters.Tank;
import Characters.Enemy;
import Inventory.Armors.David_s_Armor;
import Inventory.Items;
import Inventory.Shields.Nethersbane;
import Inventory.Swords.Skycutter;
import Inventory.Wands.Prophecy;
import Inventory.Weapons;
import Inventory.Clothes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Instructive {

    Scanner scanner = new Scanner(System.in);

    public void Start(){
        System.out.println("- Welcome!!");
        System.out.println("- Cannon Fodder is RPG game and works with simple commands... ");
        System.out.println("- Here is how it works.");
        System.out.println("-------------------------------");
        System.out.println("At the beginning the game creates 3 characters and 1 enemy..");
        System.out.println("All characters have information about them selves...");
        System.out.println("For see the characters information we have a command!");
        System.out.println("\" info \" command is using for show the information about the character...");
        System.out.println("Please don't forget put a spaces between each word else program won't be able to read the command!!!!");
        System.out.println("*** By the way if you want to quit from here you can type just \"exit\" ***");
        System.out.println("Example:  fighter info");

        ArrayList<Characters> characters = new ArrayList<>();

        Characters fighter = new Fighter();
        fighter.getItems().add(new Skycutter(true));
        fighter.getItems().add(new David_s_Armor(true));
        characters.add(fighter);

        Characters healer = new Healer();
        healer.getItems().add(new Prophecy(true));
        healer.getItems().add(new Skycutter(false));
        healer.getItems().add(new David_s_Armor(true));
        characters.add(healer);

        Characters tank = new Tank();
        tank.getItems().add(new Nethersbane(true));
        tank.getItems().add(new Skycutter(false));
        tank.getItems().add(new David_s_Armor(true));
        characters.add(tank);


        boolean loop = true;
        while (loop){
            System.out.println("Enter: ");
            String input1 = scanner.nextLine().toLowerCase();
            String[] strings1 = input1.split(" ");

            if (strings1[1].equals("info")) {
                switch (strings1[0]){
                    case "fighter":
                        fighter.printCharacterInfo();
                        loop = false;
                        break;
                    case "tank":
                        tank.printCharacterInfo();
                        loop = false;
                        break;
                    case "healer":
                        healer.printCharacterInfo();
                        loop = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings1[0].equals("exit")) {
                return;
            }
        }
        System.out.println("That's it.");
        System.out.println("If you want to look the character's inventory you can type just \"inventory\"");
        System.out.println("Example:  healer inventory");

        boolean loop1 = true;
        while (loop1){
            System.out.println("Enter: ");
            String input2 = scanner.nextLine().toLowerCase();
            String[] strings2 = input2.split(" ");
            if (strings2[1].equals("inventory")) {
                switch (strings2[0]){
                    case "fighter":
                        fighter.ListInventory();
                        loop1 = false;
                        break;
                    case "tank":
                        tank.ListInventory();
                        loop1 = false;
                        break;
                    case "healer":
                        healer.ListInventory();
                        loop1 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings2[0].equals("exit")) {
                return;
            }
        }

        System.out.println("You see! That's all.");
        System.out.println("Now you can see that character has what.");
        System.out.println("Ok. What if we want the character to use something from their inventory?");
        System.out.println("Did you saw the numbers next to items?");
        System.out.println("When the item is a clothe use \"wear\" command.");
        System.out.println("After type the wear type item number that you want to wear.");
        System.out.println("Example: healer wear ( ıtem's full name)");
        System.out.println("Let's have a try!");

        boolean loop2 = true;
        while (loop2){
            System.out.println("Enter: ");
            String input3 = scanner.nextLine().toLowerCase();
            String[] strings3 = input3.split(" ");
            if (strings3[1].equals("wear")) {
                switch (strings3[0]){
                    case "fighter":
                        fighter.Wear(fighter.getItems(),strings3[2],strings3[3]);
                        loop2 = false;
                        break;
                    case "tank":
                        tank.Wear(tank.getItems(),strings3[2],strings3[3]);
                        loop2 = false;
                        break;
                    case "healer":
                        healer.Wear(healer.getItems(),strings3[2],strings3[3]);
                        loop2 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings3[0].equals("exit")) {
                return;
            }
        }

        System.out.println("Perfect!!!");
        System.out.println("Now try the \"wield\" command for wield a weapon from the inventory.");
        System.out.println("Example: healer wield 2");

        boolean loop3 = true;
        while (loop3){
            System.out.println("Enter: ");
            String input4 = scanner.nextLine().toLowerCase();
            String[] strings4 = input4.split(" ");
            if (strings4[1].equals("wield")) {
                switch (strings4[0]){
                    case "fighter":
                        fighter.Wield(fighter.getItems(),strings4[2],strings4[3]);
                        loop3 = false;
                        break;
                    case "tank":
                        tank.Wield(tank.getItems(),strings4[2],strings4[3]);
                        loop3 = false;
                        break;
                    case "healer":
                        healer.Wield(healer.getItems(),strings4[2],strings4[3]);
                        loop3 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings4[0].equals("exit")) {
                return;
            }
        }

        System.out.println("Okay. So far so good.");
        System.out.println("Well, how characters attack to enemy?");
        System.out.println("If you want to attack an enemy use \"attack\" command.");
        System.out.println("After the attack command you must type the enemy's name to attack!");
        System.out.println("Example: tank attack enemy1");
        System.out.println();

        ArrayList<Enemy> enemies = new ArrayList<>();

        Enemy enemy1 = new Enemy("Enemy1");
        System.out.println("" + enemy1.getName() + " joined to room...");
        enemies.add(enemy1);
        Enemy enemy2 = new Enemy("Enemy2");
        System.out.println("" + enemy2.getName() + " joined to room...");
        enemies.add(enemy2);
        Enemy enemy3 = new Enemy("Enemy3");
        System.out.println("" + enemy3.getName() + " joined to room...");
        enemies.add(enemy3);

        System.out.println("" + tank.getName() + " joined to room...");
        System.out.println();

        System.out.println("" + tank.getName() + " HP: " + tank.getHealthPoint());
        System.out.println("-------------------");
        System.out.println("" + enemy1.getName() + " HP: " + enemy1.getHealthPoint());
        System.out.println("" + enemy2.getName() + " HP: " + enemy2.getHealthPoint());
        System.out.println("" + enemy3.getName() + " HP: " + enemy3.getHealthPoint());

        boolean loop4 = true;
        while (loop4){
            System.out.println("Chose an enemy and attack!");
            System.out.println("Enter: ");
            String input5 = scanner.nextLine().toLowerCase();
            String[] strings5 = input5.split(" ");
            if (strings5[1].equals("attack")) {
                switch (strings5[0]){
                    case "fighter":
                        ItemActionManagement.Attack(fighter, Levels.FindEnemyObject(enemies,strings5[2]));
                        loop4 = false;
                        break;
                    case "tank":
                        ItemActionManagement.Attack(tank, Levels.FindEnemyObject(enemies,strings5[2]));
                        loop4 = false;
                        break;
                    case "healer":
                        ItemActionManagement.Attack(healer, Levels.FindEnemyObject(enemies,strings5[2]));
                        loop4 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings5[0].equals("exit")) {
                return;
            }
            for (Enemy enm:
                    enemies) {
                if (enm.getHealthPoint() == 0.0) {
                    System.out.println("" + enm.getName() + " were dead!");
                    enemies.remove(enm);
                }
            }
        }

        System.out.println("Wow! That was awesome...");
        System.out.println("But that's not over yet! After each attack action one of enemies will attack to one of the characters...");
        System.out.println("Like that...");
        SecureRandom random = new SecureRandom();

        int size = enemies.size();


        ItemActionManagement.Attack(enemies.get(random.nextInt(size)), Levels.FindCharacterObject(characters,"tank"));
        System.out.println("Your character took damage!");
        System.out.println("Reminder! Enemies always going to attack to tank if tank is alive. Else they attack other characters by random.");
        System.out.println("You can attack any enemy that you want to attack!");
        System.out.println();
        System.out.println("Ok let's move on...");
        System.out.println("Each level after all enemies were dead random items will dropped by enemies by random number of items!");
        System.out.println("After all enemies were dead the game will automatically show the dropped itmes to you.");
        System.out.println("But these items should be examined else you can not see the feature of the items!");
        System.out.println("For examine the items use \"examine\" command.");
        System.out.println("Every character have the ability of examine items!");


        ArrayList<Items> droppedItemArrayList = new ArrayList<>();
        droppedItemArrayList.add(new David_s_Armor(false));
        droppedItemArrayList.add(new Skycutter(false));

        System.out.println("---------------------------------");
        System.out.println("Items Dropped By Enemies");
        System.out.println("---------------------------------");
        for (Items itm:
                droppedItemArrayList) {
            System.out.println("- " + itm.displayName());
        }
        System.out.println("----------------");
        System.out.println("- " + droppedItemArrayList.size() + " item dropped!");
        System.out.println("---------------------------------");
        System.out.println("Now chose an item for examine...");
        System.out.println("Example: fighter examine long sword");

        boolean loop5 = true;
        while (loop5){
            System.out.println("Chose an enemy and attack!");
            System.out.println("Enter: ");
            String input6 = scanner.nextLine().toLowerCase();
            String[] strings6 = input6.split(" ");
            if (strings6[1].equals("examine")) {
                switch (strings6[0]){
                    case "fighter":
                        fighter.Examine(droppedItemArrayList, strings6[2],strings6[3]);
                        loop5 = false;
                        break;
                    case "tank":
                        tank.Examine(droppedItemArrayList, strings6[2],strings6[3]);
                        loop5 = false;
                        break;
                    case "healer":
                        healer.Examine(droppedItemArrayList, strings6[2],strings6[3]);
                        loop5 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
                for (Enemy enm:
                        enemies) {
                    if (enm.getHealthPoint() == 0.0) {
                        System.out.println("" + enm.getName() + " were dead!");
                        enemies.remove(enm);
                    }
                }
            }
            if (strings6[0].equals("exit")) {
                return;
            }
        }

        System.out.println("After or before the examination you can pick the item from ground by using \"pick\" command.");
        System.out.println("Reminder! Every item has weight, value and name.");
        System.out.println("Reminder! Each character has a strength value and character can carry weight as much as strength value of his/her.");
        System.out.println("Now let's pick items from the ground.");
        System.out.println("Example: tank pick light shield");

        boolean loop6 = true;
        while (loop6){
            System.out.println("Chose an enemy and attack!");
            System.out.println("Enter: ");
            String input7 = scanner.nextLine().toLowerCase();
            String[] strings7 = input7.split(" ");
            if (strings7[1].equals("pick")) {
                switch (strings7[0]){
                    case "fighter":
                        fighter.Pick(droppedItemArrayList, strings7[2],strings7[3]);
                        loop6 = false;
                        break;
                    case "tank":
                        tank.Pick(droppedItemArrayList, strings7[2],strings7[3]);
                        loop6 = false;
                        break;
                    case "healer":
                        healer.Pick(droppedItemArrayList, strings7[2],strings7[3]);
                        loop6 = false;
                        break;
                    default:
                        System.out.println("Be careful when you typing the name of the character!");
                        System.out.println("Try again!");
                }
            }
            if (strings7[0].equals("exit")) {
                return;
            }
        }

        System.out.println("Okayyyyy...");
        System.out.println("Last command of the gameplay!");
        System.out.println("It is \"ulti\" command.");
        System.out.println("Every weapon has a special action. ");
        System.out.println("For example if character is using sword he/she has the ability for become untouchable for a few turn.");
        System.out.println("For shield, character has the ability of stun an enemy for a few turn.And for wand, character has the ability of heal a character.");
        System.out.println("First if character is using sword you will type character name and \"ulti\"");
        System.out.println("For this example use fighter for character! Because for right now fighter is only using a sword.");
        System.out.println("Example: fighter ulti");

        boolean loop7 = true;
        while (loop7){
            System.out.println("Chose an enemy and attack!");
            System.out.println("Enter: ");
            String input8 = scanner.nextLine().toLowerCase();
            String[] strings8 = input8.split(" ");
            if (strings8[0].equals("fighter") && strings8[1].equals("ulti")) {
                ItemActionManagement.SpecialAction(fighter,enemies,strings8[3],null);
                loop7 = false;
            }
            else if (strings8[0].equals("exit")) {
                return;
            }else
                System.out.println("Be careful for the name!!!");
        }
        // TODO: ulti kısmı kaldı karakterlerin ultilerini hazır et ve kullandırt.
        // TODO: next ve exit şeylerinide ekle

    }
}