package Heroes.magicians;

import Heroes.BaseHero;

import java.util.ArrayList;

public class Wizard extends Magician {
    public Wizard(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int mana, int maxMana) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage, healing, mana, maxMana);
    }

    public String getInfo() {
        return "Волшебник";
    }
}
