package backend;
import blocks.Block;
import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {
    public int compare(Block a, Block b) {
        return a.toString().compareTo(b.toString());
    }
}
