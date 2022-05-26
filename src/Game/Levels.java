package Game;
import Characters.Characters;
import Characters.Enemy;
import Characters.Fighter;
import Characters.Tank;
import Characters.Healer;
import Inventory.Clothes;
import Inventory.Items;
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
}
