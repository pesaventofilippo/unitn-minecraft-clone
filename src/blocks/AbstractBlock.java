package blocks;

public abstract class AbstractBlock implements Block {
    String blockName;
    char contenuto;
    boolean falls_with_gravity;
    boolean falls_through;

    public char display() {
        return this.contenuto;
    }

    public boolean falls_with_gravity() {
        return this.falls_with_gravity;
    }

    public boolean falls_through() {
        return this.falls_through;
    }

    public String toString() {
        return this.blockName + "(" + this.contenuto + ")";
    }
}
