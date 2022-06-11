package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        loop = true;
        while (loop){

            displayMenu();
                String chose = scanner.nextLine();

                switch (chose) {
                    case "0" -> {
                        loop = false;
                        System.out.println("Game is closing...");
                    }
                    case "1" -> {
                        RegisterPlayer();
                        if (loop) {
                            Levels.setFinished(false);
                            Levels levels = new Levels();
                            while (!Levels.isFinished()) {
                                // Game Loop

                                levels.Turn(scanner);
                                if (Levels.isLevelUp()) {
                                    System.out.println("Next Level!");
                                    System.out.println("Level " + (Levels.getLevelNumber() - 1));
                                }
                            }
                        }
                    }
                    case "2" -> ShowScoreboard();
                    default -> {
                        System.out.println("Unaccepted value " + chose);
                        System.out.println("Try again!");
                    }
                }
        }
    }
    public static boolean loop;
    public static void RegisterPlayer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Welcome to Game ***");
        System.out.println("First you need to register to game ( For save your score )");
        System.out.println("For Exit type \" exit \" (With lower case) ");
        System.out.println("------------------------");
        System.out.print("Enter Your Username: ");
        String userName = scanner.nextLine();
        if (!userName.equals("exit")) {
            Levels.setUserName(userName);
            return;
        }
        loop = false;
    }

    public static void ShowScoreboard(){
        try {

            System.out.println();
            System.out.println("                *** Here is the Scoreboard ***");
            System.out.println("            ---------------------------------------");

            File readScoreboard = new File("Scores.txt");
            Scanner scoreboardReader = new Scanner(readScoreboard);


            int sizeOfFile = 0;
            while (scoreboardReader.hasNextLine()){
                scoreboardReader.nextLine();
                sizeOfFile++;
            }
            scoreboardReader.close();

            Integer[] array = new Integer[sizeOfFile];

            File readScoreboard1 = new File("Scores.txt");
            Scanner scoreboardReader1 = new Scanner(readScoreboard1);
            int i = 0;
            while (scoreboardReader1.hasNextLine()){
                String info = scoreboardReader1.nextLine();
                String[] splitInput = info.split(" - ");

                int IntegerPart = Integer.parseInt(splitInput[1]);
                array[i] = IntegerPart;
                i++;
            }

            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length-1; k++) {
                    if (array[k] < array[k+1]) {
                        int temp = array[k+1];
                        array[k+1] = array[k];
                        array[k] = temp;
                    }
                }
            }

            for (int j = 0; j < array.length; j++) {

                File readScoreboard2 = new File("Scores.txt");
                Scanner scoreboardReader2 = new Scanner(readScoreboard2);

                while (scoreboardReader2.hasNextLine()){
                    String info = scoreboardReader2.nextLine();
                    String[] splitInput = info.split(" - ");

                    int IntegerPart = Integer.parseInt(splitInput[1]);
                    if (IntegerPart == array[j]) {
                        System.out.println("" + (j+1) + ".            " + splitInput[0] + "      -     " + array[j] + " pt");
                    }
                }
                scoreboardReader2.close();
                if (j == 20) {
                    return;
                }
            }

        }catch (FileNotFoundException err){
            System.out.println(" Scores.txt file couldn't find!!");
        }
    }



    public static void displayMenu(){
        System.out.println();
        System.out.println("*** Welcome to Cannon Fodder ***");
        System.out.println("---------------------------------");
        System.out.println("Play - ( Enter 1 )");
        System.out.println("Show Scoreboard ( Enter 2 )");
        System.out.println("Exit - ( Enter 0 )");
        System.out.println("-----");
        System.out.println("-- Created by Harun Onur & Tarık Ali Dinçel--");
        System.out.println("---------------------------------");
        System.out.print("Enter: ");
    }
}


