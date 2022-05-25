package Characters;

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
    }
}
