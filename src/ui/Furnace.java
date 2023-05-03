package ui;

import blocks.Block;
import blocks.NullBlock;
import blocks.SmeltableBlock;

public class Furnace {
    private SmeltableBlock input;
    private Block output;

    public Furnace() {
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void display_on_out() {
        System.out.println("|| " + this.input.display() + " --> " + this.output.display() + " ||");
    }

    public void smelt() {
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }

    public void setInput(SmeltableBlock input) {
        this.input = input;
    }

    public SmeltableBlock extractInput() {
        SmeltableBlock input = this.input;
        this.input = new NullBlock();
        return input;
    }

    public Block extractOutput() {
        Block output = this.output;
        this.output = new NullBlock();
        return output;
    }
}
