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
        setHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setMaxHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setUnTouchable(false);
        setHowMuchTurnWillStayOut(0);
    }
}
