package ui;
import backend.*;
import blocks.AirBlock;
import exceptions.BlockErrorException;

public class MainView {
    private Map map;
    private Furnace furnace;
    private Inventory inventory;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
        this.inventory = new Inventory();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
    }

    public void move_into_furnace(Coordinates coords) {
        try {
            this.furnace.setInput(this.map.get_smeltable_block_at(coords));
            this.map.insert_at_coords(coords, new AirBlock());
        } catch (BlockErrorException e) {
            // pass
        }
    }

    public void smelt() {
        this.furnace.smelt();
        this.inventory.add_block(this.furnace.extractOutput());
    }

    public void move_into_furnace_from_inventory(int index) {
        try {
            this.furnace.setInput(this.inventory.get_smeltable_item(index));
            this.inventory.remove_block(index);
        } catch (BlockErrorException e) {
            // pass
        }
    }

    public void move_into_inventory_from_furnace() {
        this.inventory.add_block(this.furnace.extractInput());
    }

    public void pick_up_block(Coordinates coords) {
        try {
            this.inventory.add_block(this.map.get_pickable_block_at(coords));
            this.map.insert_at_coords(coords, new AirBlock());
        } catch (BlockErrorException e) {
            // pass
        }
    }

    public void toggle_inventory_comparator() {
        if (this.inventory.get_comparator() instanceof AlphabeticalBlockComparator)
            this.inventory.set_comparator(new BlockComparator());
        else
            this.inventory.set_comparator(new AlphabeticalBlockComparator());
    }
}
