package ui;

import backend.Coordinates;
import blocks.AirBlock;

public class MainView {
    private Map map;
    private Furnace furnace;

    public MainView() {
        this.map = new Map();
        this.furnace = new Furnace();
    }

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
    }

    public void move_into_furnace(Coordinates coords) {
        if (this.map.is_smeltable_block_at(coords)) {
            this.furnace.setInput(this.map.get_smeltable_block_at(coords));
            this.map.insert_at_coords(coords, new AirBlock());
        }
    }

    public void smelt() {
        this.furnace.smelt();
    }
}
