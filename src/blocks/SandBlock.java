package blocks;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock() {
        this.blockName = "Sand";
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.falls_through = false;
    }

    public Block smelt() {
        return new GlassBlock();
    }
}
