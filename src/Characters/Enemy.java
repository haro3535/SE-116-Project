package Characters;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Enemy extends Characters{
    private boolean isStunned;
    private int howManyTurns;
    SecureRandom random = new SecureRandom();

    public Enemy(String name){
        super(name);
        setName("Enemy");
        setIntelligence(random.nextDouble(1,6));
        setStrength(random.nextDouble(1,6));
        setVitality(random.nextDouble(1,6));
        setHealthPoint(Math.round(0.7*getVitality() + 0.2*getStrength() + 0.1*getIntelligence()));
        setItems(new ArrayList<>());
        setStunned(false);
        setHowManyTurns(0);
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public int getHowManyTurns() {
        return howManyTurns;
    }

    public void setHowManyTurns(int howManyTurns) {
        this.howManyTurns = howManyTurns;
    }
}
