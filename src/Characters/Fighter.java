package Characters;


import Game.Levels;
import Inventory.Clothes;
import Inventory.Items;
import Inventory.Swords.Cometfell;
import Inventory.Swords.Skycutter;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Fighter extends Characters{

    SecureRandom random = new SecureRandom();
    public Fighter(){
        setName("Fighter");
        setIntelligence(random.nextDouble(1,6));
        setStrength(random.nextDouble(6,11));
        setVitality(random.nextDouble(3,8));
        setItems(new ArrayList<>());
        getItems().add(new Cometfell(true));
        setHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setMaxHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setUnTouchable(false);
        setHowMuchTurnWillStayOut(0);
        setCharge(0);
        setUltiReady(false);
    }

    @Override
    public void Examine(ArrayList<Items> dropped, String which, String which1) {

        try {
            int index = Levels.FindItemIndex(dropped,which,which1);

            if (dropped.size() > 10) {
                System.out.println("" + dropped.get(index).displayName() + " examined by " + getName());
                for (Items itms:
                        dropped) {
                    itms.printInfo();
                }
            }else {
                System.out.println("" + dropped.get(index).displayName() + " examined by " + getName());
                dropped.get(index).printInfo();
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Dropped Item array is empty!");
        }
    }
    @Override
    public void Pick(ArrayList<Items> droppedItems,String which,String which1) {

        try {
            double limit = getStrength();

            int index = Levels.FindItemIndex(droppedItems,which,which1);
            if (index == -1) {
                throw new ArrayIndexOutOfBoundsException("Item couldn't found!");
            }

            double sumWeight = droppedItems.get(index).displayWeight();
            for (Items items:
                    getItems()) {
                sumWeight += items.displayWeight();
            }

            if (limit >= sumWeight) {
                getItems().add(droppedItems.get(index));
                System.out.println("" + getName() +  " picked " + droppedItems.get(index).displayName());
                droppedItems.remove(index);
            }else{
                System.out.println("" + getName() + " couldn't take " + droppedItems.get(index).displayName());
                System.out.println("Inventory is full!");
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Dropped Item array is empty!");
        }
    }

    @Override
    public void Wear(ArrayList<Items> items, String which, String which1) {

        try {
            if (which1 == null) {
                which1 = "";
            }

            for (Items itm:
                    items) {
                if (((Clothes) itm).getName().toLowerCase().equals(which+""+which1) && !((Clothes) itm).isWore()) {
                    ((Clothes) itm).setWore(true);
                    System.out.println("" + getName() + " wore " + itm.displayName() + "!");
                }
                if (!((Clothes) itm).getName().toLowerCase().equals(which+""+which1) && ((Clothes) itm).isWore()) {
                    ((Clothes) itm).setWore(false);
                }
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Item array is empty!");
        }
    }
    @Override
    public void Wield(ArrayList<Items> items, String which, String which1) {

        try {
            if (which1 == null) {
                which1 = "";
            }
            for (Items itm:
                    items) {
                if (((Weapons) itm).getName().toLowerCase().equals(which+""+which1) && !((Weapons) itm).isWield()) {
                    ((Weapons) itm).setWield(true);
                    System.out.println("" + getName() + " wore " + itm.displayName() + "!");
                }
                if (!((Weapons) itm).getName().toLowerCase().equals(which+""+which1) && ((Weapons) itm).isWield()) {
                    ((Weapons) itm).setWield(false);
                }
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Item array is empty!");
        }
    }
}
