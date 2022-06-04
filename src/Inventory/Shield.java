package Inventory;



public abstract class Shield extends Weapons{
    private int blockChance;
    private int stunTurn;
    public Shield(boolean isWield) {
        super(isWield);
        blockChance = 0;
        stunTurn = 0;
    }

    public abstract void CalculateBlockChance();

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Damage Multiplier: Vitality x" + getDamage());
        System.out.println("----------------------------");
    }


    public int getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(int blockChance) {
        this.blockChance = blockChance;
    }

    public int getStunTurn() {
        return stunTurn;
    }

    public void setStunTurn(int stunTurn) {
        this.stunTurn = stunTurn;
    }
}
