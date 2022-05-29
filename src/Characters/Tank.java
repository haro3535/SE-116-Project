package Characters;

import Game.Levels;
import Inventory.Clothes;
import Inventory.Items;
import Inventory.Weapons;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Tank extends Characters{
    SecureRandom random = new SecureRandom();
    public Tank(){
        setName("Healer");
        setIntelligence(random.nextDouble(3,8));
        setStrength(random.nextDouble(1,6));
        setVitality(random.nextDouble(6,11));
        setItems(new ArrayList<>());
        setHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setMaxHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setUnTouchable(false);
        setHowMuchTurnWillStayOut(0);
        setCharge(0);
        setUltiReady(false);
    }

    @Override
    public void Examine(ArrayList<Items> dropped, String which, String which1) {
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
    }

    @Override
    public void Pick(ArrayList<Items> droppedItems,String which,String which1) {
        double limit = getStrength();

        int index = Levels.FindItemIndex(droppedItems,which,which1);                // burda eğer item bulunamazsa diye önlem al
        double sumWeight = droppedItems.get(index).displayWeight();             // isim eşit olmasına rağmen  hatalı çalıştı
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
    }
    @Override
    public void Wear(ArrayList<Items> items, String which, String which1) {
        if (items == null || which == null ) {
            // burda exception yapabilirsin
            return;
        }

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
    }

    @Override
    public void Wield(ArrayList<Items> items, String which, String which1) {
        if (items == null || which == null ) {
            // burda exception yapabilirsin
            return;
        }

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
    }
}
