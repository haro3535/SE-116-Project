package Inventory;

public interface Items {
     void printInfo();

     String displayName();
     double displayWeight();
     String displayValue();
     String displayClassName();

     String[] WeaponsClassNames = {
             "Nethersbane","Skycutter","Prophecy","Cometfell","Infamy","Oblivion",
             "Soulblade","Splinter","Slayer","Holy_Wand","Crystal_Wand","Vigilante",
             "Nethersbane","Great_Shield","Broken_Shield","Aegis",
     } ;

     String[] ClothesClassNames = {
             "David_s_Armor","Broken_Armor","Great_Armor","Old_Armor","Kings_Armor",
     } ;
}
