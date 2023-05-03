package ui;
import backend.AlphabeticalBlockComparator;
import blocks.*;
import exceptions.BlockErrorException;

import java.util.ArrayList;
import java.util.Comparator;

public class Inventory {
    private ArrayList<Block> inventory;
    private Comparator<Block> comparator;

    public Inventory() {
        this.inventory = new ArrayList<Block>();
        this.comparator = new AlphabeticalBlockComparator();
    }

    public void print() {
        for (Block b : this.inventory) {
            b.display_in_inventory();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void sort() {
        this.inventory.sort(this.comparator);
    }

    public void add_block(Block b) {
        this.inventory.add(b);
        this.sort();
    }

    public void remove_block(int index) {
        this.inventory.remove(index);
    }

    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException {
        Block block = this.inventory.get(index);
        if (!(block instanceof SmeltableBlock))
            throw new BlockErrorException();
        return (SmeltableBlock) block;
    }

    public Comparator<Block> get_comparator() {
        return this.comparator;
    }

    public void set_comparator(Comparator<Block> comparator) {
        this.comparator = comparator;
    }
}
