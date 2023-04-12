package blocks;

public class WaterBlock extends AbstractBlock {
    public WaterBlock() {
        this.blockName = "Water";
        this.contenuto = 'W';
        this.falls_with_gravity = true;
        this.falls_through = true;
    }
}
