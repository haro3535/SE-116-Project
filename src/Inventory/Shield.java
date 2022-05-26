package Inventory;

public abstract class Shield extends Weapons{
    private int blockChance;
    public Shield(boolean isWield) {
        super(isWield);
        blockChance = 0;
    }

    public int getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(int blockChance) {
        this.blockChance = blockChance;
    }
}
