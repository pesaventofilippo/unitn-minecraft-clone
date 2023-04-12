package ui;

import backend.Coordinates;
import blocks.*;
import java.util.Random;

public class Map {
    private Block[][] map;
    private int righe;
    private int colonne;

    public Map() {
        this(10, 10);
    }

    public Map(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.map = new Block[righe][colonne];
        for (int i = 0; i < righe; i++)
            for (int j = 0; j < colonne; j++)
                this.map[i][j] = new AirBlock();

        addRiver();

        Random rand = new Random();
        int r, c;
        for (int i = 0 ; i < 5; i++) {
            r = rand.nextInt(this.righe);
            c = rand.nextInt(this.colonne);
            insert_at_coords(new Coordinates(r, c), new SandBlock());
            r = rand.nextInt(this.righe);
            c = rand.nextInt(this.colonne);
            insert_at_coords(new Coordinates(r, c), new RawIronBlock());
        }
    }

    private Block get_block(Coordinates coords) {
        return this.map[coords.X()][coords.Y()];
    }

    private void set_block(Coordinates coords, Block block) {
        this.map[coords.X()][coords.Y()] = block;
    }

    public void display_on_out() {
        for (int i = 0; i < this.righe; i++) {
            for (int j = 0; j < this.colonne; j++) {
                System.out.print(get_block(new Coordinates(i, j)).display());
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    private void swap(Coordinates coords) {
        if (coords.X() == this.righe - 1)
            return;

        Block temp = get_block(coords);
        set_block(coords, get_block(coords.below()));
        set_block(coords.below(), temp);
    }

    public void insert_at_coords(Coordinates coords, Block block) {
        set_block(coords, block);

        if (coords.X() == this.righe - 1 || !block.falls_with_gravity())
            return;
        if (!get_block(coords.below()).falls_through())
            return;

        swap(coords);
        insert_at_coords(coords.below(), block);
    }

    private void addRowsOfWater() {
        for (int j = 0; j < this.colonne; j++)
            insert_at_coords(new Coordinates(0, j), new WaterBlock());
    }

    public void addRiver() {
        addRowsOfWater();
    }

    public void addSea() {
        for (int i = 0; i < 3; i++)
            addRowsOfWater();
    }

    public Block get_block_at(Coordinates coords) {
        return get_block(coords);
    }

    public SmeltableBlock get_smeltable_block_at(Coordinates coords) {
        Block block = get_block_at(coords);
        if (!(block instanceof SmeltableBlock))
            return null;
        return (SmeltableBlock) block;
    }

    public boolean is_smeltable_block_at(Coordinates coords) {
        return get_smeltable_block_at(coords) != null;
    }
}
