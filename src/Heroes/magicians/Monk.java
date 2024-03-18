package Heroes.magicians;

public class Monk extends Magician {
    public Monk(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int mana, int maxMana) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage, healing, mana, maxMana);
    }

    public String getInfo() {
        return "Монах";
    }
}
