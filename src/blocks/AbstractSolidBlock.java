package blocks;

public abstract class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock() {
        super();
        this.falls_with_gravity = false;
        this.falls_through = false;
        this.pickable = true;
    }
}
