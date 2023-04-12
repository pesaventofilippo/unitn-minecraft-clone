package blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock() {
        this.falls_with_gravity = false;
        this.falls_through = false;
    }
}
