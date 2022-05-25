package Characters;


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
    }
}
