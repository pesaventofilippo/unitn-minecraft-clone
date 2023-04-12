package backend;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int X() {
        return this.x;
    }

    public int Y() {
        return this.y;
    }

    public boolean equals(Coordinates other) {
        return this.x == other.x && this.y == other.y;
    }

    public Coordinates above() {
        return new Coordinates(this.x - 1, this.y);
    }

    public Coordinates below() {
        return new Coordinates(this.x + 1, this.y);
    }

    public Coordinates left() {
        return new Coordinates(this.x, this.y - 1);
    }

    public Coordinates right() {
        return new Coordinates(this.x, this.y + 1);
    }
}
