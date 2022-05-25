package Characters;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Enemy extends Characters{
    SecureRandom random = new SecureRandom();


    public Enemy(String name){
        super(name);
        setName("Enemy");
        setIntelligence(random.nextDouble(1,6));
        setStrength(random.nextDouble(1,6));
        setVitality(random.nextDouble(1,6));
        setItems(new ArrayList<>());
    }
}
