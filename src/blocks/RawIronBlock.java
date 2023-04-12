package blocks;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {
    public RawIronBlock() {
        super();
        this.blockName = "Raw Iron";
        this.contenuto = 'I';
    }

    public Block smelt() {
        return new IronSword();
    }
}
