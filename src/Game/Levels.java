package Game;
import Characters.Characters;
import Characters.Enemy;
import Characters.Fighter;
import Characters.Tank;
import Characters.Healer;
import Inventory.Clothes;
import Inventory.Items;
import Inventory.Shields.Nethersbane;
import Inventory.Swords.Skycutter;
import Inventory.Wands.Prophecy;
import Inventory.Weapons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Levels {

    private static int levelNumber = 1;
    private static String userName;

    private static boolean Finished;
    private static boolean levelUp;

    private ArrayList<Enemy> enemies;
    private ArrayList<Characters> characters;
    private ArrayList<Characters> forFighter;
    private ArrayList<Items> droppedItemArrayList;
    private Tank tank;
    private Fighter fighter;
    private Healer healer;


    public Levels(){
        enemies = new ArrayList<>();
        droppedItemArrayList = new ArrayList<>();

        SecureRandom random = new SecureRandom();

        if (levelNumber == 1) {
            setCharacters(new ArrayList<>());

            Characters tank = new Tank();
            getCharacters().add(tank);

            Characters fighter = new Fighter();
            getCharacters().add(fighter);

            Characters healer = new Healer();
            getCharacters().add(healer);

        }
    }

    public void Turn(Scanner scanner,ArrayList<Enemy> enemies){

        if (isLevelUp() || levelNumber == 1) {
            SecureRandom random = new SecureRandom();

            int enemyCounter = 1;
            if (levelNumber > 1) {
                for (int i = 0; i < levelNumber; i++) {
                    enemyCounter *= 2;
                }
            }

            for (int i = 0; i < enemyCounter; i++) {
                int randomRatio = random.nextInt(100);

                Enemy enemy = new Enemy("Enemy"+(i+1));
                if (randomRatio < 80) {
                    Items weaponEnemy = new Skycutter(true);
                    enemy.getItems().add(weaponEnemy);
                } else if (randomRatio < 90) {
                    Items weaponEnemy = new Nethersbane(true);
                    enemy.getItems().add(weaponEnemy);
                }else {
                    Items weaponEnemy = new Prophecy(true);
                    enemy.getItems().add(weaponEnemy);
                }
                enemies.add(enemy);
            }
           // DroppedItemCreator(enemies);
        }
    }

    SecureRandom random1 = new SecureRandom();
    public void EnemyAttack( ArrayList<Enemy> enemies1){
        if (enemies1.size() == 0) {
            return;  // If all Enemies are dead
        }

        int enemyNumber = random1.nextInt(enemies1.size());

        if (tank.getHealthPoint() > 0.0) {
            ItemActionManagement.Attack(enemies1.get(enemyNumber),getTank());
        }else {
            int ran = random1.nextInt(2);
            if (ran == 0 && getFighter().getHealthPoint() > 0.0){
                ItemActionManagement.Attack(enemies1.get(enemyNumber),getFighter());
            }else if (getHealer().getHealthPoint() > 0.0) {
                ItemActionManagement.Attack(enemies1.get(enemyNumber),getHealer());
            }else System.out.println("All Characters Were Dead!");
        }
    }

    public void RoundEndHealing(){

        if (getHealer() != null) {
            if (getHealer().getHealthPoint()+ (getHealer().getHealthPoint()/2) <= getHealer().getMaxHealthPoint() ) {
                getHealer().setHealthPoint(getHealer().getHealthPoint() + (getHealer().getHealthPoint()/2));
            }else {
                double restHealth = getHealer().getMaxHealthPoint() - getHealer().getHealthPoint();
                getHealer().setHealthPoint(restHealth + getHealer().getHealthPoint());
            }
        }
        if (getTank() != null) {
            if (getTank().getHealthPoint()+ (getTank().getHealthPoint()/2) <= getTank().getMaxHealthPoint() ) {
                getTank().setHealthPoint(getTank().getHealthPoint() + (getTank().getHealthPoint()/2));
            }else {
                double restHealth = getTank().getMaxHealthPoint() - getTank().getHealthPoint();
                getTank().setHealthPoint(restHealth + getTank().getHealthPoint());
            }
        }
        if (getFighter() != null) {
            if (getFighter().getHealthPoint()+ (getFighter().getHealthPoint()/2) <= getFighter().getMaxHealthPoint() ) {
                getFighter().setHealthPoint(getFighter().getHealthPoint() + (getFighter().getHealthPoint()/2));
            }else {
                double restHealth = getFighter().getMaxHealthPoint() - getFighter().getHealthPoint();
                getFighter().setHealthPoint(restHealth + getFighter().getHealthPoint());
            }
        }
    }

    public void DroppedItemCreator(){

    }
    public void displayDroppedItemList(){
        System.out.println("---------------------------------");
        System.out.println("Items Dropped By Enemies");
        System.out.println("---------------------------------");
        for (Items itm:
                droppedItemArrayList) {
                if (ItemManagement.ClassNameForWeapons(itm.getClass().getName())) {
                    System.out.println("- " + ((Weapons) itm).getName());
                }

                if (ItemManagement.ClassNameForClothes(itm.getClass().getName())) {
                    System.out.println("- " + ((Clothes) itm).getName());
                }

        }
        System.out.println("----------------");
        System.out.println("- " + droppedItemArrayList.size() + " item dropped!");
        System.out.println("---------------------------------");
    }


    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Levels.userName = userName;
    }

    public static boolean isFinished() {
        return Finished;
    }

    public static void setFinished(boolean finished) {
        Finished = finished;
    }

    public static boolean isLevelUp() {
        return levelUp;
    }

    public static void setLevelUp(boolean levelUp) {
        Levels.levelUp = levelUp;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<Characters> getForFighter() {
        return forFighter;
    }

    public void setForFighter(ArrayList<Characters> forFighter) {
        this.forFighter = forFighter;
    }

    public ArrayList<Items> getDroppedItemArrayList() {
        return droppedItemArrayList;
    }

    public void setDroppedItemArrayList(ArrayList<Items> droppedItemArrayList) {
        this.droppedItemArrayList = droppedItemArrayList;
    }

    public ArrayList<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Characters> characters) {
        this.characters = characters;
    }

    public Healer getHealer() {
        return healer;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
