package Heroes.shooters;

public class Crossbowman extends Shooter {
    public Crossbowman(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int camouflage, int arrows) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage, accuracy, camouflage, arrows);
    }

    public String getInfo() {
        return "Арбалетчик";
    }
}
