package Characters;

import Game.ItemManagement;
import Game.Levels;
import Inventory.Clothes;
import Inventory.Items;
import Inventory.Wands.Prophecy;
import Inventory.Wands.Splinter;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Healer extends Characters{
    SecureRandom random = new SecureRandom();
    public Healer(){
        setName("Healer");
        setIntelligence(random.nextDouble(6,11));
        setStrength(random.nextDouble(3,8));
        setVitality(random.nextDouble(1,6));
        setItems(new ArrayList<>());
        getItems().add(new Splinter(true));
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
            if (dropped == null) {
                throw new NullPointerException("Item array is null!");
            }
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
        }catch (IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("Item couldn't find!");
        }
    }
    @Override
    public void Pick(ArrayList<Items> droppedItems,String which,String which1) {
        try {
            double limit = getStrength();

            if (droppedItems == null) {
                throw new NullPointerException("Dropped Item array is null!");
            }
            int index = Levels.FindItemIndex(droppedItems,which,which1);

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
        }catch (IndexOutOfBoundsException Exception){
            System.out.println("Item couldn't find!");
        }
    }
    @Override
    public void Wear(ArrayList<Items> items, String which, String which1) {
        try {
            if (which1 == null) {
                which1 = "";
            }

            if (items == null) {
                throw new NullPointerException("Item array is null!");
            }

            for (Items itm:
                    items) {
                if (ItemManagement.ClassNameForClothes(itm.displayClassName())) {
                    if (((Clothes) itm).getName().toLowerCase().equals(which+""+which1) ||
                            ((Clothes) itm).getName().toLowerCase().equals(which+" "+which1) &&
                                    !((Clothes) itm).isWore()) {
                        ((Clothes) itm).setWore(true);
                        System.out.println("" + getName() + " wore " + itm.displayName() + "!");
                    }
                    if (!((Clothes) itm).getName().toLowerCase().equals(which+""+which1) &&
                            !((Clothes) itm).getName().toLowerCase().equals(which+" "+which1) &&
                                    ((Clothes) itm).isWore()) {
                        ((Clothes) itm).setWore(false);
                        System.out.println("" + getName() + " took of " + itm.displayName() + "!");
                    }
                }
            }
        }catch (ClassCastException classCastException){
            System.out.println("Weapons cannot be worn!");
        }
    }
    @Override
    public void Wield(ArrayList<Items> items, String which, String which1) {
        try {
            if (which1 == null) {
                which1 = "";
            }
            if (items == null) {
                throw new NullPointerException("Item array is null!");
            }

            for (Items itm:
                    items) {
                if (ItemManagement.ClassNameForWeapons(itm.displayClassName())) {
                    if (((Weapons) itm).getName().toLowerCase().equals(which+""+which1) ||
                            ((Weapons) itm).getName().toLowerCase().equals(which+" "+which1) &&
                                    !((Weapons) itm).isWield()) {
                        ((Weapons) itm).setWield(true);
                        System.out.println("" + getName() + " wield " + itm.displayName() + "!");
                    }
                    if (!((Weapons) itm).getName().toLowerCase().equals(which+""+which1) &&
                            !((Weapons) itm).getName().toLowerCase().equals(which+" "+which1) &&
                                    ((Weapons) itm).isWield()) {
                        ((Weapons) itm).setWield(false);
                        System.out.println("" + getName() + " left " + itm.displayName() + "!");
                    }
                }
            }
        }catch (ClassCastException classCastException){
            System.out.println("Clothes cannot be wield!");
        }
    }
}
