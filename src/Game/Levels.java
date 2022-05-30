package Game;
import Characters.Characters;
import Characters.Enemy;
import Characters.Fighter;
import Characters.Tank;
import Characters.Healer;
import Inventory.Clothes;
import Inventory.Items;
import Inventory.Shields.Nethersbane;
import Inventory.Sword;
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


        if (levelNumber == 1) {
            setCharacters(new ArrayList<>());

            Tank tank = new Tank();
            setTank(tank);
            getCharacters().add(tank);

            Fighter fighter = new Fighter();
            setFighter(fighter);
            getCharacters().add(fighter);

            Healer healer = new Healer();
            setHealer(healer);
            getCharacters().add(healer);

        }
    }

    public void Turn(Scanner scanner){

        if (isLevelUp() || levelNumber == 1) {
            SecureRandom random = new SecureRandom();

            int enemyCounter = 1;
            if (levelNumber > 1) {
                for (int i = 1; i < levelNumber; i++) {
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
            DroppedItemCreator(enemies);
        }


        setLevelUp(false);
        while (!isLevelUp()){
            System.out.println("---------------------------");
            System.out.println("Characters and Enemies information");
            System.out.println("---------------------------");
            for (Characters ch:
                    characters) {
                System.out.println("- Name: " + ch.getName());
                System.out.println("- Charge:" + ch.getCharge() + "  - SpecialAction: " + ch.Ready());
                System.out.printf("%s%.1f%n","- HP: ", ch.getHealthPoint());
                System.out.println("---------");
            }
            System.out.println("---------------------------");
            int enemyCounter = 0;
            for (Enemy enm:
                    enemies) {
                System.out.printf("%s%s%s%.1f%s%d%n","- Name: ",enm.getName(),"  - HP: ", enm.getHealthPoint(),"  - Number: ", enemyCounter);
                System.out.println("---------");
                enemyCounter++;
            }

            System.out.println("----------------------------------------------------------------");
            System.out.println("For One Word Commands    ->    Next , Exit , ...");
            System.out.println("For Two Word Commands    ->    (Character's Name) Info , (Character's Name) Inventory , (Character's Name) Ulti, ...");
            System.out.println("For Three Word Commands  ->    (Character's Name)  (function) (Enemy's Name) , (Character's Name) (function) (Character's Name),");
            System.out.println("                         ->    (Character's Name)  (function) (Dropped Item's Item Number) , (Character's Name)  (function) (Character Item's Item Number)");
            System.out.println("----------------------------------------------------------------");
            System.out.print("Enter: ");

            boolean inputLoop = true;
            while (inputLoop){
                String input = scanner.nextLine().toLowerCase();
                String[] splitInput1 = input.split(" ");  // For split input

                int arraySize = 0;
                for (String st:
                     splitInput1) {
                    if (!st.equals("")) {
                        arraySize++;
                    }
                }
                String[] splitInput = new String[arraySize];
                int alignment = 0;
                for (String s : splitInput1) {
                    if (!s.equals("")) {
                        splitInput[alignment] = s;
                        alignment++;
                    }
                }

                switch (splitInput.length){
                    case 1:
                        switch (splitInput[0]){
                            case "next":
                                if (getEnemies().size() == 0 ) {
                                    RoundEndHealing();
                                    setLevelUp(true);
                                    inputLoop = false;
                                    System.out.println("Moving to the next level!");
                                    System.out.println("------------");
                                    continue;
                                }else System.out.println("You can't move on to next level. There is an enemy still alive!");
                                break;
                            case "exit":
                                System.out.println("Exited from the Game!!");
                                setFinished(true);
                                System.out.println("Your score is " + Score);
                                SaveScore();
                                return;
                            default:
                                System.out.println("Unaccepted command " + input);
                                System.out.println("Please enter appropriate command!");
                        }
                        break;
                    case 2:
                        switch (splitInput[1]){
                            case "info":
                                if (splitInput[0].contains("enemy")) {
                                    getEnemies().get(FindEnemyIndex(getEnemies(),splitInput[0])).printCharacterInfo();
                                }else {
                                getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).printCharacterInfo();
                                }
                                break;
                            case "inventory":
                                getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).ListInventory();
                                break;
                            case "ulti":
                                boolean isSword = false;
                                String whoCalled = "Unknown";
                                for (Characters c:
                                        getCharacters()) {
                                    if (c.getName().toLowerCase().contains(splitInput[0])) {
                                        for (Items itm:
                                                c.getItems()) {
                                            if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                                                if (((Weapons) itm).isSword() && ((Weapons) itm).isWield()) {
                                                    ItemActionManagement.SpecialAction(c,getEnemies(),"");
                                                    isSword = true;
                                                }
                                            }
                                            whoCalled = c.getName();
                                        }
                                    }
                                }
                                if (!isSword) {
                                    System.out.println("" + whoCalled + " is not using a sword right now!");
                                    System.out.println("Please be more careful.");
                                }
                                break;
                            default:
                                System.out.println("Unaccepted function " + splitInput[1]);
                                System.out.println("Please enter appropriate command!");
                        }
                        break;
                    case 3:
                        switch (splitInput[1]){
                            case "attack":
                                Characters characters1 = getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0]));
                                ItemActionManagement.Attack(characters1,getEnemies().get(FindEnemyIndex(getEnemies(),splitInput[2])));
                                DeadEnemy(getEnemies(),splitInput[2]);
                                EnemyAttack(getEnemies());
                                DeadAllies(getCharacters());
                                characters1.CheckCharge();
                                if (characters1.isUltiReady()) {
                                    System.out.println("" + characters1.getName() + " SpecialAction: " + characters1.Ready());
                                }
                                if (getEnemies().size() == 0) {
                                    displayDroppedItemList();
                                    levelNumber++;
                                }
                                break;
                            case "ulti":
                                for (Characters ch: getCharacters()) {
                                    if (ch.getName().toLowerCase().contains(splitInput[0])) {

                                        Weapons usingWeapon = FindWieldWeapon(ch);
                                        Characters character = FindCharacterObject(getCharacters(),splitInput[0]);

                                        if (usingWeapon != null && usingWeapon.isSword() && character != null) {
                                            System.out.println("" + ch.getName() + " is using a sword your command must be 2 word!");
                                            System.out.println("Please enter appropriate command");
                                        }
                                        if (usingWeapon != null && usingWeapon.isShield() && character != null) {
                                            ItemActionManagement.SpecialAction(ch,getEnemies(),splitInput[2]);
                                        }
                                        if (usingWeapon != null && usingWeapon.isWand() && character != null) {
                                            ItemActionManagement.SpecialAction(ch,null,splitInput[2]);
                                            ItemActionManagement.Attack(character,getEnemies().get(FindEnemyIndex(getEnemies(),splitInput[2])));
                                            DeadEnemy(getEnemies(),splitInput[2]);
                                            EnemyAttack(getEnemies());
                                            DeadAllies(getCharacters());
                                            isAllEnemyWereDead(getEnemies());
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Unaccepted function " + splitInput[1]);
                                System.out.println("Please enter appropriate function!");
                        }
                        break;
                    case 4:
                        switch (splitInput[1]){
                            case "pick":
                                if (enemies.size() == 0) {
                                    boolean hasPicked = false;
                                    int who = 0;
                                    for (Characters ch :
                                            getCharacters()) {
                                        if (ch.getName().toLowerCase().contains(splitInput[0])) {
                                            ch.Pick(getDroppedItemArrayList(), splitInput[2], splitInput[3]);
                                            who = getCharacters().indexOf(ch);
                                            hasPicked = true;
                                        }
                                    }
                                    if (!hasPicked) {
                                        System.out.println("" + getCharacters().get(who).getName() + " couldn't pick the item");
                                        System.out.println("Check your command again!");
                                    }
                                } else System.out.println("You can't pick items. There is an enemy still alive!");
                                break;
                            case "wear":
                                getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).
                                        Wear(getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).getItems(),splitInput[2],splitInput[3]);
                                break;
                            case "wield":
                                getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).
                                        Wield(getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).getItems(),splitInput[2],splitInput[3]);
                                break;
                            case "examine":
                                if (enemies.size() == 0) {
                                    getCharacters().get(FindCharacterIndex(getCharacters(),splitInput[0])).Examine(getDroppedItemArrayList(),splitInput[2],splitInput[3]);
                                }else System.out.println("You can't examine items. There is an enemy still alive!");
                                break;
                            default:
                                System.out.println("Unaccepted function " + splitInput[1]);
                                System.out.println("Please enter appropriate function!");
                        }
                        break;
                    default:
                        System.out.println("Please enter appropriate command!");
                }
            }
        }
    }

    SecureRandom random1 = new SecureRandom();
    public void EnemyAttack(ArrayList<Enemy> enemies1){
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

    public void DeadEnemy(ArrayList<Enemy> enemies, String who){
        int to = 0;
        for (Enemy enm:
                enemies) {
            if (enm.getName().toLowerCase().contains(who)) {
                to = enemies.indexOf(enm);
            }
        }
        if (enemies.get(to).getHealthPoint() <= 0.0) {
            System.out.println("" + enemies.get(to).getName() + " were dead!");
            enemies.remove(to);
            ScoreCalculator(1);
        }
    }

    public void isAllEnemyWereDead(ArrayList<Enemy> enemies){
        if (enemies.size() == 0) {
            displayDroppedItemList();
            levelNumber++;
        }
    }

    public void DeadAllies(ArrayList<Characters> characters){
        for (Characters ch:
             characters) {
            if (ch.getHealthPoint() <= 0.0) {
                System.out.println("" + ch.getName() + " were dead!");
                characters.remove(ch);
                switch (ch.getClass().getName()) {
                    case "Characters.Fighter" -> setFighter(null);
                    case "Characters.Healer" -> setHealer(null);
                    case "Characters.Tank" -> setTank(null);
                    default -> System.out.println("Could not get class name! ");
                }
            }
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

    public void DroppedItemCreator(ArrayList<Enemy> enemies){
        int itemCreated = random1.nextInt(enemies.size());

        if (getDroppedItemArrayList() != null || levelNumber > 1) {
            getDroppedItemArrayList().clear(); // Each level start the array must be empty!
        }

        for (int i = 0; i < itemCreated; i++) {
            int weaponOrCloth = random1.nextInt(2);

            if (weaponOrCloth == 0) {
                int dropChance = random1.nextInt(1,101);
                if (dropChance >= 1 && dropChance <= 85 ) {

                }
            }
        }
    }
    public void displayDroppedItemList(){
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
    }

    public static int FindCharacterIndex(ArrayList<Characters> characters, String who){
        int index = 0;
        for (Characters ch:
                characters) {
            if (ch.getName().toLowerCase().contains(who)) {
                index = characters.indexOf(ch);
            }
        }
        return index;
    }

    public static Characters FindCharacterObject(ArrayList<Characters> characters , String who){

        for (Characters obName:
             characters) {
            if (obName.getName().toLowerCase().equals(who)) {
                return obName;
            }
        }
        return null;
    }

    public static Enemy FindEnemyObject(ArrayList<Enemy> enemies , String who){

        for (Enemy obName:
                enemies) {
            if (obName.getName().toLowerCase().equals(who)) {
                return obName;
            }
        }
        return null;
    }


    public static int FindEnemyIndex(ArrayList<Enemy> enemies, String who){
        int index = 0;
        for (Enemy enm:
                enemies) {
            if (enm.getName().toLowerCase().contains(who)) {
                index = enemies.indexOf(enm);
            }
        }
        return index;
    }

    public static Weapons FindWieldWeapon(Characters characters){

        for (Items itm:
                characters.getItems()){
            if (((Weapons) itm).isWield()) {
                return ((Weapons) itm);
            }
        }
        return null;
    }

    public static int FindItemIndex(ArrayList<Items> items, String which, String which1){

        try {
            if (which1 == null) {
                which1 = "";
            }

            for (Items itm:
                    items) {
                if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                    if (((Weapons) itm).getName().toLowerCase().contains(which+" "+which1) ) {
                        return items.indexOf(itm);
                    }
                } else if (ItemManagement.ClassNameForClothes(itm.displayClassName())) {
                    if (((Clothes)itm).getName().toLowerCase().contains(which+" "+which1)) {
                        return items.indexOf(itm);
                    }
                }
            }

        }catch (NullPointerException nullPointerException){
            System.out.println("Item couldn't found!");
            System.out.println("Check your command again!");
        }
        return -1;
    }

    private static int Score = 0;
    public static void ScoreCalculator(int point){
        Score += point;
    }

    public void SaveScore(){
        try {

            FileWriter Scores = new FileWriter("Scores.txt",true);

            Scores.write("" + getUserName() + " - " + Score + "\n");
            Scores.close();

        }catch (IOException err){
            err.printStackTrace();
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
    public static int getLevelNumber(){return levelNumber;}
}
