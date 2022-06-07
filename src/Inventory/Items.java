package Inventory;

public interface Items {
     void printInfo();

     String displayName();
     double displayWeight();
     String displayValue();
     String displayClassName();

     String[] WeaponsClassNames = {
             "Nethersbane","Skycutter","Prophecy","Cometfell","Infamy","Oblivion",
             "Soulblade","Splinter","Slayer",
     } ;

     String[] ClothesClassNames = {
             "David_s_Armor","Broken_Armor","Great_Armor","Old_Armor",
     } ;
}
