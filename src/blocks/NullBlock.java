package blocks;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    public NullBlock() {
        super();
        this.blockName = "Null";
        this.contenuto = ' ';
    }

    public Block smelt() {
        return new NullBlock();
    }
}
