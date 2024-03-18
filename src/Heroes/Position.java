package Heroes;

public class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance(Position position) {
        return Math.sqrt(Math.pow(x - position.x, 2) + Math.pow(y - position.y, 2));
    }

    public Position getDifference(Position target) {
        return new Position(x - target.x, y - target.y);
    }

    public boolean equals (Position target) {
        return x == target.x && y == target.y;
    }
}
