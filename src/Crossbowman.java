public class Crossbowman extends BaseHero {
    private int accuracy;
    private int speed;

    public Crossbowman(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int speed) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.speed = speed;
    }

    public Crossbowman(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nSpeed: %d\n",super.getFullInfo(), this.accuracy, this.speed);
    }
}
