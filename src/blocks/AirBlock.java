package blocks;

public class AirBlock extends AbstractBlock {
    public AirBlock() {
        this.blockName = "Air";
        this.contenuto = ' ';
        this.falls_with_gravity = false;
        this.falls_through = true;
    }
}
