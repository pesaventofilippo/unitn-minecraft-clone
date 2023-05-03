package blocks;

public interface Block extends InventoryBlock {
    public char display();
    public boolean falls_with_gravity();
    public boolean falls_through();
    public boolean is_pickable();
}
