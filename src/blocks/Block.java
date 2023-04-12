package blocks;

public interface Block {
    public char display();
    public boolean falls_with_gravity();
    public boolean falls_through();
}
