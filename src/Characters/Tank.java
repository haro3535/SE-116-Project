package Characters;

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
    }
}
