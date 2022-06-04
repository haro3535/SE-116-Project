package Inventory;

public interface Items {
     void printInfo();

     String displayName();
     double displayWeight();
     String displayValue();
     String displayClassName();

     String[] WeaponsClassNames = {
             "Nethersbane","Skycutter","Prophecy","Cometfell","Infamy","Oblivion",
             "Soulblade","Splinter",
     } ;

     String[] ClothesClassNames = {
             "David_s_Armor",
     } ;
}
